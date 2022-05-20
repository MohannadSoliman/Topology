package mohannad.soliman.DTOs.Property;


public class PropertyValuesDTO {
    private float minValue;
    private float defaultValue;
    private float maxValue;

    public PropertyValuesDTO(float minValue, float defaultValue, float maxValue) {
        this.minValue = minValue;
        this.defaultValue = defaultValue;
        this.maxValue = maxValue;
    }
    public PropertyValuesDTO() {

    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
}
