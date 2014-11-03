<%-- 
    Document   : addUser
    Created on : Nov 3, 2014, 10:30:30 AM
    Author     : apprentice
--%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <sf:form action="addUser" method="post" cssClass="form-horizontal" modelAttribute="newUser">
                <div class="form-group">
                    <sf:label path="name" cssClass="col-sm-2 control-label">Name</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="name" type="text" cssClass="form-control" name="name"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="userName" cssClass="col-sm-2 control-label">Username</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="userName" type="text" cssClass="form-control" name="userName"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="password" cssClass="col-sm-2 control-label">Password</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="password" type="password" cssClass="form-control" name="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="goodStanding" cssClass="col-sm-2 control-label">Standing</sf:label>
                        <div class="col-sm-10">
                        <sf:select path="goodStanding" name="standing">
                            <sf:option value="true">True</sf:option>
                            <sf:option value="false">False</sf:option>
                        </sf:select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-3">
                        <input type="submit" class="form-control btn btn-primary" value="Add User"/>
                    </div>
                </div>
            </sf:form>

            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
