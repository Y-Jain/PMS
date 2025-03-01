package com.YJ.PMS.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteRequest {
    private Long projectId;
    public Long getProjectId() {
        return projectId;
    }
    private String email;
    public String getEmail() {
        return email;
    }
}
