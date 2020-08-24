
package com.tranaa.aaron_vinayak_a2.model;

/**
 * class for power source
 * @author Aaron Tran, Vinayak P
 */
public class PowerSource {
    
    //data fields
    private int id;
    private String description;

    /**
     * This is the 2-arg constructor initializing all data fields
     * @param id power source id
     * @param description short description of power source
     */
    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * getter for power source id
     * @return power source id
     */
    public int getId() {
        return id;
    }

    /**
     * getter for power source description
     * @return power source description
     */
    public String getDescription() {
        return description;
    }
    
}
