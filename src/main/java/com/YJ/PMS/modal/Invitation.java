package com.YJ.PMS.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    private String email;
    public void setEmail(String email) {
        this.email = email;
    }
    private Long ProjectId;
    public Long getProjectId() {
        return ProjectId;
    }
    public void setProjectId(Long projectId) {
        this.ProjectId = ProjectId;
    }

}
