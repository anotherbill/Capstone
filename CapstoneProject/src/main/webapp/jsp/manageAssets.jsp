<%-- 
    Document   : manageAssets
    Created on : Oct 29, 2014, 10:38:02 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Assets</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>


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
                <div class="col-md-3">
                    <form role="form">
                        <div class="form-group"> 
                            <span class="input-group-addon"><span class="glyphicon glyphicon-plus">
                                    <label>Add New Category:</label></span></span><input type="text" class="form-control" style="float: right"/><br/><br/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="form-control" value="Add Category"/>
                        </div> 
                    </form>
                </div>           
                <div class="col-md-3">

                    <form role="form">
                        <div class="form-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-plus">
                                    <label>Add New Asset Type:</label></span></span><input type="text" class="form-control" style="float: right"/><br/><br/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="form-control" value="Add Asset Type"/>
                        </div>
                    </form>
                </div> 



            </div>


            <div class="row" style="padding: 0px; margin: 0px; padding-bottom: 20px">
                <div class="col-md-2">
                    <a class="btn btn-primary glyphicon glyphicon-plus" href="addAsset">Add Asset</a>
                </div>
            </div>




            <div class="col-md-12">
                <table class="table table-hover">

                    <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Asset Type</th>
                        <th>Satus</th>
                        <th>Serial Number</th>
                        <th>Damage</th>
                        <th>Notes</th>
                        <th>Actions</th>
                    </tr>

                    <tr>
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Super-Duper Tent</td>
                        <td>Tent</td>
                        <td>2-Person</td>
                        <td>In Store</td>
                        <td>xyz-123</td>
                        <td>Slight</td>
                        <td>Small rip in door- damage from use- non intentional</td>
                        <td><a href="editAsset.jsp" class="btn btn-warning">Edit</a><br/><br/><a href="deleteAsset" class="btn btn-danger">Delete</a><br/><br/>
                            <a href="#assetAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a></td>
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
                        <td><img class="image-responsive" src="../img/asset/placeholder.jpg" alt="..."></td>
                        <td>Super-Duper Tent</td>
                        <td>Tent</td>
                        <td>2-Person</td>
                        <td>In Store</td>
                        <td>xyz-123</td>
                        <td>Slight</td>
                        <td>Small rip in door- damage from use- non intentional</td>
                        <td><a href="editAsset.jsp" class="btn btn-warning">Edit</a><br/><br/><a href="deleteAsset" class="btn btn-danger">Delete</a><br/><br/>
                            <a href="#assetAddNote" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal">Add Note</a></td>

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
                </table>



                <jsp:include page="modals/assetAddNote.jsp"/>
                <jsp:include page="include/footer.jsp"/>
            </div>
        </div>
    </body>
</html>
