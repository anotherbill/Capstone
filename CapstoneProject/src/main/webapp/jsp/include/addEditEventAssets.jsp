<%-- 
    Document   : addEditEventAssets
    Created on : Oct 29, 2014, 11:15:01 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row" style="padding: 0px; margin: 0px">
            <h2 class="text-center" style="padding-bottom: 25px">Available Assets</h2>
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


        <div class="col-md-12">
            <table class="table table-hover">

                <tr>
                    <th></th>
                    <th>Asset</th>
                    <th>Asset Type</th>
                    <th>Availability</th>
                    <th>Damage</th>
                    <th>Serial Number</th>
                    <th>Category</th>
                    <th>Notes</th>
                    <th>Actions</th>
                </tr>

                <tr>
                    <td><img class="image-responsive" src="img/asset/placeholder.jpg" alt="..."></td>
                    <td>Tent</td>
                    <td>2-Person</td>
                    <td>In Store</td>
                    <td>Slight</td>
                    <td>xyz-123</td>
                    <td>Shelter</td>
                    <td>Small rip in door- damage from use- non intentional</td>
                    <td><a href="assignToEvent" class="btn btn-primary glyphicon glyphicon-plus">Assign To Event</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Mud tracked all inside. Now infested with BEES?!</td>
                </tr>


                <tr>
                    <td><img class="image-responsive" src="img/asset/placeholder.jpg" alt="..."></td>
                    <td>Tent</td>
                    <td>2-Person</td>
                    <td>In Store</td>
                    <td>Slight</td>
                    <td>xyz-123</td>
                    <td>Shelter</td>
                    <td>Small rip in door- damage from use- non intentional</td>
                    <td><a href="assignToEvent" class="btn btn-primary glyphicon glyphicon-plus">Assign To Event</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Mud tracked all inside. Now infested with BEES?!</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>This is a 3<sup>rd</sup> note</td>
                </tr>



                <tr>
                    <td><img class="image-responsive" src="img/asset/placeholder.jpg" alt="..."></td>
                    <td>Tent</td>
                    <td>2-Person</td>
                    <td>In Store</td>
                    <td>Slight</td>
                    <td>xyz-123</td>
                    <td>Shelter</td>
                    <td>Small rip in door- damage from use- non intentional</td>
                    <td><a href="assignToEvent" class="btn btn-primary glyphicon glyphicon-plus">Assign To Event</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Mud tracked all inside. Now infested with BEES?!</td>
                </tr>

            </table>
        </div>

    </body>
</html>
