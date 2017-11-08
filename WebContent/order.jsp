

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            .caption   {text-align:center;height:30px}
            .td-80     {padding-top:80px}
            .td-30     {padding-top:30px}
            .td-30a    {padding-top:30px;padding-right:20px}
            .td-20     {padding-top:20px}
            td         {padding-right:20px}
        </style>
        <title>Ordering</title>
    </head>
    <body>
    <center>
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="pf" uri="/WEB-INF/maint.tld" %>
       
        <form action="<c:url value='/updateOrdering' />" method="get">
    
        <table>
            <input type="hidden" name="orderNumber" value="${orderNumber}">
            
            <caption align="top" class="Three-Dee">Ordering</caption>
            <tr><td><p><i>${message}</i></p></td></tr>
            <tr>
                <td>
                    <input type="radio" name="nbWays" value="TwoWays" ${nbWays == 'TwoWays' ? 'checked' : ''}>Round Trip
                    <input type="radio" name="nbWays" value="OneWay" ${nbWays == 'OneWay' ? 'checked' : ''}>One-Way
                </td>
            </tr>
         </table>
         <table>
            <tr>
                <td>Departure City</td>
                <td>Arrival City</td>
            </tr>
            <tr>
                <td>
                    <select name ="departureCity">
                        <option value ="${departureCity}" selected>${departureCity}</option>
                        <option value="Boston">Boston</option>
                        <option value="Chicago">Chicago</option>
                        <option value="Las Vegas">Las Vegas</option>
                        <option value="Los Angeles">Los Angeles</option>
                        <option value="New York">New York</option>
                    </select>
                </td>
                <td>
                    <select name ="arrivalCity">
                        <option value="${arrivalCity}" selected>${arrivalCity}</option>
                        <option value="Boston">Boston</option>
                        <option value="Chicago">Chicago</option>
                        <option value="Las Vegas">Las Vegas</option>
                        <option value="Los Angeles">Los Angeles</option>
                        <option value="New York">New York</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Number of Passenger</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${numberPassenger}" 
                               name="numberPassenger"
                               size ="3">
                </td>
            </tr>
       </table>   
                               
       
                               
       <pf:DisplayNewOrderButton orderNumber="${orderNumber}">
       <table class ="td-30">
            <tr>
                <td>
                    <input type="submit" value="Calculate Price" name ="Calculate_Price" class="button">
                    </form>
                </td>
                <form action="<c:url value='/cancelOrdering' />" method="get">
                <td>
                    <input type="submit" value="Cancel" name ="Cancel" class="button">
                </td>
                </form>
            </tr>
        </table>    
       </pf:DisplayNewOrderButton>
        
        <form action="<c:url value='/confirmOrdering' />" method="get">
        <table>
            <tr>
                <td class ="td-80">First Name</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${firstName}" 
                               name="firstName">
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
            </tr>
                <td><input type="text" 
                               value ="${lastName}" 
                               name="lastName">
                </td>
            </tr>
            <tr>
                <td>Address</td>
            </tr>
                <td><input type="text" 
                               value ="${address}" 
                               name="address"
                               size ="56">
                </td>
            </tr>
        
            <tr>
                <td>City</td>
                <td>State</td>
                <td>Zip Code</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${city}" 
                               name="city"
                               size ="56">
                </td>
                <td>
                    <select name ="state">
                        <option value="${state}" selected>${state}</option>
                        <option value="Alabama">Alabama</option>
                        <option value="Alaska">Alaska</option>
                        <option value="Arizona">Arizona</option>
                        <option value="Arkansas">Arkansas</option>
                        <option value="California">California</option>
                        <option value="Colorado">Colorado</option>
                        <option value="Connecticut">Connecticut</option>
                        <option value="Delaware">Delaware</option>
                        <option value="Florida">Florida</option>
                        <option value="Georgia">Georgia</option>
                        <option value="Hawaii">Hawaii</option>
                        <option value="Idaho">Idaho</option>
                        <option value="Illinois">Illinois</option>
                        <option value="Indiana">Indiana</option>
                        <option value="Iowa">Iowa</option>
                        <option value="Kansas">Kansas</option>
                        <option value="Kentucky">Kentucky</option>
                        <option value="Louisiana">Louisiana</option>
                        <option value="Maine">Maine</option>
                        <option value="Maryland">Maryland</option>
                        <option value="Massachusetts">Massachusetts</option>
                        <option value="Michigan">Michigan</option>
                        <option value="Minnesota">Minnesota</option>
                        <option value="Mississippi">Mississippi</option>
                        <option value="Missouri">Missouri</option>
                        <option value="Montana">Montana</option>
                        <option value="Nebraska">Nebraska</option>
                        <option value="Nevada">Nevada</option>
                        <option value="New Hampshire">New Hampshire</option>
                        <option value="New Jersey">New Jersey</option>
                        <option value="New Mexico">New Mexico</option>
                        <option value="New York">New York</option>
                        <option value="North Carolina">North Carolina</option>
                        <option value="North Dakota">North Dakota</option>
                        <option value="Ohio">Ohio</option>
                        <option value="Oklahoma">Oklahoma</option>
                        <option value="Oregon">Oregon</option>
                        <option value="Pennsylvania">Pennsylvania</option>
                        <option value="Rhode Island">Rhode Island</option>
                        <option value="South Carolina">South Carolina</option>
                        <option value="South Dakota">South Dakota</option>
                        <option value="Tennessee">Tennessee</option>
                        <option value="Texas">Texas</option>
                        <option value="Utah">Utah</option>
                        <option value="Vermont">Vermont</option>
                        <option value="Virginia">Virginia</option>
                        <option value="Washington">Washington</option>
                        <option value="West Virginia">West Virginia</option>
                        <option value="Wisconsin">Wisconsin</option>
                        <option value="Wyoming">Wyoming</option>
                    </select>
                </td>
                <td><input type="text" 
                               value ="${zipCode}" 
                               name="zipCode"
                               size ="5">
                </td>
            </tr>
        </table>
                               
               
       <pf:DisplayNewOrderButton orderNumber="${orderNumber}">
                
        <pf:DisplayPrice price="${price}">
        <table class="td-80">
            <tr>
                <td>
                    Price per Passenger
                </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${pricePerPassenger}" 
                               name="pricePerPassenger"
                               readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Total Price
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
                <td class ="td-30">
                                            
                    <input type="hidden" name="orderNumber"       value="${orderNumber}">
                    <input type="hidden" name="firstName"          value="${firstName}">
                    <input type="hidden" name="lastName"          value="${lastName}">
                    <input type="hidden" name="address"           value="${address}">
                    <input type="hidden" name="city"              value="${city}">
                    <input type="hidden" name="state"             value="${state}">
                    <input type="hidden" name="zipCode"           value="${zipCode}">
                    <input type="hidden" name="nbWays"            value="${nbWays}">
                    <input type="hidden" name="departureCity"     value="${departureCity}">
                    <input type="hidden" name="arrivalCity"       value="${arrivalCity}">
                    <input type="hidden" name="numberPassenger"   value="${numberPassenger}">
                    <input type="hidden" name="price"             value="${price}">
                                        
                    <input type="submit" value="New Order" name ="NewOrder" class="button">
                    </form>
                </td>                
            </tr>
        </table>
        </pf:DisplayPrice>                       
        
        </pf:DisplayNewOrderButton>                        
                               
       <pf:DisplayUpdateButton orderNumber="${orderNumber}">
                     
       <table class ="td-80">
           <tr>
                <td>
                    Price per Passenger
                </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${pricePerPassenger}" 
                               name="pricePerPassenger"
                               readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Total Price
                </td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${priceOrder == null ? price : priceOrder}" 
                               name="price"
                               readonly>
                </td>
            </tr>
        </table>    
                               
        
       <table class="td-30">
            <tr>
                <td>
                    <input type="submit" value="Re-Calculate Price" name ="Calculate_Price" class="button">
                    </form>
                </td>
                
                <form action="<c:url value='/deleteOrdering' />" method="get">
                <td>
                    <input type="hidden" name="orderNumber"       value="${orderNumber}">
                    <input type="submit" value="Delete Order" name ="DeleteOrder" class="button">
                </td>
                </form>

                
                <form action="<c:url value='/cancelOrdering' />" method="get">
                <td>
                    <input type="submit" value="Cancel" name ="Cancel" class="button">
                </td>
                </form>
            </tr>
        </table>
                  
                               
        
       
        <pf:DisplayPrice price="${price}">                       
        <table>
            <tr>
                <td class ="td-30">
                    <form action="<c:url value='/confirmOrdering' />" method="get">
                        
                    <input type="hidden" name="orderNumber"       value="${orderNumber}">
                    <input type="hidden" name="firstName"          value="${firstName}">
                    <input type="hidden" name="lastName"          value="${lastName}">
                    <input type="hidden" name="address"           value="${address}">
                    <input type="hidden" name="city"              value="${city}">
                    <input type="hidden" name="state"             value="${state}">
                    <input type="hidden" name="zipCode"           value="${zipCode}">
                    <input type="hidden" name="nbWays"            value="${nbWays}">
                    <input type="hidden" name="departureCity"     value="${departureCity}">
                    <input type="hidden" name="arrivalCity"       value="${arrivalCity}">
                    <input type="hidden" name="numberPassenger"   value="${numberPassenger}">
                    <input type="hidden" name="price"             value="${price}">
                    
                    <input type="submit" value="Update Order" name ="UpdateOrder" class="button">
                    </form>
            </tr>
        </table>
        </pf:DisplayPrice>
                
        </pf:DisplayUpdateButton>                       
       
             
    </center>                   
    </body>
</html>
