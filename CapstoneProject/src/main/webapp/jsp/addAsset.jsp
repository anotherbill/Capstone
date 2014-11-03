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


                        <%-- assetType --%>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label class="control-label">Asset Type</label>
                            </div>
                            <div class="col-md-9">
                                <select  class="form-control" name="typeId">
                                    <jstl:forEach var="type" items="${assetTypes}">
                                        <option value="${type.assetTypeId}">${type.name}: ${type.category.categoryName}</option>
                                    </jstl:forEach>
                                </select>
                            </div>
                        </div>

                        <%--<sf:label path="assetType" cssClass="col-sm-3 control-label">Asset Type</sf:label>
                        <sf:select path="assetType" cssClass="form-control" name="assetType">
                            <jstl:forEach var="type" items="${assetTypes}">
                                <sf:option value="${type}">${type.name}: ${type.category.categoryName}</sf:option>
                            </jstl:forEach>
                        </sf:select>
                        
                        <%-- inStock --%>
                        <sf:hidden path="inStock" value="${true}"/>

                        <%-- damageStatus --%>
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="damageStatus" class="control-label">Status/Damage</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:select path="damageStatus" cssClass="form-control" name="status">
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
                            </div>
                        </div>

                        <%-- serialNumber --%>
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="serialNumber" cssClass="control-label">Serial #</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:input path="serialNumber" type="text" cssClass="form-control" id="serialNum" placeholder="Scan Serial Number" name="serialNum"/>
                            </div>
                        </div>
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
                        <div class="form-group">
                            <div class="col-md-3">
                                <input type="submit" value="Add Asset" class="btn btn-primary"/>
                            </div>
                        </div>
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
