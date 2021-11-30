package com.zakat.myapp.controller;


import com.zakat.myapp.entity.Issue;
import com.zakat.myapp.entity.IssueComment;
import com.zakat.myapp.entity.SortedStatus;
import com.zakat.myapp.service.IssueCommentServiceInterface;
import com.zakat.myapp.service.IssueServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {

    @Autowired
private IssueServiceInterface issueService;

    @Autowired
    private IssueCommentServiceInterface issueCommentService;

    @RequestMapping("/")
public String mainScreen(Model model) {
    List<Issue> issuesList = issueService.getAllIssue();
        SortedStatus sortedStatus = new SortedStatus();
        model.addAttribute("sortedStatus", sortedStatus);
    model.addAttribute("allIssues", issuesList);
    return "index";
}

    @RequestMapping("/newIssue")
    public String addNewIssue(Model model) {
        Issue issue = new Issue();
        model.addAttribute("newIssue", issue);
        return "create_issue";
    }

    @RequestMapping("/saveIssue")
    public String saveNewIssue(@Valid @ModelAttribute("newIssue") Issue issue, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create_issue";
        }
        issueService.saveNewIssue(issue);

        return "redirect:/";
    }

@RequestMapping("/viewandcomment")
    public String viewAndComment(@RequestParam("issueId")int id, Model model){
        List<IssueComment> listComment = issueService.getCommentList(id);
        Issue issueForComment = issueService.getIssueById(id);
        IssueComment issueComment = new IssueComment();
        issueComment.setIssue(issueForComment);
        model.addAttribute("listComment", listComment);
        model.addAttribute("issueForComment", issueForComment);
        model.addAttribute("issueComment", issueComment);
        return "view-and-comment";
}

@RequestMapping("/addComment")
    public String addComment(@Valid @ModelAttribute("issueComment")IssueComment issueComment, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "view-and-comment";
        }
    System.out.println(issueComment.toString());
    int issueIdFromComment = issueComment.getIssue().getId();
    Issue issueFromComment = issueService.getIssueById(issueIdFromComment);
    System.out.println(issueIdFromComment);
    issueFromComment.setStatus(issueComment.getStatusOfComment());
    System.out.println(issueFromComment);
    issueService.saveNewIssue(issueFromComment);
    issueCommentService.saveNewIssueComment(issueComment, issueIdFromComment);
    return "redirect:/";
}

@RequestMapping("/sortByStatus")
    public String sortByStatus(@ModelAttribute("sortedStatus")SortedStatus sortedStatus, Model model){
String requestedStatus = sortedStatus.getSortedStatus();
List<Issue> sortedIssueList = issueService.sortByStatus(requestedStatus);
model.addAttribute("sortedIssue", sortedIssueList);
return "sorting-issue";
}




}
