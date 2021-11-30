package com.zakat.myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trackerdb")
public class Issue {

    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 5, message = "Name must be min 5 symbols")
    private String name;
    @Column(name = "author")
    @NotEmpty(message = "this is required field")
    private String author;
    @Column(name = "status")
    private String status;
    @Column(name = "date_of_create")
    private String dateOfCreation;
    @Column(name = "description")
    @NotEmpty(message = "this is required field")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issue")
    private List<IssueComment> commentList;

    public Issue() {
    }

    public Issue(String name, String author, String status, String dateOfCreation, String description) {
        this.name = name;
        this.author = author;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
    }

    public List<IssueComment> getCommentList() {
        return commentList;
    }

    public void addCommentToIssue(IssueComment issueComment) {
        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        commentList.add(issueComment);
        issueComment.setIssue(this);
    }

    public void setCommentList(List<IssueComment> commentList) {
        this.commentList = commentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
