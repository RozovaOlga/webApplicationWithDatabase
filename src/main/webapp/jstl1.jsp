<%@ page import="by.grodno.home.webappsample.service.Department" %>
<%@ page import="by.grodno.home.webappsample.service.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #f8c02c">
        <div>
            <div class="p-3 mb-2 bg-gradient-secondary text-white"><h1>User Table</h1></div>
        </div>

        <ul class="navbar-nav">
            <li><a href="/webappsample/"
                   class="nav-link"><h3> Return</h3></a></li>
        </ul>

    </nav>
</header>
<br/>
<c:if test="${requestScope.users != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Department</th>
            <th scope="col">Birthdate</th>
            <th scope="col">Sex</th>
            <th scope="col">Salary</th>
            <th scope="col">NameDepartment</th>
            <th scope="col">Actions</th>

        </tr>
        </thead>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td scope="row">${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.department}</td>
                <td>${user.birthdate}</td>
                <td><c:choose>
                    <c:when test="${user.male}">Male</c:when>
                    <c:otherwise>Female</c:otherwise>
                </c:choose></td>
                <td>${user.salary}</td>
                <td>${user.departmentGetFromDatabase.name}</td>
                <td><a class="btn btn-warning"
                       href="update?number=${user.id}">Edit
                    user</a>
                    <a class="btn btn-warning"
                       href="user/delete?number=${user.id}">Delete
                        user</a>

                </td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<a class="btn btn-primary"
   href="jstl2.jsp">Add user</a>

<br/>
<br/>
</body>
</html>
