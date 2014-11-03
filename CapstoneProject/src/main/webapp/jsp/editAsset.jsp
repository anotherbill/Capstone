<%-- 
    Document   : editAsset
    Created on : Oct 29, 2014, 10:40:13 AM
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
        <title>Edit Asset</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            ${updateError}
            <div class="row">
                <div class="col-md-6">
                    <sf:form cssClass="form-horizontal" role="form" action="submitAssetUpdate" method="post" id="addEditAsset" modelAttribute="asset">



                        <%-- assetType --%>




                        <%-- inStock --%>
                        <sf:hidden path="assetType.assetTypeId"/>

                        <%-- damageStatus --%>
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="damageStatus" cssClass="control-label">Status/Damage</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:select path="damageStatus" cssClass="form-control">  
                                    <sf:option value="none">none</sf:option>
                                    <sf:option value="lost">Lost</sf:option>
                                    <sf:option value="stolen">Stolen</sf:option>
                                    <sf:option value="late">Late</sf:option>
                                    <sf:option value="retired">Retired</sf:option>
                                    <sf:option value="Damage: 1">Damage: 1</sf:option>
                                    <sf:option value="Damage: 2">Damage: 2</sf:option>
                                    <sf:option value="Damage: 3">Damage: 3</sf:option>
                                    <sf:option value="Damage: 4">Damage: 4</sf:option>
                                    <sf:option value="Damage: 5">Damage: 5</sf:option>
                                </sf:select>
                            </div>
                        </div>
                                
                                
                                <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="inStock" cssClass="control-label">In Stock</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:select path="inStock" cssClass="form-control" name="status">
                                    <sf:option value="true">In Stock</sf:option>
                                    <sf:option value="false">Out of Stock</sf:option>
                                </sf:select>
                                

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="serialNumber" cssClass="control-label">Serial #</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:input path="serialNumber" type="text" cssClass="form-control"/>
                            </div>
                        </div>

                        <sf:hidden path="assetId"/>
                        <input type="hidden" value="asset.assetTypeId"/>

                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <input type="submit" value="Edit Asset" class="btn btn-primary"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>


            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
