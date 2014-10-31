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
                    <form role="form" action="manage_assets" method="get">
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



                <jstl:forEach var="types" items="${assetTypeList}">
                    <div class="row" style="padding: 30px; margin: 30px">

                        <div class="col-md-3 col-sm-6 col-xs-12" >
                            <div class="thumbnail">
                                <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                                <!--add the generated img tag here-->
                                <div class="caption">
                                    <p><img class="image-responsive" src="${types.imagePath}" alt="..."></p>
                                    <p>${types.name}</p>
                                    <p>${types.category.categoryName}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </jstl:forEach>


<!--                <div class="row" style="padding: 30px; margin: 30px">

                    <div class="col-md-3 col-sm-6 col-xs-12" >
                        <div class="thumbnail">
                            <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                            add the generated img tag here
                            <div class="caption">
                                <h4><span>One Person Tent</span> </h4>

                                <p>                        
                                    <br><b>Category:</b> <span>Tents</span>
                                    <br><b>Brand:</b> <span>Campbell</span>
                                    <br>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="thumbnail">
                            <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                            add the generated img tag here
                            <div class="caption">
                                <h4><span>Fishing Pole</span> </h4>

                                <p>                        
                                    <br><b>Category:</b> <span>Fishing</span>
                                    <br><b>Brand:</b> <span>REI</span>
                                    <br>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="thumbnail">
                            <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                            add the generated img tag here
                            <div class="caption">
                                <h4><span>Sleeping Bag</span> </h4>

                                <p>                        
                                    <br><b>Category:</b> <span>Sleeping Bags</span>
                                    <br><b>Brand:</b> <span>Marmot</span>
                                    <br>
                                </p>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="thumbnail">
                            <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                            add the generated img tag here
                            <div class="caption">
                                <h4><span>Sleeping Bag Liner</span> </h4>

                                <p>                        
                                    <br><b>Category:</b> <span>Sleeping Bags</span>
                                    <br><b>Brand:</b> <span>REI</span>
                                    <br>
                                </p>

                            </div>
                        </div>
                    </div>

                </div>-->

                <a href="index.jsp" class="btn btn-primary glyphicon glyphicon-chevron-home">Home</a><br/><br/>



                <jsp:include page="include/footer.jsp"/>
            </div>
        </div>
    </body>
</html>
