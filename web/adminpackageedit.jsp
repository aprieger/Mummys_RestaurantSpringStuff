<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="react.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.29/browser.js"></script>
        <link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        
        <link href="css/CustomerPackageUI.css" rel="stylesheet" type="text/css" />
        <style>
            
        </style>
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'adminpackages.htm'" value="Back To Admin: Packages" >
        <form:form method="POST" action="${userActionUrl}" modelAttribute="pkgForm">
            <form:input path="packageId" type="hidden" name="packageId" value="${packageDetails.packageId}" /><br>
            <form:label path="name">Name:</form:label>
            <form:input path="name" type="text" name="name" value="${packageDetails.name}" /><br>
            <form:label path="description">Description: </form:label>
            <form:input path="description" type="text" name="description" value="${packageDetails.description}" /><br>
            <form:label path="mealCategory">Meal Category</form:label>
            <form:input path="mealCategory" type="text" name="mealCategory" value="${packageDetails.mealCategory}" /><br>
            <form:label path="imageSource">Image Source</form:label>
            <form:input path="imageSource" type="text" name="imageSource" value="${packageDetails.imageSource}" /><br>        
            <form:label path="price">Price</form:label>
            <form:input path="price" type="text" name="price" value="${packageDetails.price}" /><br>  
            <form:label path="isSpecial">Is Special</form:label>
            <form:input path="isSpecial" type="text" name="isSpecial" value="${packageDetails.isSpecial}" /><br>  
            <form:label path="mealType">Meal Type</form:label>
            <form:input path="mealType" type="text" name="mealType" value="${packageDetails.mealType}" /><br>          
            <input type="submit" value="Confirm Changes">
        </form:form>
    </body>
</html>


