package com.YJ.PMS.request;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String comment;
    public String getComment() {
        return comment;
    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
    private Long issueId;
    public Long getIssueId() {
        return issueId;
    }
//    public void setPassword(Long issueId) {
//        this.issueId = issueId;
//    }
}
