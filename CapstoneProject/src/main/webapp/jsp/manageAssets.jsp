<%-- 
    Document   : manageAssets
    Created on : Oct 29, 2014, 10:38:02 AM
    Author     : apprentice
--%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Assets</title>

<!--        <link rel="stylesheet" href="bootstrapvalidator-0.5.2/dist/css/bootstrapValidator.min.css"/>-->


        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>
            <div class="container">


            ${assetTypeDeletionError}
            ${assetTypeUpdateError}
            ${assetTypeError}
            ${assetTypeDeletionError}
            ${categoryUpdateError}
            ${categoryDeletionError}
            ${displayUpdateAssetFormError}


            <div class="row">

                <div class="col-md-9">

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
                    <div class="col-md-6">

                        <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                            <div class="col-md-12">
                                <a class="btn btn-primary glyphicon glyphicon-plus" href="addAssetType">  Add Asset Type</a>
                                <%--<a class="btn btn-danger" role="button" href="viewRetiredAssets" style="margin-left: 20px">View Retired Assets</a>--%>
                            </div>
                            
                        </div>

                        <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                            <div class="col-md-2">
                                <a class="btn btn-primary glyphicon glyphicon-plus" href="addAsset">  Add Asset</a>
                            </div>
                        </div>
                        
                    </div>


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
                                <td><img class="image-responsive" src="${types.imagePath}" alt="..." style="height: 200px; width: 200px"></td>
                                <td>${types.name}</td>
                                <td>${types.category.categoryName}</td>
                                <td><a href="updateAssetType?typeId=${types.assetTypeId}" class="btn btn-warning">Edit Asset Type</a><br/><br/>
                                    <a href="removeAssetType?typeId=${types.assetTypeId}" class="btn btn-danger">Delete</a><br/><br/>
                                    <a href="listAssets?typeId=${types.assetTypeId}" class="btn btn-primary">List All Assets of This Type</a></td>

                            </tr>
                        </jstl:forEach>
                    </table>

                </div>


                <div class="col-md-3" style="padding-bottom: 20px; float: left">
                    <h2 class="text-center">Manage Categories</h2>
                    <sf:form role="form" action="submitNewCategory" id="manageCategories" method="post" modelAttribute="category">
                        <div class="form-group"> 
                            <span class="input-group-addon"><span class="glyphicon glyphicon-plus">
                                    <sf:label path="categoryName">Add New Category:</sf:label></span></span><sf:input path="categoryName" type="text" class="form-control" style="float: right" name="categoryName"/><br/><br/>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="form-control" value="Add Category"/>
                            </div> 
                    </sf:form>


                    <jstl:forEach var="category" items="${categoryList}">
                        <p style="padding-bottom: 15px">${category.categoryName}
                            <a href="updateCategory?categoryId=${category.categoryId}" class="btn btn-warning btn-sm" style="float:right; margin-left: 10px">Edit</a>
                            <a href="removeCategory?categoryId=${category.categoryId}" class="btn btn-danger btn-sm" style="float:right">Delete</a></p>
                        </jstl:forEach>
                </div>



                <jsp:include page="include/footer.jsp"/>

            </div>
        </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#manageCategories').bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        categoryName: {
                            message: 'The category name is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'The category is required and cannot be empty'
                                },
                                stringLength: {
                                    min: 2,
                                    max: 30,
                                    message: 'The category must be more than 2 and less than 30 characters long'
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z ]+$/,
                                    message: 'The serial number can only consist of letters and spaces'
                                }
                            }
                        }


                    }
                });
            });
        </script>

    </body>
</html>
