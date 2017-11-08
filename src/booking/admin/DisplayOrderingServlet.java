package booking.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import booking.data.*;
import java.util.*;
import booking.business.*;


public class DisplayOrderingServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String message = null;
        String url     = null;
        Order order    = null;
        Double pricePerPassenger;
        
        // get parameters from the request
        String orderingNumber = request.getParameter("orderingNumber");
        String emailAddress = request.getParameter("emailAddress");
        
        if(OrderingDB.exists(orderingNumber, emailAddress))
        {
            order = OrderingDB.selectOrder(orderingNumber);
            request.setAttribute("orderNumber", order.getOrderNumber());
            request.setAttribute("firstName", order.getFirstName());
            request.setAttribute("lastName", order.getLastName());
            request.setAttribute("address", order.getAddress());
            request.setAttribute("lastName", order.getLastName());
            request.setAttribute("city", order.getCity());
            request.setAttribute("state", order.getState());
            request.setAttribute("zipCode", order.getZipCode());
            request.setAttribute("nbWays", order.getNbWays());
            request.setAttribute("departureCity", order.getDepartureCity());
            request.setAttribute("arrivalCity", order.getArrivalCity());
            request.setAttribute("numberPassenger", order.getNumberPassenger());
            request.setAttribute("priceOrder", order.getPrice());
            pricePerPassenger = order.getPrice()/Integer.parseInt(order.getNumberPassenger());
            request.setAttribute("pricePerPassenger", pricePerPassenger);
            
            
            
            

            url = "/order.jsp";
        }
        else
        {
            message = "No Existing Ordering, Please, re-enter your information";
            url = "/book_home_page.jsp";
        }
        
        request.setAttribute("message", message);
        
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }    
}