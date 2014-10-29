<%-- 
    Document   : addAsset
    Created on : Oct 29, 2014, 10:39:11 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Asset</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <form class="addEditAsset form-horizontal" role="form" id="addEditAsset">
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="Name" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Category</label>
                <div class="col-sm-10">
                    <select class="form-control" name="category">
                        <option>Tents</option>
                        <option>Sleeping Bag</option>
                        <option>Fishing Pole</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Asset Type</label>
                <div class="col-sm-10">
                    <select class="form-control" name="assetType">
                        <option>1-Person Tent</option>
                        <option>2-Person Tent</option>
                        <option>3-Person Tent</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Status</label>
                <div class="col-sm-10">
                    <select class="form-control" name="status">
                        <option>Available</option>
                        <option>Checked-Out</option>
                        <option>Lost</option>
                        <option>Stolen</option>
                        <option>Late</option>
                        <option>Retired</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Serial #</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="serialNum" placeholder="Scan Serial Number" name="serialNum">
                </div>
            </div>
            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Image</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" id="image" name="image"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">Damage</label>
                <div class="col-sm-10">
                    <select class="form-control" name="damage">
                        <option>none</option>
                        <option>small</option>
                        <option>medium</option>
                        <option>large</option>
                        <option>obliterated</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="input" class="col-sm-2 control-label">Note</label>
                <div class="col-sm-10">
                    <textArea class="form-control" id="note" name="assetNote">Enter Note Here</textArea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="Add Asset" class="btn btn-primary"/>
                </div>
            </div>
        </form>
         <a class="btn btn-primary" href="index.jsp">Add Asset</a>

        
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
