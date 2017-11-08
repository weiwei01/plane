package booking.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import booking.data.*;
import booking.business.*;


public class DeleteOrderingServlet extends HttpServlet {

       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = null;
        String button = "";
        String orderNumber = null;
        Order order = null;
        
                
        // get parameters from the request
        orderNumber = request.getParameter("orderNumber");
        
        // store the product object in the session
        HttpSession session = request.getSession();  
        
        button = request.getParameter("Yes_button"); 

        if ( button == null)
        {        
            order =  OrderingDB.selectOrder(orderNumber);
            session.setAttribute("order", order); 
            url = "/confirm_Order_delete.jsp"; 
        }
        else
        {
             synchronized(session)
             {
                OrderingDB.deleteOrdering(orderNumber);
                OrderingDB.deleteOrder(orderNumber);
             }
             url = "/book_home_page.jsp";
                     
        }

      
    
    // forward request and response objects to JSP page
    RequestDispatcher dispatcher =
         getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);

    }

         
   

}
