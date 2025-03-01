package com.YJ.PMS.repository;

import java.util.List;
import com.YJ.PMS.modal.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    public List<Issue> findByProjectId(Long id);
}
