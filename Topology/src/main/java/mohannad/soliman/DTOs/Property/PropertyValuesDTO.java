package mohannad.soliman.DTOs.Property;


public class PropertyValuesDTO {
    private float minValue;
    private float defaultValue;
    private float maxValue;

    /**
     * Constructor
     * @param minValue min value of property
     * @param defaultValue default value of property
     * @param maxValue max value of property
     */
    public PropertyValuesDTO(float minValue, float defaultValue, float maxValue) {
        this.minValue = minValue;
        this.defaultValue = defaultValue;
        this.maxValue = maxValue;
    }

    /**
     * Empty constructor
     */
    public PropertyValuesDTO() {

    }

    /**
     * gets min value
     * @return min value of property
     */
    public float getMinValue() {
        return minValue;
    }

    /**
     * sets min value
     * @param minValue min value
     */
    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    /**
     * gets default value
     * @return default value of property
     */
    public float getDefaultValue() {
        return defaultValue;
    }

    /**
     * sets the default value in property
     * @param defaultValue default value to be used
     */
    public void setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * gets max value of property
     * @return max value of property
     */
    public float getMaxValue() {
        return maxValue;
    }

    /**
     * sets max value of property
     * @param maxValue max value of property
     */
    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
}
