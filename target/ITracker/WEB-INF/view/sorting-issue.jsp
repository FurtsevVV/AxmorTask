<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Sort issue</h2>
<h2><a href="${pageContext.request.contextPath}/">Back to Issues list</a></h2>
<br>

<table>
    <tr>
        <th>Issue: </th>
        <th>Status:   </th>
        <th>Date:     </th>

    </tr>
    <c:forEach var="issues" items="${sortedIssue}">
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
</body>
</html>