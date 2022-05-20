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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    protected void setProperty(String property) {
        this.property = property;
    }

    public HashMap<String, String> getNetlist() {
        return netlist;
    }


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

    public abstract void setNetlist(Object obj);
}
