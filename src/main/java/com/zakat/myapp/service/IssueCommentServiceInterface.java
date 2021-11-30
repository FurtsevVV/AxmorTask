package com.zakat.myapp.service;

import com.zakat.myapp.entity.IssueComment;

public interface IssueCommentServiceInterface {

    public void saveNewIssueComment(IssueComment issueComment, int issueIdFromComment);
}
