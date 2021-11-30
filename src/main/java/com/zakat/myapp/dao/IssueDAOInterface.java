package com.zakat.myapp.dao;


import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;

import java.util.List;

public interface IssueDAOInterface {
    public List<Issue> getAllIssue();

    public void saveNewIssue(Issue issue);

    public List<IssueComment> getCommentList(int id);

    public Issue getIssueById(int id);

    public List<Issue> sortByStatus(String requestedStatus);
}
