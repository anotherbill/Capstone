<%-- 
    Document   : assetsByType
    Created on : Oct 31, 2014, 2:07:25 PM
    Author     : apprentice
--%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assets By Types</title>
    </head>
    <body>
        <div class="container">

            <jsp:include page="include/header.jsp"/>

            <div class="row" style="padding: 0px; margin: 0px">

                <div class="col-md-3">
                    <form role="form">
                        <div class="form-group"> 
                            <span class="input-group-addon"><span class="glyphicon glyphicon-plus">
                                    <label>Add New Category:</label></span></span><input type="text" class="form-control" style="float: right"/><br/><br/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="form-control" value="Add Category"/>
                        </div> 
                    </form>
                </div>           
                <div class="col-md-3">

                    <div class="col-md-3">

                    <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                        <div class="col-md-2">
                            <a class="btn btn-primary glyphicon glyphicon-plus" href="addAssetType">Add Asset Type</a>
                        </div>
                    </div>
                
                    <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                        <div class="col-md-2">
                            <a class="btn btn-primary glyphicon glyphicon-plus" href="addAsset">Add Asset</a>
                        </div>
                    </div>
                </div>
            </div>
            </div>

            <div class="col-md-12"> 

                <table class="table table-hover">

                    <tr>
                        <th></th>
                        <th>Category</th>
                        <th>Asset Type</th>
                        <th>In Stock</th>
                        <th>Serial Number</th>
                        <th>Damage Status</th>
                        <th>Actions</th>
                    </tr>
                    <jstl:forEach var="asset" items="${assetList}">
                        <tr>
                            <td><img class="image-responsive" src="${types.imagePath}" alt="..."></td>
                            <td>${asset.assetType.category.categoryName}</td>
                            <td>${asset.assetType.name}</td>
                            <td>${asset.inStock}</td>
                            <td>${asset.serialNumber}</td>
                            <td>${asset.damageStatus}</td>
                            <td><a href="updateAsset?assetId=${asset.assetId}" class="btn btn-warning">Edit</a><br/><br/><a href="removeAsset?assetId=${asset.assetId}" class="btn btn-danger">Delete</a><br/><br/>
                                <a href="#assetAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a></td>
                        </tr>
                    </jstl:forEach>
                </table>
            </div>
            <jsp:include page="modals/assetAddNote.jsp"/>
            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
