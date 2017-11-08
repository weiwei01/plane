package booking.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import booking.data.OrderingDB;
import booking.business.*;


public class ConfirmOrderingServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = null;
        String yesButton = null;
        int intOrderNumber = 0;
        Order ordering = null;
        
        String orderNumber = request.getParameter("orderNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String nbWays = request.getParameter("nbWays");
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        String numberPassenger = request.getParameter("numberPassenger");
        String price = request.getParameter("price");
        
        request.setAttribute("orderNumber",orderNumber);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("zipCode", zipCode);
        request.setAttribute("nbWays", nbWays);
        request.setAttribute("departureCity", departureCity);
        request.setAttribute("arrivalCity", arrivalCity);
        request.setAttribute("numberPassenger", numberPassenger);
        request.setAttribute("price", price);
        
        String emailAddress = OrderingDB.selectEmailAddress(orderNumber);
        yesButton = request.getParameter("Yes");
        
        if ((yesButton == null) && (firstName == "" || lastName == "" || address == "" || city == "" || state == "" || zipCode == ""))
        {
            String message = "Enter all information before ordering";
            request.setAttribute("message", message);
            url = "/order.jsp";
        }
        else
        {
            if ( yesButton != null)
            {
                if (emailAddress == null)
                {
                    emailAddress = request.getParameter("emailAddress");

                    if (emailAddress == null || emailAddress == "")
                    {
                        String message = "Please, enter Email Address";
                        request.setAttribute("message",message);
                        url = "/ConfirmOrder.jsp";  
                    }
                    else
                    {
                        OrderingDB.insertOrder(emailAddress);

                        ordering = new Order();
                        
                        intOrderNumber = OrderingDB.selectLastOrderingNumber();
                        //orderNumber = Integer.toString(intOrderNumber);
                        orderNumber = String.format("%7d",intOrderNumber).replace(' ','0');
                                
                        ordering.setOrderNumber(orderNumber);
                        ordering.setFirstName(firstName);
                        ordering.setLastName(lastName);
                        ordering.setAddress(address);
                        ordering.setCity(city);
                        ordering.setState(state);
                        ordering.setZipCode(zipCode);
                        ordering.setNbWays(nbWays);
                        ordering.setDepartureCity(departureCity);
                        ordering.setArrivalCity(arrivalCity);
                        ordering.setNumberPassenger(numberPassenger);
                        ordering.setPrice(Double.parseDouble(price));
                                
                        OrderingDB.insertOrdering(ordering);
                        
                        request.setAttribute("orderNumber",orderNumber);
                        url = "/FinalOrder.jsp";
                    }
                }
                else
                {
                        ordering = new Order();
                        
                        ordering.setOrderNumber(orderNumber);
                        ordering.setFirstName(firstName);
                        ordering.setLastName(lastName);
                        ordering.setAddress(address);
                        ordering.setCity(city);
                        ordering.setState(state);
                        ordering.setZipCode(zipCode);
                        ordering.setNbWays(nbWays);
                        ordering.setDepartureCity(departureCity);
                        ordering.setArrivalCity(arrivalCity);
                        ordering.setNumberPassenger(numberPassenger);
                        ordering.setPrice(Double.parseDouble(price));
                                
                        OrderingDB.updateOrdering(ordering);
                        
                        url = "/FinalOrder.jsp";
                }
            }
            else
            {
                url = "/ConfirmOrder.jsp";
            }
        }
               
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }
}