<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>${issueForComment.name}</h2>
<h3><a href="${pageContext.request.contextPath}/">Back to Issues list</a></h3>
<br>
<br>
<div><strong>Status: </strong>${issueForComment.status}</div>
<div><strong>Start date: </strong>${issueForComment.dateOfCreation}</div>
<div><strong>Author: </strong>${issueForComment.author}</div>
<div><strong>Description: </strong></div>
<div>${issueForComment.description}</div>
<div>${issueForComment.id}</div>
<br>
<div><strong>Comments: </strong></div>
<br>
<c:forEach var="listComment" items="${listComment}">
    <div>Update by: ${listComment.commentAuthor} ${listComment.dateOfComment}</div>
    <div>Status changed to: ${listComment.statusOfComment} </div>
    <div>${listComment.comment} </div>
    <br>

</c:forEach>
<br>
<div><strong>Add comment: </strong></div>
<form:form method="post" modelAttribute="issueComment" action="addComment">
    <form:hidden path="issue.id"/>
    <table border="1" width="400">
        <tr>
            <td>Status:</td> <td> <form:select path="statusOfComment">

            <form:option value="Created" label="Created"/>
            <form:option value="Resolved" label="Resolved"/>
            <form:option value="Closed" label="Closed"/>
                    </form:select>
        </td>
        </tr>
                     <tr>
            <td>Author:</td>
            <td><form:input path="commentAuthor" /></td>
                         <form:errors path="commentAuthor"/>


        </tr>
        <tr>
            <td>Text:</td>
            <td><form:textarea path="comment" /></td>
            <form:errors path="comment"/>


        </tr>


        <td colspan="3"><input type="submit" value="Add" /></td>

    </table>
</form:form>

<br>
<br>





<br>



</body>
</html>