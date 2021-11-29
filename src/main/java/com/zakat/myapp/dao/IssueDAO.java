package com.zakat.myapp.dao;

import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class IssueDAO implements IssueDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Issue> getAllIssue() {
        Session session = sessionFactory.getCurrentSession();
        List<Issue> issueList= session.createQuery("from Issue", Issue.class).getResultList();


        return issueList;
    }

    @Override
    public void saveNewIssue(Issue issue) {
        Session session = sessionFactory.getCurrentSession();
session.saveOrUpdate(issue);
    }

    @Override
    public List<IssueComment> getCommentList(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM issue_tracker.comments where issue_id = :issue_id").addEntity(IssueComment.class);
query.setParameter("issue_id", id);
return (List<IssueComment>)query.list();

    }

    @Override
    public Issue getIssueById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Issue.class, id);
    }
}
