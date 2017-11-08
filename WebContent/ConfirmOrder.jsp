<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            .td-80     {padding-top:80px}
            .td-80a         {padding-top:80px;padding-left:40px}
        </style>
        <title>Confirm Order</title>
    </head>
    <body>
    <center>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="pf" uri="/WEB-INF/maint.tld" %>
        
        <pf:DisplayUpdateButton orderNumber="${orderNumber}">
        <h4 class="Three-Dee">Please, review your order and confirm it</h4> 
        </pf:DisplayUpdateButton>
        
        <pf:DisplayNewOrderButton orderNumber="${orderNumber}"> 
        <h4>Please, review your order, enter your email address and confirm it</h4>
        <p><i>${message}</i></p>
        </pf:DisplayNewOrderButton>
        
        <form action="<c:url value='/confirmOrdering' />" method="get">  
        <table>
            <tr>
                <td>
                    <input type="hidden" name="orderNumber" value="${orderNumber}">
                    <input type="radio" name="nbWays" value="TwoWays" ${nbWays == 'OneWay' ? 'disabled' : 'checked'}>Round Trip
                    <input type="radio" name="nbWays" value="OneWay" ${nbWays == 'TwoWays' ? 'disabled' : 'checked'}>One-Way
                </td>
            </tr>
            <tr>
                <td>Departure City</td>
                <td>Arrival City</td>
            </tr>
            <tr>
                <td>
                    <input type="text" 
                               value ="${departureCity}" 
                               name="departureCity"
                               readonly>
                </td>
                <td>
                    <input type="text" 
                               value ="${arrivalCity}" 
                               name="arrivalCity"
                               readonly>
                </td>
            </tr>
            <tr>
                <td>Number of Passenger</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${numberPassenger}" 
                               name="numberPassenger"
                               size ="3"
                               readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Price
                </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${price}" 
                               name="price"
                               readonly>
                </td>
            </tr>
        </table>
                               
                               
                               
        <table>
            <tr>
                <td class ="td-80">First Name</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${firstName}" 
                               name="firstName"
                               readonly>
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
            </tr>
                <td><input type="text" 
                               value ="${lastName}" 
                               name="lastName"
                               readonly>
                </td>
            </tr>
            
            <tr>
                <td>Address</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${address}" 
                               name="address"
                               size ="56"
                               readonly>
                </td>
            </tr>
         </table>
                
         <table>
            <tr>
                <td>City</td>
                <td>State</td>
                <td>Zip Code</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${city}" 
                               name="city"
                               readonly>
                </td>
                <td><input type="text" 
                               value ="${state}" 
                               name="state"
                               readonly>
                </td>
                <td><input type="text" 
                               value ="${zipCode}" 
                               name="zipCode"
                               size ="5"
                               readonly>
                </td>
            </tr>           
        </table>
        
        <pf:DisplayNewOrderButton orderNumber="${orderNumber}"> 
        <table>
            <tr>
                <td>
                    Your Email address is required for this new order
                </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${emailAddress}" 
                               name="emailAddress"
                               size ="75">
                </td>
            </tr>
         </table>
        </pf:DisplayNewOrderButton>                          
              
        <table>
            <tr>
                <td class ="td-80">
                   <input type="submit" value="Yes" name ="Yes" class="button">
                   </form>
                </td>
                <td class ="td-80a">
                    <form action="<c:url value='/cancelOrdering' />" method="get">
                    <input type="submit" value="No" name ="No" class="button">
                    </form>
                </td>
            </tr>
        </table>
    </center>
    </body>
</html>
