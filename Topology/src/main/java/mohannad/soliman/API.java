package mohannad.soliman;

import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Topology;

/**
 * The class that the user interacts with to get the functionality of the API.
 * Contains static methods as it is assumed that an object of the API won't be needed only its methods.
 */
public class API {
    /**
     * Method where user enters path of topology file to be read
     * @param fileName path of input file
     * @return True if file exists with valid json format else False
     */
    public static boolean readJSON(String fileName){
        return Controller.readJSON(fileName);
    }

    /**
     * Method where user chooses the ID of the topology in the memory to be written to disk
     * in savedTopologies.json file
     * @param topologyID ID of wanted topology
     * @return True if ID is for existing topology else False
     */
    public static boolean writeJSON(String topologyID){
        return Controller.writeJSON(topologyID);
    }

    /**
     * Method that returns array of all currently held topologies in memory
     * @return Array of topologies in memory
     */
    public static Topology[] queryTopologies(){
        return Controller.queryTopologies();
    }

    /**
     * Method that deletes the topology of the given ID
     * @param topologyID ID of wanted topology
     * @return True if topology exists else False
     */
    public static boolean deleteTopology(String topologyID){
        return Controller.deleteTopology(topologyID);
    }

    /**
     * Method that returns array of all devices in a topology
     * @param topologyID ID of wanted topology
     * @return Array of components in the topology
     */
    public static Component[] queryDevices(String topologyID){
        return Controller.queryDevices(topologyID);
    }
    /**
     * Method that returns array of components belonging to a certain topology having a component whose
     * netlist contains the required ID
     * @param topologyID ID of wanted topology
     * @param netlistNodeID ID of wanted netlist node
     * @return Array of components
     */
    public static Component[] queryDevicesWithNetlistNode(String topologyID, String netlistNodeID){
        return Controller.queryDevicesWithNetlistNode(topologyID, netlistNodeID);
    }
}
