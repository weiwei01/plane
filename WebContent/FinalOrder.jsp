<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            .td-80     {padding-top:80px}
        </style>
        <title>Final Order</title>
    </head>
    <body>
    <center>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <table>
            <center>
            <tr>
                <td>Your Confirm Order Number is </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${orderNumber}" 
                               name="orderNumber"
                               readonly
                               size ="28">
                </td>
            </tr>
            <tr>
                <td class ="td-80">
                    <form action="<c:url value='/cancelOrdering' />" method="get">
                    <input type="submit" Value ="Main Menu" class="button">
                    </form>
                </td>
            </tr>
            </center>
        </table>
    </center>
    </body>
</html>
