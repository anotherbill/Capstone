<%-- 
    Document   : editEvent
    Created on : Oct 29, 2014, 11:10:49 AM
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
        <title>Edit Event</title> 
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="bootstrapvalidator-0.5.2/dist/css/bootstrapValidator.min.css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/mycss.css" rel="stylesheet"/>

        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>

    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <a href="viewEventInfo?eventId=${event.eventId}" class="btn btn-default">< Back to Event Info</a><br><br>
                </div>
            </div>

            <div class="row">

                <div class="col-md-12"> 
                    <table class="table table-hover">
                        <tr>
                            <th>Event</th>
                            <th>User Name</th>
                            <th>Start Date</th>
                            <th>Due Date</th>
                            <th>Open</th>
                        </tr>
                        <tr>
                            <td>${event.eventName}</td>
                            <td>${event.user.name}</td>
                            <td>${event.checkOutDate}</td>
                            <td>${event.dueDate}</td>
                            <td>${event.open}</td>
                        </tr>
                    </table>
                    <sf:form id="editEvent" role="form" action="submitEditEvent" method="post" modelAttribute="event" cssClass="form-inline">
                        <div class="form-group">
                            <sf:input path="eventName" type="text" cssClass="form-control" id="name" name="eventName" cssStyle="width:180px"/>
                        </div>
                        <div class="form-group">
                            <sf:input path="user.userName" type="text" cssClass="form-control" id="user" name="userName" cssStyle="width:195px"/>
                        </div>
                        <div class="form-group">
                            <sf:input path="checkOutDate"  type="date" cssClass="form-control" id="startDate" name="checkOutDate" cssStyle="width:235px"/>
                        </div>
                        <div class="form-group">
                            <sf:input path="dueDate" type="date" cssClass="form-control" id="endDate" name="dueDate" cssStyle="width:225px"/>
                        </div>
                        <div class="form-group">
                            <select class="form-control" name="open">
                                <option value="true">True</option>
                                <option value="false">False</option>
                            </select>
                        </div>
                        <sf:hidden path="eventId" value="${event.eventId}"/>
                        <sf:hidden path="user.userId" value="${user.userId}"/><br><br>
                        <input type="submit" value="Edit Event" class="btn btn-primary"/>
                    </sf:form>
                </div>
            </div>


            <br>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr>
                            <th>Asset Type</th>
                            <th>Category</th>
                            <th>Availability</th>
                            <th>Damage</th>
                            <th>Serial Number</th>
                            <th>Actions</th>
                        </tr>
                        <tr>
                            <jstl:forEach var="assets" items="${assetCheckedOutList}">
                                <td>${asset.assetType.name}</td>
                                <td>${asset.assetType.category.categoryName}</td>
                                <td>${asset.inStock}</td>
                                <td>${asset.damageStatus}</td>
                                <td>${asset.serialNumber}</td>
                                <td>
                                    <a href="viewAssetNotes?assetId=${asset.assetId}" role="button" class="btn btn-primary glyphicon glyphicon-list-alt">View Asset Notes</a><br/><br/>
                                    <a href="checkInAsset?assetId=${asset.assetId}" role="button" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a>
                                </td>
                            </jstl:forEach>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <jsp:include page="include/footer.jsp"/>

    </body>
</html>
