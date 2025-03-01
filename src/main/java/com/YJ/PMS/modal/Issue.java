package com.YJ.PMS.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

//import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
//    public void setId(Long Id) {
//        this.id = id;
//    }

    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private Long projectID;
    public Long getProjectID() {
        return projectID;
    }
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
    private String priority;
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    private LocalDate dueDate;
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    private List<String> tags = new ArrayList<>();
    public List<String> getTags() {
        return tags;
    }

    @ManyToOne
    private User assignee;
    public User getAssignee() {
        return assignee;
    }
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @JsonIgnore
    @ManyToOne
    private Project project;
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    public List<Comment> getComments() {
        return comments;
    }
}
