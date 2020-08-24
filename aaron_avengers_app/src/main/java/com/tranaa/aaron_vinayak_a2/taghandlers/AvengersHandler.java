package com.tranaa.aaron_vinayak_a2.taghandlers;

import com.tranaa.aaron_vinayak_a2.model.Avenger;
import com.tranaa.aaron_vinayak_a2.model.AvengerDb;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Class represents a custom tag for Avengers select tag
 * @author Aaron Tran
 */
public class AvengersHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag.The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            //Create a new List using the get avenger method
            ArrayList<Avenger> avengers = AvengerDb.getAvengers();
            //print html for select element containing all avengers
            out.print("<div class='select-wrapper'>");
            out.print("<select name='avengersList' required>");
            for(Avenger avenger: avengers){
                out.print("<option value='"+avenger.getId()+"'>"+avenger.getName()+"</option>");
            }
            out.print("</select>");
            out.print("</div>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in PowerSourceHandler tag", ex);
        } catch (Exception ex) {
            Logger.getLogger(PowerSourceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
