<html>
    <head>
        <title>Booking</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
    </head>
    <body>
    <center>
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            .td-40    {padding-left:40px}
            .td-40t   {padding-top:40px}
            .td-40ta  {padding-left:40px;padding-top:40px}
        </style>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1 class="Three-Dee">Are you sure you want to delete this Order?</h1>
        
        <table>
                <tr>
                <td>
                    <input type="radio" name="nbWays" value="TwoWays" ${order.nbWays == 'OneWay' ? 'disabled' : 'checked'}>Round Trip
                    <input type="radio" name="nbWays" value="OneWay" ${order.nbWays == 'TwoWays' ? 'disabled' : 'checked'}>One-Way
                </td>
                </tr>
                <tr>
                    <td>Departure City</td>
                    <td class="td-40">${order.departureCity}</td>
                </tr>
                <tr>
                    <td>Arrival City</td>
                    <td class="td-40">${order.arrivalCity}</td>
                </tr>
                <tr>
                    <td>Number of Passenger</td>
                    <td class="td-40">${order.numberPassenger}</td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td class="td-40">${order.price}</td>
                </tr>
                <tr>
                    <td class="td-40t">First Name</td>
                    <td class="td-40ta">${order.firstName}</td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td class="td-40">${order.lastName}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td class="td-40">${order.address}</td>
                </tr>
                <tr>
                    <td>City</td>
                    <td class="td-40">${order.city}</td>
                </tr>
                <tr>
                    <td>State</td>
                    <td class="td-40">${order.state}</td>
                </tr>
                <tr>
                    <td>Zip Code</td>
                    <td class="td-40">${order.zipCode}</td>
                </tr>  
        </table>
    
    <br>
    <table>
        <tr>
            <td>
                <form action="<c:url value='/deleteOrdering' />" method="get">
                    <input type="hidden" name="orderNumber"       value="${order.orderNumber}">
                    <input style ="width:60px" type ="submit" name ="Yes_button" value ="Yes" class ="button"> 
                </form>
            </td>

            <td class="td-40">
                <form action="<c:url value='/book_home_page.jsp' />" method="get">
                    <input style ="width:60px" type ="submit" value ="No" class ="button"> 
                </form>
            </td>
        </tr>
    </table>
    </center>    
    </body>
</html>
