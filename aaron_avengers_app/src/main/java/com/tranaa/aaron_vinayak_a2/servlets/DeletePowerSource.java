package com.tranaa.aaron_vinayak_a2.servlets;

import com.tranaa.aaron_vinayak_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to delete power source
 * @author Aaron Tran, Vinayak P
 */
public class DeletePowerSource extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * DeletePowerSource servlet retrieves deletePowerSource request parameters and deletes the power
     * source from powersource db
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("powerSource"));
            //Delete power source using power ID
            int rows = PowerSourceDb.deletePowerSource(id);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Delete Power Source</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">");
            out.println("</head>");
            out.println("<body>");            
            if (rows>0) {
                out.println("<h1>Power source deleted successfully!</h1>");
            } else {
                out.println("<h1>Power source failed to delete</h1>");
            }
            out.println("<br><br><a href='index.html'>Back to index</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
    }

}
