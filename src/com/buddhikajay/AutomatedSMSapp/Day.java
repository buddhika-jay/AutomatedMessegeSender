package com.buddhikajay.AutomatedSMSapp;

/**
 * Created by buddhika on 6/3/15.
 */
public class Day {
    String name;
    int id;
    Boolean checked;

    /**
     *
     * @param name Name of the day
     * @param id id form 0 to 6
     * @param checked ture if checked
     */
    public Day(String name, int id, boolean checked){
        this.name = name;
        this.id = id;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
