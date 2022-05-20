package mohannad.soliman.Entities;

/**
 * Topology CLass that contains the components and their connections
 */
public class Topology {

    private String ID;
    private Component[] components;

    /**
     * returns ID
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * sets ID
     * @param ID new ID to be used
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * gets components in topology
     * @return Array of Components
     */
    public Component[] getComponents() {
        return components;
    }

    /**
     * fill components of topology
     * @param components components to be added to topology
     */
    public void setComponents(Component[] components) {
        this.components = components;
    }

}
