<%-- 
    Document   : manageAssets
    Created on : Oct 29, 2014, 10:38:02 AM
    Author     : apprentice
--%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Assets</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>


            <div class="row" style="padding: 0px; margin: 0px">
                <div class="col-md-3">
                    <form role="form" action="manage_assets" method="get">
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

                    <form role="form">
                        <div class="form-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-plus">
                                    <label>Add New Asset Type:</label></span></span><input type="text" class="form-control" style="float: right"/><br/><br/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="form-control" value="Add Asset Type"/>
                        </div>
                    </form>
                </div> 
                
                <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                <div class="col-md-2">
                    <a class="btn btn-primary glyphicon glyphicon-plus" href="addAsset">Add Asset</a>
                </div>
            </div>

            <div class="col-md-12"> 

                <table class="table table-hover">

                    <tr>
                        <th></th>
                        <th>Asset Type</th>
                        <th>Category</th>
                        <th>Actions</th>
                    </tr>
                    <br/><br/>
                    <jstl:forEach var="types" items="${assetTypeList}">
                        <tr>
                            <td><img class="image-responsive" src="${types.imagePath}" alt="..."></td>
                            <td>${types.name}</td>
                            <td>${types.category.categoryName}</td>
                            <td><a href="editAsset?" class="btn btn-warning">Edit</a><br/><br/><a href="deleteAsset" class="btn btn-danger">Delete</a><br/><br/>
                                <a href="#assetAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a><br/><br/>
                                <a href="listAssets?typeId=${types.assetTypeId}" class="btn btn-primary">List All Assets of This Type</a></td>

                        </tr>
                    </jstl:forEach>
                </table>
        </div>

            </div>


            <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                <div class="col-md-2">
                    <a class="btn btn-primary glyphicon glyphicon-plus" href="addAsset">Add Asset</a>
                </div>
            </div>

            <jsp:include page="modals/assetAddNote.jsp"/>
            <jsp:include page="include/footer.jsp"/>

        </div>
    </body>
</html>
