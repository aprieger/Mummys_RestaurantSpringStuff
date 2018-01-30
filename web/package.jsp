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
            #nameAndPrice {
                border-style: solid;
                border-width: 2px;
                display: flex;
                width: 90%;
                margin: auto;
                margin-bottom: 3em;
            }
            #name {
                font-size: 3em;
                font-family: Garamond;
                padding: .2em;
                padding-left:.4em;
                margin-right: auto;
            }
            #price {
                font-size: 4em;
                font-family: Garamond;
                padding: .2em;
                padding-right:.4em;
            }

            #infoAndImage{
                display: flex;
                justify-content: center;
                width: 90%;
                margin: auto;
            }
            #info {
                border-style: solid;
                border-width: 2px;
                width:40em;
                margin-right: auto;
            }
            #description {
                font-size: 2em;
                font-family: Garamond;
                padding: .2em;
                padding-left:.4em;
            }
            #category {
                font-size: 2em;
                font-family: Garamond;
                padding: .2em;
                padding-left:.4em;
            }
            #special {
                font-size: 2em;
                font-family: Garamond;
                padding: .2em;
                padding-left:.4em;
            }
            #type {
                font-size: 2em;
                font-family: Garamond;
                padding: .2em;
                padding-left:.4em;
            }
            #image {
                border-style: solid;
                border-width: 2px;
                width:40em;
                text-align: center;
            }
            #packImg {
                width: 40em;
                margin-left: auto;
                margin-right: auto;
            }
            #menuBtn {
                margin: 1em;
                margin-left: 6em;
                padding:.5em;
            }
        </style>
    </head>
    <body>
        <p id="packID">ID: ${packageDetails.packageId}</p><br></br>
        <input id="menuBtn" type="button"  onclick="window.location = 'menu.htm'" value="Back To Menu" >
        <div id="nameAndPrice">
            <div id="name">${packageDetails.name}</div>
            <div id="price">${packageDetails.price}</div>
        </div>
        <div id="infoAndImage">
            <div id="info">
                <p id="description">${packageDetails.description}</p>
                <p id="category">Category : ${packageDetails.mealCategory}</p>
                <p id="special">Special: ${packageDetails.isSpecial}</p>
                <p id="type">Type: ${packageDetails.mealType}</p>
            </div>
            <div id="image">
                <img id="packImg" src="${packageDetails.imageSource}" alt="${packageDetails.imageSource}"/>
            </div>
        </div>
        <form:form method="POST" action="${userActionUrl}" modelAttribute="formPkgOrder">
            <form:input path="packageIdKey" type="hidden" name="packageIdKey" value="${packageDetails.packageId}" /><br>
            <form:label path="quantity">Quantity:</form:label>
            <form:input path="quantity" type="text" name="quantity" value="1" /><br>
            <input type="submit" value="Add To Cart">
        </form:form>
    </body>
</html>


