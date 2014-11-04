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
        <title>JSP Page</title>

        <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
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
                                <td><a href="addEditEventAssets?typeId=${types.assetTypeId}" class="btn btn-primary">List All Assets of This Type</a></td>

                            </tr>
                        </jstl:forEach>
                    </table>
            </div>
        </div>
    </body>
</html>
