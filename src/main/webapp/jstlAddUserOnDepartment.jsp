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
            <div class="p-3 mb-2 bg-gradient-secondary text-white"><h1>Department number ${requestScope.user.department}</h1></div>
        </div>

        <ul class="navbar-nav">
            <li><a href="/webappsample/jstlDepartment"
                   class="nav-link"><h3> Return</h3></a></li>
        </ul>

    </nav>
</header>
<br/>
<c:if test="${requestScope.departmentUsers != null}">
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

        </tr>
        </thead>
        <c:forEach var="departmentUsers" items="${requestScope.departmentUsers}">
            <tr>
                <td scope="row">${departmentUsers.id}</td>
                <td>${departmentUsers.firstName}</td>
                <td>${departmentUsers.lastName}</td>
                <td>${departmentUsers.department}</td>
                <td>${departmentUsers.birthdate}</td>
                <td><c:choose>
                    <c:when test="${departmentUsers.male}">Male</c:when>
                    <c:otherwise>Female</c:otherwise>
                </c:choose></td>
                <td>${departmentUsers.salary}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br/>
<br/>
</body>
</html>
