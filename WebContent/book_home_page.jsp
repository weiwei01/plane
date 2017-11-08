<%-- 
    Document   : bookhomepage
    Created on : Nov 23, 2013, 12:06:14 PM
    Author     : Karyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            td    {padding:5px;border:0px solid} 
            .td-40    {padding-left:40px}
            .tr-35     {padding-top:35px}
            .tr-231     {padding-top:231px}
            .center {text-align:center}
            .caption   {text-align:center;height:30px}
            .table  {border:1px solid;width:400px;height:200px;
            background-image: -moz-radial-gradient(center, ellipse farthest-corner, #FFFFFF 0%, #00A3EF 100%)}
        </style>
        <title>Book Home Page</title>
    </head>
    <body>
    <center>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<img src="images/logo.png"  />
        <table>
            <tr>
               
              
                <td class="td-40">
                    <table class ="table">
                        <caption align="top" class="Three-Dee">New order</caption>
                        <tr>
                           <td class="tr-35"></td> 
                        </tr>
                        <tr>
                            <td class ="center">
                                <form action="<c:url value='/updateOrdering' />" method="get">
                                <input type ="submit" value ="New Ordering" class="button">
                                </form>
                            </td>
                        </tr>
                            <td class="tr-231"></td>
                        </tr>
                    </table>
                </td>
                 <td>
                    <form action="<c:url value='/displayOrdering' />" method="get">
                    <table class ="table">
                        <caption align="top" class="Three-Dee">Reviewing Ordering</caption>
                        <tr><td><p><i>${message == null ? 'Please, enter Ordering Number and email' : message}</i></p></td></tr>
                        <tr>
                            <td>Ordering Number</td>
                        </tr>
                        <tr>
                            <td><input type="text" 
                                name="orderingNumber">
                            </td>
                        </tr>
                        <tr>
                            <td>Email Address</td>
                        </tr>
                        <tr>
                            <td><input type="text" 
                               name="emailAddress"
                               size ="50">
                            </td>
                        </tr>
                        <tr>
                            <td class="tr-35"></td>
                        <tr>
                            <td class ="center">
                                <input type ="submit" value ="View Ordering" name ="View_Ordering" class="button">
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td class="tr-35"></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </center>
    </body>
</html>
