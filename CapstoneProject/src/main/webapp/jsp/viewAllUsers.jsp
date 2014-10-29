<%-- 
    Document   : viewAllUsers
    Created on : Oct 29, 2014, 11:21:26 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="row" style="padding: 0px; margin: 0px; margin-bottom: 30px">
            <a class="btn btn-primary glyphicon glyphicon-plus" href="#addUserModal" data-toggle="modal">Add User</a>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span id="title-${movie.movieID}">User 1</span> </h4>

                        <p>                        
                            <br><b>Name:</b> <span id="director-${movie.movieID}">first name, last name</span>
                            <br><b>Standing:</b> <span id="studio-${movie.movieID}">good</span>
                            <br>
                        </p>
                        <a  onclick="window.location.href = 'view_user_info.html'" class="btn btn-warning">Additional Info</a><br/>
                        <a href="#editUserModal" class="btn btn-primary" role="button" data-toggle="modal">Edit</a>  <a href="deleteAsset" class="btn btn-danger" role="button" data-toggle="modal">Delete</a><br/><br/>
                        <a href="#userAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span id="title-${movie.movieID}">User 2</span> </h4>

                        <p>                        
                            <br><b>Name:</b> <span id="director-${movie.movieID}">first name, last name</span>
                            <br><b>Standing:</b> <span id="studio-${movie.movieID}">bad</span>
                            <br>
                        </p>
                        <a  onclick="window.location.href = 'view_user_info.html'" class="btn btn-warning">Additional Info</a><br/>
                        <a href="#editUserModal" class="btn btn-primary" role="button" data-toggle="modal">Edit</a>  <a href="deleteUser" class="btn btn-danger" role="button" data-toggle="modal">Delete</a><br/><br/>
                        <a href="#userAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span id="title-${movie.movieID}">User 3</span> </h4>

                        <p>                        
                            <br><b>Name:</b> <span id="director-${movie.movieID}">first name, last name</span>
                            <br><b>Standing:</b> <span id="studio-${movie.movieID}">good</span>
                            <br>
                        </p>
                        <a  onclick="window.location.href = 'view_user_info.html'" class="btn btn-warning">Additional Info</a><br/>
                        <a href="#editUserModal" class="btn btn-primary" role="button" data-toggle="modal">Edit</a>  <a href="deleteUser" class="btn btn-danger" role="button" data-toggle="modal">Delete</a><br/><br/>
                        <a href="#userAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span id="title-${movie.movieID}">User 4</span> </h4>

                        <p>                        
                            <br><b>Name:</b> <span id="director-${movie.movieID}">first name, last name</span>
                            <br><b>Standing:</b> <span id="studio-${movie.movieID}">good</span>
                            <br>
                        </p>
                        <a  onclick="window.location.href = 'view_user_info.html'" class="btn btn-warning">Additional Info</a><br/>
                        <a href="#editUserModal" class="btn btn-primary" role="button" data-toggle="modal">Edit</a>  <a href="deleteUser" class="btn btn-danger" role="button" data-toggle="modal">Delete</a><br/><br/>
                        <a href="#userAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>

        </div><!--row-->

        <br>
        <div class="panel panel-info">
            <div class="text-center">
                <h6>Created By: Grey Team 2014<br>
                    Powered By Java and Bootstrap</h6> 
            </div>

        </div>



    <jsp:include page="footer.jsp"/>
</body>
</html>
