package mohannad.soliman.Entities;

import mohannad.soliman.DTOs.Property.PropertyValuesDTO;

import java.util.HashMap;

/**
 * Parent class of all components
 */
abstract public class Component {
    protected String ID;
    protected String type;
    protected String property;
    protected HashMap<String, String> netlist;
    protected HashMap<String, Float> propertyValues;

    /**
     * return ID of component
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * sets ID of component
     * @param ID component ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * gets type of component
     * @return component type
     */
    public String getType() {
        return type;
    }

    /**
     * sets type of component
     * @param type type of component
     */
    protected void setType(String type) {
        this.type = type;
    }

    /**
     * gets kind of property of component (in our case "resistance" or "m(l)"
     * @return property of component
     */
    public String getProperty() {
        return property;
    }

    /**
     * sets property of component
     * @param property property of component
     */
    protected void setProperty(String property) {
        this.property = property;
    }

    /**
     * gets netlist map of component
     * @return netlist of component
     */
    public HashMap<String, String> getNetlist() {
        return netlist;
    }

    /**
     * gets the property values (in our case "default", "min" and "max")
     * @return property values map
     */

    public HashMap<String, Float> getPropertyValues() {
        return this.propertyValues;
    }

    /**
     * Method that sets property values (in our case "default", "min" and "max" values of "resistance" and "m(l)"
     * @param pvd
     */
    public void setPropertyValues(PropertyValuesDTO pvd) {
        this.propertyValues = new HashMap<>();
        this.propertyValues.put("min", pvd.getMinValue());
        this.propertyValues.put("default", pvd.getDefaultValue());
        this.propertyValues.put("max", pvd.getMaxValue());

    }

    /**
     * sets netlist of component
     * @param obj netlist DTO
     */
    public abstract void setNetlist(Object obj);
}
