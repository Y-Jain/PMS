package com.YJ.PMS.request;

import com.YJ.PMS.modal.Project;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IssueRequest {
    private String title;
    public String getTitle() {
        return title;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    private String status;
    public String getStatus() {
        return status;
    }
    private Long projectId;
    public Long getProjectId() {
        return projectId;
    }
    private String priority;
    public String getPriority() {
        return priority;
    }
    private LocalDate dueDate;
    public LocalDate getDueDate() {
        return dueDate;
    }
}
