<%-- 
    Document   : viewUserInfo
    Created on : Oct 29, 2014, 2:59:39 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="row" style="margin-bottom: 20px">
                <div class="col-md-2">
                    <a href="#userAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a><br/><br/>
                    <a href="#editUserModal" class="btn btn-primary glyphicon glyphicon-plus" data-toggle="modal">Edit User</a>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table table-hover">

                    <tr>

                        <th>Name</th>
                        <th>Username</th>
                        <th>Stading</th>
                        <th></th>
                        <th>Events</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                        <th>View Event Assets</th>
                    </tr>
                    <tr>
                        <td>User X</td>
                        <td>xxxuserxxx</td>
                        <td>good</td>
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Camping</td>
                        <td>10/22/2014</td>
                        <td>10/31/2014</td>
                        <td>Open</td>
                        <td><a href="#viewEventAssetsModal" class="btn btn-warning" role="button" data-toggle="modal">View Event's Assests</a></td>
                    </tr>


                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Camping</td>
                        <td>10/22/2014</td>
                        <td>10/31/2014</td>
                        <td>Open</td>
                        <td><a href="#viewEventAssetsModal" class="btn btn-warning" role="button" data-toggle="modal">View Event's Assests</a></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Hiking</td>
                        <td>10/22/2015</td>
                        <td>10/31/2015</td>
                        <td>Open</td>
                        <td><a href="#viewEventAssetsModal" class="btn btn-warning" role="button" data-toggle="modal">View Event's Assests</a></td>
                    </tr>


                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Camping</td>
                        <td>10/22/2014</td>
                        <td>10/31/2014</td>
                        <td>Open</td>
                        <td><a href="#viewEventAssetsModal" class="btn btn-warning" role="button" data-toggle="modal">View Event's Assests</a></td>
                    </tr>

                </table>
            </div>

            <div class="col-md-8">
                <table class="table table-hover">
                    <tr>
                        <th>User Notes</th>
                    </tr>
                    <tr>
                        <td>Consistantly returning things late, but insists on paying extra fee</td>
                    </tr>
                    <tr>
                        <td>Broke a fishing rod in half</td>
                    </tr>
                    <tr>
                        <td>Lost a sleeping bag</td>
                    </tr>
                    <tr>
                        <td>returned lost sleeping bag</td>
                    </tr>
                </table>
            </div>

            <jsp:include page="modals/viewEventAssets.jsp"/>
            <jsp:include page="modals/addUserNote.jsp"/>
            <jsp:include page="modals/editUser.jsp"/>
            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
