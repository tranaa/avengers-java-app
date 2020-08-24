package com.tranaa.aaron_vinayak_a2.servlets;

import com.tranaa.aaron_vinayak_a2.model.Avenger;
import com.tranaa.aaron_vinayak_a2.model.AvengerDb;
import com.tranaa.aaron_vinayak_a2.model.PowerSource;
import com.tranaa.aaron_vinayak_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet class to add an avenger
 * @author Aaron Tran, Vinayak P
 */
public class AddAvenger extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * AddAvenger servlet retrieves addAvenger request parameters and adds the avenger
     * to avenger db
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int powerId = Integer.parseInt(request.getParameter("powerSource"));
            //adding plus 1 to prevent null pointer exception
            int id = AvengerDb.getAvengers().size() + 1;
            PowerSource powerSource = PowerSourceDb.getPowerSource(powerId);
            Avenger avenger = new Avenger(id, name, description, powerSource);
            
            int rows = AvengerDb.addAvenger(avenger);
            //start of HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartOrder</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">");
            out.println("</head> ");
            out.println("<body>");
            out.println("<h1>");
            
            if (rows>0) {
                out.println("<h1>" + name + " has successfully joined the Avengers!</h1>");
            } else {
                out.println("<h1>" + name + " failed to join the Avengers</h1>");
            }
            out.println("</h1>");
            out.println("<br><br><a href='index.html'>Back to index</a>");
            out.println("</body>");
            out.println("</html>");
                       
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            request.setAttribute("error", ex.toString());
            out.println(ex.toString());
        }

    }

}
