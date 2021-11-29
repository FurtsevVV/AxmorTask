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