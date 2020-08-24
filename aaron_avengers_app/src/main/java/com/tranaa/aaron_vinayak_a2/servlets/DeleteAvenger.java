package com.tranaa.aaron_vinayak_a2.servlets;

import com.tranaa.aaron_vinayak_a2.model.AvengerDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to delete avenger
 * @author Aaron Tran, Vinayak P
 */
public class DeleteAvenger extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * DeleteAvenger servlet retrieves deleteAvenger request parameters and deletes the avenger
     * from avenger db
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try (PrintWriter out = response.getWriter()) {
            int avengerId = Integer.parseInt(request.getParameter("avengersList"));
            //statment to delete avenger using the ID
            int rows = AvengerDb.deleteAvenger(avengerId);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Delete Avenger</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">");
            out.println("</head>");
            out.println("<body>");
            if (rows>0) {
                out.println("<h1>Avenger deleted successfully!</h1>");
            } else {
                out.println("<h1>Avenger failed to delete</h1>");
            }
            out.println("<br><br><a href='index.html'>Back to index</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
    }

}
