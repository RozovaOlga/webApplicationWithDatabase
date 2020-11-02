<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
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

<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${requestScope.user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${requestScope.user == null}">
                <form action="user" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${requestScope.user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${requestScope.user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${requestScope.user != null}">
                        <input type="hidden" name="id" value="<c:out value='${requestScope.user.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>firstName</label> <input type="text"
                                                        value="<c:out value='${requestScope.user.firstName}' />"
                                                        class="form-control"
                                                        name="firstName">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>lastName</label> <input type="text"
                                                       value="<c:out value='${requestScope.user.lastName}' />"
                                                       class="form-control"
                                                       name="lastName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>department</label> <input type="text"
                                                         value="<c:out value='${requestScope.user.department}' />"
                                                         class="form-control"
                                                         name="department">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>birthdate</label> <input type="text"
                                                        value="<c:out value='${requestScope.user.birthdate}' />"
                                                        class="form-control"
                                                        name="birthdate">
                    </fieldset>
                    <fieldset class="form-group">
                        <input type="radio" id="male" name="male" value="true">
                        <label for="male">Male</label><br>
                        <input type="radio" id="female" name="male" value="false">
                        <label for="female">Female</label><br>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>salary</label> <input type="text"
                                                     value="<c:out value='${requestScope.user.salary}' />"
                                                     class="form-control"
                                                     name="salary">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>