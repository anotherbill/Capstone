
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <div class="container">
        
        <jsp:include page="include/header.jsp"/>
        
        <div class="row" style="padding: 0px; margin: 0px; margin-bottom: 30px">
            <a class="btn btn-primary glyphicon glyphicon-plus" href="addEventStepOne.jsp">Add Event</a>
        </div>

        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span>Event 1</span> </h4>

                        <p>                        
                            <br><b>Event:</b> <span>Event Name</span>
                            <br>
                        </p>
                        <a href="#viewEventInfoModal" class="btn btn-warning" role="button" data-toggle="modal">Additional Info</a>
                        <a href="editEvent.jsp" class="btn btn-primary" role="button">Edit</a><br/><br/>  <a href="deleteEvent" class="btn btn-danger" role="button" data-toggle="modal">Delete</a>
                        <a href="closeEvent" class="btn btn-info" role="button" data-toggle="modal">Close Event</a><br/><br/>
                        <a href="modals/eventAddNote.jsp" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span>Event 1</span> </h4>

                        <p>                        
                            <br><b>Event:</b> <span>Event Name</span>
                            <br>
                        </p>
                        <a href="#viewEventInfoModal" class="btn btn-warning" role="button" data-toggle="modal">Additional Info</a>
                        <a href="editEvent.jsp" class="btn btn-primary" role="button">Edit</a><br/><br/>  <a href="deleteEvent" class="btn btn-danger" role="button" data-toggle="modal">Delete</a>
                        <a href="closeEvent" class="btn btn-info" role="button" data-toggle="modal">Close Event</a><br/><br/>
                        <a href="modals/eventAddNote.jsp" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span>Event 1</span> </h4>

                        <p>                        
                            <br><b>Event:</b> <span>Event Name</span>
                            <br>
                        </p>
                        <a href="#viewEventInfoModal" class="btn btn-warning" role="button" data-toggle="modal">Additional Info</a>
                        <a href="editEvent.jsp" class="btn btn-primary" role="button">Edit</a><br/><br/>  <a href="deleteEvent" class="btn btn-danger" role="button" data-toggle="modal">Delete</a>
                        <a href="closeEvent" class="btn btn-info" role="button" data-toggle="modal">Close Event</a><br/><br/>
                        <a href="modals/eventAddNote.jsp" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="thumbnail">
                    <img class="img-responsive" data-src="holder.js/242x200" alt="...">
                    <!--add the generated img tag here-->
                    <div class="caption">
                        <h4><span>Event 1</span> </h4>

                        <p>                        
                            <br><b>Event:</b> <span>Event Name</span>
                            <br>
                        </p>
                        <a href="#viewEventInfoModal" class="btn btn-warning" role="button" data-toggle="modal">Additional Info</a>
                        <a href="editEvent.jsp" class="btn btn-primary" role="button">Edit</a><br/><br/>  <a href="deleteEvent" class="btn btn-danger" role="button" data-toggle="modal">Delete</a>
                        <a href="closeEvent" class="btn btn-info" role="button" data-toggle="modal">Close Event</a><br/><br/>
                        <a href="modals/eventAddNote.jsp" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a>
                    </div>
                </div>
            </div>

        </div>
        
        <jsp:include page="modals/eventAddNote.jsp"/>
        <jsp:include page="modals/manageMyEvents.jsp"/>
        <jsp:include page="modals/viewEventInfo.jsp"/>
        <jsp:include page="include/footer.jsp"/>
        </div>

    </body>
</html>
