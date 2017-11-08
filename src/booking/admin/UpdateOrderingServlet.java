package booking.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import booking.data.*;
import booking.business.*;
import java.util.*;


public class UpdateOrderingServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
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
        String button = request.getParameter("Calculate_Price");
        String message = "Please, enter your complete order or only your travel information";
        int nbPassenger = 0;
        int numberWays;
        Double price = 0.0;
        Double pricePerPassenger = 0.0;
        
        if (button != null && nbWays == null)
           message = "Please, enter One-way or Round Trip";
        else  
        if (button != null && departureCity == "")
           message = "Please, enter the departure city";
        else
        if (button != null && arrivalCity == "")
           message = "Please, enter the arrival city";
        else
        if (button != null && departureCity.equalsIgnoreCase(arrivalCity))
           message = "Please, select the departure and arrival cities not identical";
        else
        if (button != null && numberPassenger == "")
        {
            message = "Please, enter the number of passenger";
        }
        else
        if (button != null && !isStringInt(numberPassenger))
        {
            message = "Please, enter a real number of passenger";
        }
        else
        {
            if (button != null)
            {
                Order Ordering = new Order();

                Ordering.setFirstName(firstName);
                Ordering.setLastName(lastName);
                Ordering.setAddress(address);
                Ordering.setCity(city);
                Ordering.setState(state);
                Ordering.setZipCode(zipCode);
                Ordering.setDepartureCity(departureCity);
                Ordering.setArrivalCity(arrivalCity);
                Ordering.setNumberPassenger(numberPassenger);

                if (numberPassenger != null)
                {
                    nbPassenger = Integer.parseInt(numberPassenger);
                }

                if ((nbWays != null) && (nbWays.equalsIgnoreCase("OneWay")))
                    {
                        numberWays = 1;
                    }
                else 
                    {
                        numberWays = 2;
                    }

                pricePerPassenger = OrderingDB.selectPrice(departureCity, arrivalCity);
                
                price = pricePerPassenger * nbPassenger * numberWays;
                pricePerPassenger = pricePerPassenger * numberWays;

                message = "";
            }
        }
        
        request.setAttribute("pricePerPassenger",pricePerPassenger);
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
        request.setAttribute("message",message);
        
        String url = "/order.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }    
    
    private boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

}