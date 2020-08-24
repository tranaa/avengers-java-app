package com.tranaa.aaron_vinayak_a2.servlets;

import com.tranaa.aaron_vinayak_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet class to add power source
 * @author Aaron Tran, Vinayak P
 */
public class AddPowerSource extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * AddPowerSource servlet retrieves addPowerSource request parameters and adds the power
     * source to powersource db
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String powerSource = request.getParameter("description");
            int rows = PowerSourceDb.addPowerSource(powerSource);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Delete Avenger</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">");
            out.println("</head>");
            out.println("<body>");            
            if (rows>0) {
                out.println("<h1>" + powerSource + " added successfully!</h1>");
            } else {
                out.println("<h1>" + powerSource + " failed to add</h1>");
            }
            out.println("<br><br><a href='index.html'>Back to index</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }    
    }

}
