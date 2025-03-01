package com.YJ.PMS.request;

import lombok.Data;

@Data
public class CreateMessageRequest {
    private String content;
    public String getContent() {
        return content;
    }
    private Long senderId;
    public Long getSenderId() {
        return senderId;
    }
    private Long projectId;
    public Long getProjectId() {
        return projectId;
    }
}
