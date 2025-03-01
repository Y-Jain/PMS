package com.YJ.PMS.service;

import java.util.List;
import com.YJ.PMS.modal.Issue;
import com.YJ.PMS.modal.User;
import com.YJ.PMS.request.IssueRequest;

import java.util.Optional;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception ;

    List<Issue> getIssueByProjectId(Long projectId) throws Exception ;

    Issue createIssue(IssueRequest issue, User user) throws Exception;


    void deleteIssue(Long issueId,Long userid) throws Exception;

    Issue addUserToIssue(Long issueId, Long userid) throws Exception;

    Issue updateStatus(Long issueId,String status) throws Exception;


}
