<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Issue Tracker</h2>
<br>
<br>
<br>
<br>

<input type="button" value="Add Issue" onclick="window.location.href='newIssue'"/>

<br>
<h3>Sorting</h3>
<form:form modelAttribute="sortedStatus" action="/sortByStatus">
<table border="1" width="400">

    <tr>
        <td>Sort by Status:</td> <td> <form:select path="sortedStatus">
        <form:option value="Created" label="Created"/>
        <form:option value="Resolved" label="Resolved"/>
        <form:option value="Closed" label="Closed"/>
            </form:select>
    </td>
    </tr>

    <td colspan="3"><input type="submit" value="Sorting" /></td>
</table>
</form:form>


<table>
    <tr>
        <th>Issue: </th>
        <th>Status:   </th>
        <th>Date:     </th>

    </tr>
    <c:forEach var="issues" items="${allIssues}">
        <c:url var="updateButton" value="/viewandcomment">
            <c:param name="issueId" value="${issues.id}"/>
        </c:url>

        <tr>

            <td><a href="${updateButton}">${issues.name}</a></td>
            <td>${issues.status}</td>
            <td>${issues.dateOfCreation}</td>

        </tr>
    </c:forEach>

</table>
<br>
</body>
</html>
