package com.YJ.PMS.modal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    private Long id;
    public void setId(Long Id) {
        this.id = id;
    }
    private String title;
    public void setTitle(String title) {
        this.title = title;
    }
    private String description;
    public void setDescription(String description) {
        this.description = description;
    }
    private String status;
    public void setStatus(String status) {
        this.status = status;
    }
    private Long projectID;
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
    private String priority;
    public void setPriority(String priority) {
        this.priority = priority;
    }
    private LocalDate dueDate;
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    private List<String> tags =new ArrayList<>();
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    private Project project;
    public void setProject(Project project) {
        this.project = project;
    }
    private User assignee;
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
