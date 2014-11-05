<%-- 
    Document   : viewEventInfo
    Created on : Nov 5, 2014, 2:47:04 PM
    Author     : apprentice
--%>

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
                    <a href="eventAddNote?eventId=${event.eventId}" class="btn btn-success glyphicon glyphicon-plus">Add Note</a><br/><br/>
                    <a href="editevent?eventId=${event.eventId}" class="btn btn-primary glyphicon glyphicon-plus">Edit Event</a>
                </div>
            </div>
            <div class="col-md-12">
                <table class="table table-hover">

                    <tr>
                        <th>Name</th>
                        <th>Username</th>
                        <th>Stading</th>
                        <th>Events</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                    </tr>
                    <tr>
                        <td>User X</td>
                        <td>xxxuserxxx</td>
                        <td>good</td>
                        <td>Camping</td>
                        <td>10/22/2014</td>
                        <td>10/31/2014</td>
                        <td>Open</td>
                    </tr>
                </table>
                <hr/>
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
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>
