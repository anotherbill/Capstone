<%-- 
    Document   : addAssetType
    Created on : Nov 1, 2014, 3:15:02 PM
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
        <title>Add Asset Type</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="row">
                <div class="col-md-6">
                    <sf:form cssClass="form-horizontal" role="form" action="submitNewAssetType" method="post" modelAttribute="newAssetType">
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="name">Name</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:input type="text" path="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label>Category</label>
                            </div>
                            <div class="col-md-9">
                                <select class="form-control" name="categoryId">
                                    <jstl:forEach var="category" items="${categoryList}">
                                        <option value="${category.categoryId}">${category.categoryName}</option>
                                    </jstl:forEach>       
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="imagePath">Image</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:input type="text" path="imagePath" cssClass="form-control"/>
                            </div>
                        </div>

                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <input type="submit" value="Add Asset Type" class="btn btn-primary"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>

            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
