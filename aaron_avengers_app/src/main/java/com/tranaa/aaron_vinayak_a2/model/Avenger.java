
package com.tranaa.aaron_vinayak_a2.model;

/**
 * class for avenger
 * @author Aaron Tran, Vinayak P
 */
public class Avenger {
    
    //data fields
    private int id;
    private String name;
    private String description;
    private PowerSource powerSource;
    
    /**
     * This is the 4-arg constructor initializing all data fields
     * @param id avenger id
     * @param name avenger name
     * @param description short description of avenger
     * @param powerSource avengers source of power
     */
    public Avenger(int id, String name, String description, PowerSource powerSource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.powerSource = powerSource;
    }
    
    /**
     * getter for avenger id
     * @return avenger id
     */
    public int getId() {
        return id;
    }

    /**
     * getter for avenger name
     * @return avenger name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for avenger description
     * @return avenger description
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter for avenger power source
     * @return avenger power source
     */
    public PowerSource getPowerSource() {
        return powerSource;
    }
    
}
