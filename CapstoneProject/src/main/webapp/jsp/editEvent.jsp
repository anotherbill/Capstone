<%-- 
    Document   : editEvent
    Created on : Oct 29, 2014, 11:10:49 AM
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
        <title>Edit Event</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>


            <div class="row" style="margin-left: 25px">
                <div class="col-md-12 col-sm-12 col-xs-12" style="border-bottom: 3px solid black; border-radius: 4px; padding-top: 15px; margin-bottom: 30px">
                    <sf:form action="submitEditEvent" id="addEditEvent" role="form" modelAttribute="event">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h2 class="text-center">Edit Event</h2>

                            <img class="img-responsive" data-src="holder.js/242x200" alt="..." style="float: left; padding-bottom: 25px">
                            <!--add the generated img tag here-->

                            <p>                        
                                <br><b style="margin-left: 20px">Event:</b> <span>Event Name</span>
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
                                        <th>Due Date</th>
                                        <th>Status</th>
                                    </tr>
                                    <tr>
                                        <td>${event.eventName}<br/><br/>
                                            <div class="form-group">
                                                <sf:input path="eventName" type="text" cssClass="form-control" id="name" name="eventName"/>
                                            </div>
                                        </td>
                                        <td>${event.user.userName}<br/><br/>
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="user" name="userName"/>
                                            </div>
                                        </td>
                                        <%--<td>${event.location}<br/><br/>
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="location" name="location"/>
                                            </div>
                                        </td>
                                        <td>${event.size}<br/><br/>
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="size" name="size"/>
                                            </div>
                                        </td> --%>
                                        <td>${event.checkOutDate}<br/><br/>
                                            <div class="form-group">
                                                <sf:input path="checkOutDate"  type="date" cssClass="form-control" id="startDate" name="checkOutDate"/>
                                            </div>
                                        </td>
                                        <td>${event.dueDate}<br/><br/>
                                            <div class="form-group">
                                                <sf:input path="dueDate" type="date" cssClass="form-control" id="endDate" name="dueDate"/>
                                            </div>
                                        </td>
                                        <td>${event.open}<br/><br/>
                                            <div class="form-group">
                                                <sf:select path="open" cssClass="form-control" name="open">
                                                    <sf:option value="true">True</sf:option>
                                                    <sf:option value="false">False</sf:option>
                                                </sf:select>
                                            </div>
                                        </td>

                                    </tr>

                                </table>
                            </div>

                        </div>
                        <sf:form>

                            <div class="col-md-12">
                                <table class="table table-hover">

                                    <tr>
                                        <th>Asset Type</th>
                                        <th>Category</th>
                                        <th>Availability</th>
                                        <th>Damage</th>
                                        <th>Serial Number</th>
                                        <th>Actions</th>
                                    </tr>
                                    <tr>
                                        <jstl:forEach var="assets" items="${assetCheckedOutList}">
                                            <td>${asset.assetType.name}</td>
                                            <td>${asset.assetType.category.categoryName}</td>
                                            <td>${asset.inStock}</td>
                                            <td>${asset.damageStatus}</td>
                                            <td>${asset.serialNumber}</td>
                                            <td>
                                                <a href="viewAssetNotes?assetId=${asset.assetId}" role="button" class="btn btn-primary glyphicon glyphicon-list-alt">View Asset Notes</a><br/><br/>
                                                <a href="checkInAsset?assetId=${asset.assetId}" role="button" class="btn btn-success glyphicon glyphicon-plus">Remove From Event</a>
                                            </td>
                                        </jstl:forEach>
                                    </tr>
                                </table>
                            </div>




                            <jsp:include page="include/manageEventAssets.jsp"/>



                            <%-- PLACEHOLDER BEGIN --%>
                            <div class="row" style="padding-top: 30px">
                                <form role="form">

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
                                                <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
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
                                                <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
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
                                                <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
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
                                                <a href="removeFromEvent" class="btn btn-danger glyphicon glyphicon-minus">Remove From Event</a><br/><br/>
                                            </div>
                                        </div>
                                    </div>
                                    <%-- PLACEHOLDER END --%>

                                    <jsp:include page="include/addEditEventAssets"/>



                                    <input type="submit" value="Update Event" class="btn btn-primary" style="float: right; font-size: 24px; margin: 10px 0px 30px 0px"/>

                                </form>
                            </div>


                        </div>
                    </div>





                    <jsp:include page="include/footer.jsp"/>
                </div>
            </body>
        </html>
