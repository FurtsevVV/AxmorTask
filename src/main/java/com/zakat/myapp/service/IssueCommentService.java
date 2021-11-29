package com.zakat.myapp.service;

import com.zakat.myapp.dao.IssueCommentDAO;
import com.zakat.myapp.dao.IssueDAO;
import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class IssueCommentService implements IssueCommentServiceInterface {

    @Autowired
private IssueCommentDAO issueCommentDAO;

    @Autowired
    private IssueDAO issueDAO;


    @Override
    @Transactional
    public void saveNewIssueComment(IssueComment issueComment, int issueIdFromComment) {
IssueComment newIssueComment = new IssueComment();
newIssueComment.setCommentAuthor(issueComment.getCommentAuthor());
newIssueComment.setComment(issueComment.getComment());
newIssueComment.setStatusOfComment(issueComment.getStatusOfComment());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String date = formatForDateNow.format(calendar.getTime());
        newIssueComment.setDateOfComment(date);
        Issue issue = issueDAO.getIssueById(issueIdFromComment);
newIssueComment.setIssue(issue);

issueCommentDAO.saveNewIssueComment(newIssueComment);
    }
}
