<%-- 
    Document   : manageEventAssets
    Created on : Nov 4, 2014, 1:15:24 PM
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
        <title>Event: Manage Assets</title>

        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="row"><%--Error Message ROW--%>
            <div class="col-md-12" style="color: #ee0000">
                <p>${badEventError}</p>
                <p>${badAssetTypeError}</p>
                <p>${unavailableAssetError}</p>
                <p>${badAssetError}</p>
            </div>
        </div>


        <div class="row"><%--CHECKED OUT ASSETS ROW--%>
            <div class="col-md-12">
                <h3 class="text-center">Assets Checked Out</h3>
                <table class="table table-hover">

                    <tr>
                        <th>Asset Type</th>
                        <th>Category</th>
                            <%--<th>Availability</th>--%>
                        <th>Damage</th>
                        <th>Serial Number</th>
                        <th>Actions</th>
                    </tr>
                    <jstl:forEach var="assets" items="${event.assets}">
                        <tr>
                            <td>${assets.assetType.name}</td>
                            <td>${assets.assetType.category.categoryName}</td>
                            <%--<td>${assets.inStock}</td>--%>
                            <td>${assets.damageStatus}</td>
                            <td>${assets.serialNumber}</td>
                            <td>
                                <a href="listAssetNotes?assetId=${assets.assetId}" role="button" class="btn btn-primary glyphicon glyphicon-list-alt">View Asset Notes</a><br/><br/>
                                <a href="removeAssetFromEvent?assetId=${assets.assetId}&eventId=${event.eventId}" role="button" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a>
                            </td>
                        </tr>
                    </jstl:forEach>
                </table>
            </div>
        </div>

        <div class="row"><%--ASSET SELECTION ROW--%>
            <div class="col-md-12">

                <h3 class="text-center">Select Assets</h3>

                <div class="row">
                    <div class="col-md-3">
                        <form role="form" method="get" action="manage_assets">
                            <div class="form-group">
                                <label>Search By Category:</label>
                                <select name="selectCategory" class="form-control">
                                    <option value="all">All</option>
                                    <jstl:forEach var="category" items="${categoryList}">
                                        <option value="${category.categoryName}">${category.categoryName}</option>
                                    </jstl:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Search" class="form-control"/>
                            </div>
                        </form>
                    </div>

                    <div class="col-md-9">
                        <table class="table table-hover">
                            <tr>
                                <th></th>
                                <th>Asset Type</th>
                                <th>Category</th>
                                <th>Actions</th>
                            </tr>

                            <jstl:forEach var="types" items="${assetTypeList}">
                                <tr>
                                    <td><img class="image-responsive" src="${types.imagePath}" alt="..."></td>
                                    <td>${types.name}</td>
                                    <td>${types.category.categoryName}</td>
                                    <td>
                                        <a href="addEventAsset?typeId=${types.assetTypeId}&eventId=${event.eventId}" class="btn btn-primary">Add to Event</a>
                                    </td>

                                </tr>
                            </jstl:forEach>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
