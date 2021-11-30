package com.zakat.myapp.service;


import com.zakat.myapp.dao.IssueDAO;
import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IssueService implements IssueServiceInterface {

    @Autowired
    private IssueDAO issueDAO;

    @Override
    @Transactional
    public List<Issue> getAllIssue() {

        return issueDAO.getAllIssue();
    }

    @Override
    @Transactional
    public void saveNewIssue(Issue issue) {
        if(issue.getId()==0) {
            issue.setStatus("Created");
        }
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String date = formatForDateNow.format(calendar.getTime());
issue.setDateOfCreation(date);
issueDAO.saveNewIssue(issue);
    }

    @Override
    @Transactional
    public List<IssueComment> getCommentList(int id) {
        return issueDAO.getCommentList(id);
    }

    @Override
    @Transactional
    public Issue getIssueById(int id) {
       return issueDAO.getIssueById(id);
    }

    @Override
    @Transactional
    public List<Issue> sortByStatus(String requestedStatus) {
        return issueDAO.sortByStatus(requestedStatus);
    }
}
