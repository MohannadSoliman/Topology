package mohannad.soliman.Entities;

/**
 * Topology CLass that contains the components and their connections
 */
public class Topology {
    private String ID;
    private Component[] components;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

}
