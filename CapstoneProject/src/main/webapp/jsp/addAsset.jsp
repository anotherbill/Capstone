<%-- 
    Document   : addAsset
    Created on : Oct 29, 2014, 10:39:11 AM
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
        <title>Add Asset</title>
        <script src="../js/validateAddEditAsset.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="row">
                <div class="col-md-6">
                    <sf:form cssClass="form-horizontal" role="form" action="submitNewAsset" method="post" id="addEditAsset" modelAttribute="newAsset">
                
                        <%--   
                        <sf:select path="categoryName" cssClass="form-control" name="category">
                            <sf:option value="tent">Tents</sf:option>
                            <sf:option value="sleepingBag">Sleeping Bag</sf:option>
                            <sf:option value="fishingPole">Fishing Pole</sf:option>
                        </sf:select>
                        --%>
                    
                    <%-- assetType --%>
                        <sf:label path="assetType" cssClass="col-sm-3 control-label">Asset Type</sf:label>
                        <sf:select path="assetType" cssClass="form-control" name="assetType">
                            <jstl:forEach var="type" items="${assetTypes}">
                                <sf:option value="${type}">${type.name}: ${type.category.categoryName}</sf:option>
                            </jstl:forEach>
                        </sf:select>
                        
                    <%-- inStock --%>
                        <sf:hidden path="inStock"/>
                            
                    <%-- damageStatus --%>
                        <sf:label path="damageStatus" class="col-sm-3 control-label">Status/Damage</sf:label>
                        <sf:select path="damageStatus" cssClass="form-control" name="status">
                            <%-- these two belong to the boolean inStock field of Asset
                            <sf:option value="available">Available</sf:option>
                            <sf:option value="checkedOut">Checked-Out</sf:option>
                            --%>
                            <sf:option value="none">none</sf:option>
                            <sf:option value="lost">Lost</sf:option>
                            <sf:option value="stolen">Stolen</sf:option>
                            <sf:option value="late">Late</sf:option>
                            <sf:option value="retired">Retired</sf:option>
                            <sf:option value="one">Damage: 1</sf:option>
                            <sf:option value="two">Damage: 2</sf:option>
                            <sf:option value="three">Damage: 3</sf:option>
                            <sf:option value="four">Damage: 4</sf:option>
                            <sf:option value="five">Damage: 5</sf:option>
                        </sf:select>
                            
                    <%-- serialNumber --%>
                        <sf:label path="serialNumber" cssClass="col-sm-3 control-label">Serial #</sf:label>
                        <sf:input path="serialNumber" type="text" cssClass="form-control" id="serialNum" placeholder="Scan Serial Number" name="serialNum"/>
                        
                        <%--
                        imagePath is a field of AssetType, not directly a part of Asset. Adding images should be a part of creating/ editing asset types.
                        AssetType.imagePath has type string ("text" for spring forms). Can't accept type file. Uploading image files should be a separate task on add asset types page.
                        
                        <sf:label path="imagePath" class="col-sm-3 control-label">Image</sf:label>
                        <sf:input path="imagePath" type="file" cssClass="form-control" id="image" name="image"/>
                        --%>
                        
                        <%-- temporarily exclude note pending addition of notes field in Asset class
                        
                        <sf:label path="noteCategory" cssClass="col-sm-3 control-label">Note Category</sf:label>
                        <sf:select path="noteCategory" cssClass="form-control" name="status">
                            <sf:option value="available">Available</sf:option>
                            <sf:option value="checkedOut">Checked-Out</sf:option>
                            <sf:option value="lost">Lost</sf:option>
                            <sf:option value="stolen">Stolen</sf:option>
                            <sf:option value="late">Late</sf:option>
                            <sf:option value="retired">Retired</sf:option>
                            <sf:option value="none">none</sf:option>
                            <sf:option value="one">Damage: 1</sf:option>
                            <sf:option value="two">Damage: 2</sf:option>
                            <sf:option value="three">Damage: 3</sf:option>
                            <sf:option value="four">Damage: 4</sf:option>
                            <sf:option value="five">Damage: 5</sf:option>
                        </sf:select>
                        
                        <sf:label path="assetNote" cssClass="col-sm-3 control-label">Note</sf:label>
                        <sf:textarea path="assetNote" cssClass="form-control" name="assetNote" placeholder="Enter Note Here"/>
                        --%>
                        
                        <br/>
                        <input type="submit" value="Add Asset" class="btn btn-primary"/>
                    </sf:form>
                </div>
            </div>
            <%-- Not sure what this button is for. Seems redundant
            <a class="btn btn-primary" href="home">Add Asset</a>
            --%>


            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
