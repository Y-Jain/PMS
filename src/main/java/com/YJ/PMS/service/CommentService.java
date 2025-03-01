package com.YJ.PMS.service;

import com.YJ.PMS.modal.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId, Long userId,String comment) throws Exception;
    void deleteComment(Long userId, Long commentId) throws Exception;
    List<Comment> findCommentByIssueId(Long issueId);
}
