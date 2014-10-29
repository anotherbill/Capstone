<%-- 
    Document   : editEvent
    Created on : Oct 29, 2014, 11:10:49 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Event</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>


        <div class="row" style="margin-left: 25px">
            <div class="col-md-12 col-sm-12 col-xs-12" style="border-bottom: 3px solid black; border-radius: 4px; padding-top: 15px; margin-bottom: 30px">
                <form role="form">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h2 class="text-center">Edit Event</h2>

                        <img class="img-responsive" data-src="holder.js/242x200" alt="..." style="float: left; padding-bottom: 25px">
                        <!--add the generated img tag here-->

                        <p>                        
                            <br><b style="margin-left: 20px">Event:</b> <span id="director-${movie.movieID}">Event Name</span>
                            <br>
                        </p>

                        <div class="col-md-12">
                            <table class="table table-hover">

                                <tr>
                                    <th>Event</th>
                                    <th>UserName</th>
                                    <th>Location</th>
                                    <th>Size</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Image</th>
                                </tr>
                                <tr>
                                    <td>Super Hike<br/><br/>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="name" name="nameUser"/>
                                        </div>
                                    </td>
                                    <td>xxxUserxxx<br/><br/>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="user" name="userName"/>
                                        </div>
                                    </td>
                                    <td>Somewhere, OH<br/><br/>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="location" name="location"/>
                                        </div>
                                    </td>
                                    <td>20<br/><br/>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="size" name="size"/>
                                        </div>
                                    </td>
                                    <td>11/15/2014<br/><br/>
                                        <div class="form-group">
                                            <input type="date" class="form-control" id="startDate" name="startDate"/>
                                        </div>
                                    </td>
                                    <td>11/20/2014<br/><br/>
                                        <div class="form-group">
                                            <input type="date" class="form-control" id="endDate" name="endDate"/>
                                        </div>
                                    </td>
                                    <td> 
                                        <br/><br/>
                                        <div class="form-group">
                                            <input type="file" class="form-control" name="image"/>
                                        </div></td>
                                </tr>

                            </table>
                        </div>

                    </div>





                    <div class="row" style="padding-top: 30px">
                        <form role="form">

                            <div class="col-md-3 col-sm-6 col-xs-12" >
                                <div class="thumbnail">
                                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                                    <!--add the generated img tag here-->
                                    <div class="caption">
                                        <h4><span id="title-${movie.movieID}">One Person Tent</span> </h4>

                                        <p>                        
                                            <br><b>Category:</b> <span id="director-${movie.movieID}">Tents</span>
                                            <br><b>Brand:</b> <span id="studio-${movie.movieID}">Campbell</span>
                                            <br>
                                        </p>
                                        <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="thumbnail">
                                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                                    <!--add the generated img tag here-->
                                    <div class="caption">
                                        <h4><span id="title-${movie.movieID}">Fishing Pole</span> </h4>

                                        <p>                        
                                            <br><b>Category:</b> <span id="director-${movie.movieID}">Fishing</span>
                                            <br><b>Brand:</b> <span id="studio-${movie.movieID}">REI</span>
                                            <br>
                                        </p>
                                        <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="thumbnail">
                                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                                    <!--add the generated img tag here-->
                                    <div class="caption">
                                        <h4><span id="title-${movie.movieID}">Sleeping Bag</span> </h4>

                                        <p>                        
                                            <br><b>Category:</b> <span id="director-${movie.movieID}">Sleeping Bags</span>
                                            <br><b>Brand:</b> <span id="studio-${movie.movieID}">Marmot</span>
                                            <br>
                                        </p>
                                        <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="thumbnail">
                                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                                    <!--add the generated img tag here-->
                                    <div class="caption">
                                        <h4><span id="title-${movie.movieID}">Sleeping Bag Liner</span> </h4>

                                        <p>                        
                                            <br><b>Category:</b> <span id="director-${movie.movieID}">Sleeping Bags</span>
                                            <br><b>Brand:</b> <span id="studio-${movie.movieID}">REI</span>
                                            <br>
                                        </p>
                                        <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
                                    </div>
                                </div>
                            </div>



                            <input type="submit" value="Update Event" class="btn btn-primary" style="float: right; font-size: 24px; margin: 10px 0px 30px 0px"/>

                        </form>
                    </div>


            </div>
        </div>



        <jsp:include page="include/addEditEventAssets.jsp"/>

        <jsp:include page="footer.jsp"/>
    </body>
</html>