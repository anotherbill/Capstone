<%-- 
    Document   : viewEventInfo
    Created on : Nov 5, 2014, 2:47:04 PM
    Author     : apprentice
--%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Info</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="bootstrapvalidator-0.5.2/dist/css/bootstrapValidator.min.css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>

        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="container">

            <div class="row" style="margin-bottom: 20px">
                <div class="col-md-2">
                    <a href="index" class="btn btn-default"><span class="glyphicon glyphicon-chevron-left"></span> Back</a><br><br>
                    <a href="eventAddNote?eventId=${event.eventId}" class="btn btn-success glyphicon glyphicon-plus"> Add Note</a><br/><br/>
                    <a href="editEvent?eventId=${event.eventId}" class="btn btn-primary glyphicon glyphicon-plus"> Edit Event</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">

                        <tr>
                            <th>Event Name</th>
                            <th>Username</th>
                            <th>Standing</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Status</th>
                        </tr>
                        <tr>
                            <td>${event.eventName}</td>
                            <td>${event.user.userName}</td>
                            <td>${event.user.goodStanding}</td>
                            <td>${event.checkOutDate}</td>
                            <td>${event.dueDate}</td>
                            <td>${event.open}</td>
                        </tr>
                    </table>
                    <hr/>
                </div>
            </div>
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
                        <jstl:forEach var="assets" items="${event.assets}">
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
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>
