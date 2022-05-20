package mohannad.soliman;

import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Topology;
import mohannad.soliman.JSON.ReaderJSON;
import mohannad.soliman.JSON.WriterJSON;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * The class that the API calls as it contains the implementation of the required methods.
 * Contains static methods as it is assumed that an object of the Controller won't be needed only its methods.
 */
public class Controller
{
    /**
     * HashMap containing all topologies loaded into memory.
     * Used for quick access to certain topologies and ensures uniqueness.
     */
    private static HashMap<String, Topology> topologies = new HashMap<>();

    /**
     * Method where user enters path of topology file to be read
     * @param fileName path of input file
     * @return True if file exists with valid json format else False
     */
    public static boolean readJSON(String fileName){

        Topology topology = ReaderJSON.readTopology(fileName);
        if (topology == null) return false;
        topologies.put(topology.getID() ,topology);
        return true;
    }
    /**
     * Method where user chooses the ID of the topology in the memory to be written to disk
     * in savedTopologies.json file
     * @param topologyID ID of wanted topology
     * @return True if ID is for existing topology else False
     */
    public static boolean writeJSON(String topologyID){
        Topology top = topologies.get(topologyID);
        if (top == null) return false;
        return WriterJSON.writeTopology(top);
    }
    /**
     * Method that returns array of all currently held topologies in memory
     * @return Array of topologies in memory
     */
    public static Topology[] queryTopologies(){
        return topologies.values().toArray(new Topology[0]);
    }
    /**
     * Method that deletes the topology of the given ID
     * @param topologyID ID of wanted topology
     * @return True if topology exists else False
     */
    public static boolean deleteTopology(String topologyID){
        if(topologies.get(topologyID) == null) return false;
        topologies.remove(topologyID);
        return true;
    }

    /**
     * Method that returns array of all devices in a topology
     * @param topologyID ID of wanted topology
     * @return Array of components in the topology
     */
    public static Component[] queryDevices(String topologyID) {
        // if the topology doesn't exist
        Topology topology = topologies.get(topologyID);
        if (topology == null) return new Component[0];
        // if the topology exists
        return topology.getComponents();
    }
    /**
     * Method that returns array of components belonging to a certain topology having a component whose
     * netlist contains the required ID
     * @param topologyID ID of wanted topology
     * @param netlistNodeID ID of wanted netlist node
     * @return Array of components
     */
    public static Component[] queryDevicesWithNetlistNode(String topologyID, String netlistNodeID){
        // get components in the topology
        Component[] components = queryDevices(topologyID);
        ArrayList<Component> requiredComponentsList = new ArrayList<>();
        // if no components return empty array
        if(components.length == 0) return new Component[0];
        // get components that have netlistNodeID as a value
        for (Component component : components){
            HashMap<String, String> netlist = component.getNetlist();
            for (String key : netlist.keySet()){
                if (netlist.get(key).equals(netlistNodeID)){
                    requiredComponentsList.add(component);
                    break;
                }
            }
        }
        return requiredComponentsList.toArray(new Component[0]);
    }

}
