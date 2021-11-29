package com.zakat.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class IssueComment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment_author")
    @NotEmpty(message = "author is required")
    private String commentAuthor;
    @Column(name = "date_of_comment")
    private String dateOfComment;
    @Column(name = "status_of_comment")
    private String statusOfComment;
    @Column(name = "comment")
    @NotEmpty(message = "comment is required")
    private String comment;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "issue_id")
        private Issue issue;

    public IssueComment() {
    }

    public IssueComment(String commentAuthor, String dateOfComment, String statusOfComment, String comment) {
        this.commentAuthor = commentAuthor;
        this.dateOfComment = dateOfComment;
        this.statusOfComment = statusOfComment;
        this.comment = comment;
    }


    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(String dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public String getStatusOfComment() {
        return statusOfComment;
    }

    public void setStatusOfComment(String statusOfComment) {
        this.statusOfComment = statusOfComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "IssueComment{" +
                "id=" + id +
                ", commentAuthor='" + commentAuthor + '\'' +
                ", dateOfComment='" + dateOfComment + '\'' +
                ", statusOfComment='" + statusOfComment + '\'' +
                ", comment='" + comment + '\'' +
                ", issue=" + issue +
                '}';
    }
}
