package com.tranaa.aaron_vinayak_a2.servlets;

import com.tranaa.aaron_vinayak_a2.model.Avenger;
import com.tranaa.aaron_vinayak_a2.model.AvengerDb;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to get an avenger  
 * @author Aaron Tran , Vinayak P
 */
public class GetAvengers extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * GetAvenger servlet retrieves list of avengers from avenger db
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
      
            ArrayList<Avenger> avengers = AvengerDb.getAvengers();
                        
            request.setAttribute("avengers", avengers);
                       
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
        //Forward information to the jsp page
        RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
        rd.forward(request, response);
    }
}
