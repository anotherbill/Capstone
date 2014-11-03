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

                    <form class="form-horizontal" action="assetAddNote" method="post" role="form">
                        <div class="form-group">
                            <label for="input" class="col-sm-2 control-label">Note</label>
                            <div class="col-sm-10">
                                <textArea class="form-control" id="note" name="assetNote" placeholder="Enter Note Here"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label class="control-label">Status/Damage</label>
                                </div>
                                <div class="col-md-9">
                                <select class="form-control" name="status">
                                    <option value="none">none</option>
                                    <option value="lost">Lost</option>
                                    <option value="stolen">Stolen</option>
                                    <option value="late">Late</option>
                                    <option value="retired">Retired</option>
                                    <option value="one">Damage: 1</option>
                                    <option value="two">Damage: 2</option>
                                    <option value="three">Damage: 3</option>
                                    <option value="four">Damage: 4</option>
                                    <option value="five">Damage: 5</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-primary" value="Add Note"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
