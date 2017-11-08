package booking.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class CancelOrderingServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = "/book_home_page.jsp";
               
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }
}