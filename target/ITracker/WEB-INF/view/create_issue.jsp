<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Create issue</h2>
<h2><a href="${pageContext.request.contextPath}/">Back to Issues list</a></h2>
<br>

<form:form action="saveIssue" modelAttribute="newIssue">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    Author: <form:input path="author"/>
    <form:errors path="author"/>
     <br>
    Description: <form:textarea path="description"/>
    <form:errors path="description"/>
    <br>
    <input type="submit" value="Add!">

</form:form>
</body>
</html>