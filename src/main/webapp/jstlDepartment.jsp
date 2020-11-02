<%@page import="by.grodno.home.webappsample.service.Department" %>
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
            <div class="p-3 mb-2 bg-gradient-secondary text-white"><h1>Departmen Table</h1></div>
        </div>

        <ul class="navbar-nav">
            <li><a href="/webappsample/"
                   class="nav-link"><h3> Return</h3></a></li>
        </ul>
    </nav>
</header>

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<br/>


<c:if test="${requestScope.departments != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach var="department" items="${requestScope.departments}">
            <tr>
                <td scope="row"><a href="jstlDepartment/departmentUsers?id=<c:out value='${department.id}' />" title="Можно тыкать">${department.id}</a></td>
                <td>${department.name}</td>
                <td>${department.location}</td>
                <td>
                    <a class="btn btn-warning"
                       href="jstlDepartment/edit?id=<c:out value='${department.id}'/>">Edit
                    </a>
                    <a class="btn btn-warning"
                       href="jstlDepartment/delete?id=<c:out value='${department.id}' />">Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a class="btn btn-primary"
   href="jstlAddDepartment.jsp">Add user</a>

<br/>
<br/>
</body>
</html>
