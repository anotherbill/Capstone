<%-- 
    Document   : editCategory
    Created on : Nov 1, 2014, 5:38:06 PM
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
        <title>Edit Category</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="include/header.jsp"/>

            <div class="row">
                <div class="col-md-6">
                    <sf:form action="submitCategoryUpdate" method="post" class="form-horizontal" role="form" modelAttribute="category">
                        <div class="form-group">
                            <div class="col-md-3">
                                <sf:label path="categoryName">Name</sf:label>
                                </div>
                                <div class="col-md-9">
                                <sf:input type="text" path="categoryName" cssClass="form-control"/>
                            </div>
                        </div>
                        <sf:hidden path="categoryId"/>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <input type="submit" value="Edit Category" class="btn btn-primary"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>

            <jsp:include page="include/footer.jsp"/>
        </div>
    </body>
</html>
