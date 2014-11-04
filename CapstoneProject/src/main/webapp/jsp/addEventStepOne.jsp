<%-- 
    Document   : addEventStepOne
    Created on : Oct 29, 2014, 11:04:57 AM
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
        <title>Add Event Step One</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <form class="form-horizontal" action="submitAddEventStepOne" role="form" name="editAddEvent">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Event Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" placeholder="Name" name="eventName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">UserName</label>
                    <div class="col-sm-10">
                        <select class="col-sm-2 control-label" name="userName">
                            <jstl:forEach var="user" items="${userList}">
                                <option value="${user.userId}">${user.userName}</option>
                            </jstl:forEach>
                        </select>
                    </div>
                </div>
<!--                <div class="form-group">
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
                </div>-->
                <div class="form-group">
                    <label class="col-sm-2 control-label">StartDate</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="startDate" name="checkOutDate"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input" class="col-sm-2 control-label">End Date</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="endDate" name="dueDate"/>
                    </div>
                </div>
<!--                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Image</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" name="image"/>
                    </div>
                </div>-->
<!--                <div class="form-group">
                    <label for="input" class="col-sm-2 control-label">Note</label>
                    <div class="col-sm-10">
                        <textArea class="form-control" id="note" name="note">Enter Note Here</textArea>
                </div>
            </div>-->

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary glyphicon glyphicon-chevron-right" value="Next"/>
                </div>
            </div>
        </form>
        
        
        
<!--        <a class="btn btn-primary glyphicon glyphicon-chevron-right" href="addEventStepTwo.jsp" >Next</a>-->
        
        
        
        

        
        
            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
