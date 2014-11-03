<%-- 
    Document   : assetAddNote
    Created on : Nov 3, 2014, 8:21:32 AM
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
        <title>Add Note To Asset</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="row">
                <div class="col-md-6">
         
            <div class="col-md-12"> 

                <table class="table table-hover">

                    <tr>
                        <th></th>
                        <th>Category</th>
                        <th>Asset Type</th>
                        <th>In Stock</th>
                        <th>Serial Number</th>
                        <th>Damage Status</th>
                        <th>Notes</th>
                    </tr>
                    <jstl:forEach var="asset" items="${assetAddNote}">
                        <tr>
                            <td><img class="image-responsive" src="${types.imagePath}" alt="..."></td>
                            <td>${asset.assetType.category.categoryName}</td>
                            <td>${asset.assetType.name}</td>
                            <td>${asset.inStock}</td>
                            <td>${asset.serialNumber}</td>
                            <td>${asset.damageStatus}</td>
                            <jstl:forEach var="assetNote" items="${assetNotes}">
                                <td>${assetNote.note}</td>
                                <tr/>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </jstl:forEach>
                    </jstl:forEach>
                </table>
            </div>

                    <sf:form class="form-horizontal" action="assetAddNote" method="post" role="form" modelAttribute="assetNote">
                        <div class="form-group">
                            <sf:label path="note" class="col-sm-2 control-label">Note</sf:label>
                            <div class="col-sm-10">
                                <sf:textarea path="note" cssClass="form-control" id="note" name="assetNote" placeholder="Enter Note Here"></sf:textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="category" cssClass="control-label">Note Category</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:select path="category" cssClass="form-control" name="category">
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
                                <sf:hidden path="assetId"/>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-primary" value="Add Note"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>


            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
