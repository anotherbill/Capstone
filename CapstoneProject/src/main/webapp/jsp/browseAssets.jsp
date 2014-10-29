<%-- 
    Document   : browseAssets
    Created on : Oct 29, 2014, 10:36:52 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Assets</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>


        <div class="row" style="padding: 0px; margin: 0px">
            <div class="col-md-3">
                <form role="form">
                    <div class="form-group">
                        <select name="selectCategory" class="form-control">
                            <option value="option1">Search By Category</option>
                            <option value="option2">Option 2</option>
                            <option value="option3">Option 3</option>
                            <option value="option4">Option 4</option>
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
                        <select name="selectAssetType" class="form-control">
                            <option value="option1">Search By Asset Type</option>
                            <option value="option2">Option 2</option>
                            <option value="option3">Option 3</option>
                            <option value="option4">Option 4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Search" class="form-control"/>
                    </div>
                </form>
            </div>
        </div>





        <div class="row" style="padding: 30px; margin: 30px">

            <div class="col-md-3 col-sm-6 col-xs-12" >
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
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
                    <!--add the generated img tag here-->
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
                    <!--add the generated img tag here-->
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
                    <!--add the generated img tag here-->
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

        </div>

        <a href="index.jsp" class="btn btn-primary glyphicon glyphicon-chevron-home">Home</a><br/><br/>



        <jsp:include page="footer.jsp"/>
    </body>
</html>
