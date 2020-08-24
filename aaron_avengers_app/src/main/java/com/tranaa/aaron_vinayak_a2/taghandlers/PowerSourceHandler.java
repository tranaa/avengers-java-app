package com.tranaa.aaron_vinayak_a2.taghandlers;

import com.tranaa.aaron_vinayak_a2.model.PowerSource;
import com.tranaa.aaron_vinayak_a2.model.PowerSourceDb;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Class represents custom tag for customer power source select tag
 * @author Aaron Tran
 */
public class PowerSourceHandler extends SimpleTagSupport {

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
            //create power source arraylist
            ArrayList<PowerSource> powerSources = PowerSourceDb.getPowerSources();
            
            //print html for select element containing power sources
            out.print("<div class='select-wrapper'>");
            out.print("<select name='powerSource' required>");
            for(PowerSource powerSource: powerSources){
                out.print("<option value='"+powerSource.getId()+"'>"+powerSource.getDescription()+"</option>");
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
