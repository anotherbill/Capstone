<%-- 
    Document   : editUser
    Created on : Nov 3, 2014, 10:37:38 AM
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

            <sf:form action="editUser" method="post" cssClass="form-horizontal" role="form" modelAttribute="user">
                <div class="form-group">
                    <sf:label path="name" cssClass="col-sm-2 control-label">Name</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="name" type="text" cssClass="form-control" id="name" placeholder="Name" name="name"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="userName" cssClass="col-sm-2 control-label">Username</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="userName" type="text" cssClass="form-control" id="user" placeholder="Username" name="userName"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="password" cssClass="col-sm-2 control-label">Password</sf:label>
                        <div class="col-sm-10">
                        <sf:input path="password" type="password" cssClass="form-control" id="location" placeholder="password" name="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label path="goodStanding" cssClass="col-sm-2 control-label">Standing</sf:label>
                        <div class="col-sm-10">
                        <sf:select path="goodStanding" name="standing">
                            <sf:option value="good">Good</sf:option>
                            <sf:option value="iffy">Iffy</sf:option>
                            <sf:option value="bad">Bad</sf:option>
                        </sf:select>
                    </div>
                </div>

                <div class="form-group">
                    <sf:label path="enabled" cssClass="col-sm-2 control-label">Enabled</sf:label>
                        <div class="col-sm-10">
                        <sf:select path="enabled" name="enabled">
                            <sf:option value="true">Yes</sf:option>
                            <sf:option value="false">No</sf:option>
                        </sf:select>
                    </div>
                </div>

                <sf:hidden path="userId" value="userId"/>

                <sf:label path="events" cssClass="col-sm-2 control-label">Events</sf:label>

                <jstl:forEach var="event" items="${events}">
                    <div class="col-md-12"> 

                        <table class="table table-hover">

                            <tr>
                                <th></th>
                                <th>Event Name</th>
                                <th>check Out Date</th>
                                <th>Due Date</th>
                                <th>Assets</th>
                            </tr>
                            <tr>
                                <td><img class="image-responsive" src="${types.imagePath}" alt="..."></td>
                                <td>${event.eventName}</td>
                                <td>${event.checkOutDate}</td>
                                <td>${event.dueDate}</td>
                                <jstl:forEach var="assets" items="${eventAssets}">
                                    <td>${event.assets}</td>
                                <tr/>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </jstl:forEach>


                        </table>
                    </div>
                </jstl:forEach>



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
