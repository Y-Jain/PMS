package com.YJ.PMS.Controller;

import com.YJ.PMS.modal.Comment;
import com.YJ.PMS.modal.User;
import com.YJ.PMS.request.CreateCommentRequest;
import com.YJ.PMS.response.MessageResponse;
import com.YJ.PMS.service.CommentService;
import com.YJ.PMS.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentRequest req,
                                                 @RequestHeader("Authorization")String jwt)throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Comment createComment = commentService.createComment(
                req.getIssueId(),user.getId(),req.getComment());
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);

    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<MessageResponse> deleteComment(@PathVariable Long commentId, @RequestHeader("Authorization")String jwt)throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        commentService.deleteComment(commentId, user.getId());
        MessageResponse res = new MessageResponse();
        res.setMessage("Comment deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity<List<Comment>> getCommentsByIssueId(@PathVariable Long issueId){
        List<Comment> comments=commentService.findCommentByIssueId(issueId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
