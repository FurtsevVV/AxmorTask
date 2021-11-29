package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueCommentDAO implements IssueCommentDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveNewIssueComment(IssueComment newIssueComment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(newIssueComment);
            }


}
