<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <title>Cart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            .menuTitle {
                text-align: center;
                font-family: Garmond;
            }
            table,tr,th,td{
                border: 1px solid black;
                padding: 5px;
            }

            table {
                border-collapse: collapse;
                width: 90%;
                margin: auto;
            }
            .packageImage{
                width: 10em;
            }

            tbody tr:hover.selected td,
            tbody tr:hover td {
              background-color: orangered;
              cursor: pointer;
            }
        </style>
    </head>
    <body>
        <input id="menuBtn" type="button"  onclick="window.location = 'menu.htm'" value="Back To Menu" >
        <table id="packageTable">
            <caption class="menuTitle">Cart</caption>
            <thead>
                <tr>
                    <th>Package Order Id: </th>
                    <th>Order Id: </th>
                    <th>Package Id: </th>
                    <th>Customer Id: </th>
                    <th>Price Per Package: </th>
                    <th>Quantity: </th>
                    <th>Is Open: </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pkgOrderList}" var="pack">
                    <tr>
                        <td>${pack.pkgOrderId}</td>
                        <td>${pack.orderId}</td>
                        <td>${pack.packageId}</td>
                        <td>${pack.customerId}</td>
                        <td>${pack.pricePerPkg}</td>
                        <td>${pack.quantity}</td>
                        <td>${pack.isOpen}</td>
                        <td>
                            <a href="cartdelete.htm?pkgOrderId=${pack.pkgOrderId}"><button id="deleteButton">Delete</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>


