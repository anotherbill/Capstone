<%-- 
    Document   : browseAssets
    Created on : Oct 29, 2014, 10:36:52 AM
    Author     : apprentice
--%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Assets</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>


            <div class="row" style="padding: 0px; margin: 0px">
                <div class="col-md-3">
                    <form role="form" action="assets" method="get">
                        <div class="form-group">
                            <select name="selectCategory" class="form-control">
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
            </div>


            <div class="row" style="padding: 30px; margin: 30px">
                <jstl:forEach var="types" items="${assetTypeList}">


                    <div class="col-md-3 col-sm-6 col-xs-12" >
                        <div class="thumbnail">
                            <img class="img-responsive" src="${types.imagePath}" alt="...">
                            <!--add the generated img tag here-->
                            <div class="caption">
                                <p>${types.name}</p>
                                <p>${types.category.categoryName}</p>
                            </div>
                        </div>
                    </div>

                </jstl:forEach>
            </div>

            <a href="index.jsp" class="btn btn-primary glyphicon glyphicon-chevron-home">Home</a><br/><br/>



            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
