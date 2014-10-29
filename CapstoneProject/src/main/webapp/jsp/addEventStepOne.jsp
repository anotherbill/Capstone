<%-- 
    Document   : addEventStepOne
    Created on : Oct 29, 2014, 11:04:57 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Event Step One</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <form class="addEditEvent form-horizontal" role="form" name="editAddEvent" id="editEventModal">
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Event Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="Name" name="nameUser"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inout" class="col-sm-2 control-label">UserName</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="user" placeholder="UserName" name="userName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Location</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="location" placeholder="Location" name="location"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inout" class="col-sm-2 control-label">Size</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="size" placeholder="How many are in your party" name="size"/>
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">StartDate</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="startDate" placeholder="Enter Date (datepicker)" name="startDate"/>
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">End Date</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="endDate" placeholder="Enter Date (datepicker)" name="endDate"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Image</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" name="image"/>
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Note</label>
                <div class="col-sm-10">
                    <textArea type="text" class="form-control" id="note" name="note">Enter Note Here</textArea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary glyphicon glyphicon-chevron-right" href="add_event_step_2.html" value="Next"/>
                </div>
            </div>
        </form>
        
        
        
        <a class="btn btn-primary glyphicon glyphicon-chevron-right" href="add_event_step_2.html" >Next</a>
        
        
        
        

        
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
