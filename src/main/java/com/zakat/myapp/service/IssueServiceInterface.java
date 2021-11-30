package com.zakat.myapp.service;


import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;

import java.util.List;

public interface IssueServiceInterface {

    public List<Issue> getAllIssue();

   public void saveNewIssue(Issue issue);

  public   List<IssueComment> getCommentList(int id);

   public Issue getIssueById(int id);

   public List<Issue> sortByStatus(String requestedStatus);
}
