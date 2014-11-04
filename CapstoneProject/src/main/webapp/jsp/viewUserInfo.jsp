<%-- 
    Document   : viewUserInfo
    Created on : Oct 29, 2014, 2:59:39 PM
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
        <title>User Info</title>
        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="container">
                <div class="row" style="margin-bottom: 20px">
                    <div class="col-md-2">
                        <a href="userAddNote?userId=${user.userId}" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a><br/><br/>
                        <a href="editUser?userId=${user.userId}" class="btn btn-primary glyphicon glyphicon-plus" data-toggle="modal">Edit User</a>
                    </div>
                </div>
            </div>
            
            
            <div class="col-md-8">
                <table class="table table-hover">

                    <tr>

                        <th>Name</th>
                        <th>Username</th>
                        <th>Stading</th>
                        <th>Enabled</th>
                        <th>Events/Assets</th>
                    </tr>
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.userName}</td>
                        <td>${user.standing}</td>
                        <td>${user.enabled}</td>
                        <jstl:forEach var="event" items="${events}">
                            <td>
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
                            </td>
                        </jstl:forEach>

                    <div class="col-md-8">
                        <table class="table table-hover">
                            <tr>
                                <th>User Notes</th>
                            </tr>
                            <tr>
                                <jstl:forEach var="userNotes" items="${userNotes}">
                                    <td>${userNotes.note}</td>
                                </jstl:forEach>
                            </tr>

                        </table>
                    </div>


                    <jsp:include page="include/footer.jsp"/>
            </div>
    </body>
</html>
