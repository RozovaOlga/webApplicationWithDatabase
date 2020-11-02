<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Department Management Application</title>
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
            <div class="p-3 mb-2 bg-gradient-secondary text-white"><h1>Department Table</h1></div>
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
            <c:if test="${requestScope.department != null}">
            <form action="/webappsample/jstlDepartment/update" method="post">
                </c:if>
                <c:if test="${requestScope.department == null}">
                <form action="/webappsample/jstlDepartment/new" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${requestScope.department != null}">
                                Edit department
                            </c:if>
                            <c:if test="${requestScope.department == null}">
                                Add New department
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${requestScope.department != null}">
                        <input type="hidden" name="id" value="<c:out value='${requestScope.department.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>name</label> <input type="text"
                                                        value="<c:out value='${requestScope.department.name}' />" class="form-control"
                                                        name="name" >
                    </fieldset>

                    <fieldset class="form-group">
                        <label>location</label> <input type="text"
                                                       value="<c:out value='${requestScope.department.location}' />" class="form-control"
                                                       name="location">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>