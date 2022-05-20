package mohannad.soliman.JSON;

import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Topology;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;


/**
 * Class used to write the saved topologies on disk
 */
public class WriterJSON {
    /**
     * Method that writes a topology that's stored in memory into the disk
     * @param topology
     * @return True if no errors occurred else False
     */
    public static boolean writeTopology(Topology topology){

        StringBuilder fileContents = null;
        try {
            fileContents = getFileContents("savedTopologies.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject topologyJSON = new JSONObject();
        StringBuilder topologyString = new StringBuilder();
        if (fileContents.length()==0){
            fileContents.append("[");
        }else{
            topologyString.append("\n,");
            fileContents.deleteCharAt(fileContents.length() - 1);
            fileContents = new StringBuilder(fileContents.substring(0, fileContents.length() - 1));
        }

        Component[] components = topology.getComponents();

        // set topology vars
        topologyJSON.put("id", topology.getID());
        JSONArray componentsArrayJSON = new JSONArray();

        for (Component component : components){
            JSONObject componentJSON = new JSONObject();
            JSONObject propertyJSON = new JSONObject();
            JSONObject netlistJSON = new JSONObject();

            componentJSON.put("type", component.getType());
            componentJSON.put("id", component.getID());

            // filling the property attribute ( resistor / m(l) )
            for (String key : component.getPropertyValues().keySet()) {
                propertyJSON.put(key, component.getPropertyValues().get(key));
            }

            // filling the netlist
            for (String key : component.getNetlist().keySet()){
                netlistJSON.put(key, component.getNetlist().get(key));
            }

            componentJSON.put(component.getProperty(), propertyJSON);
            componentJSON.put("netlist", netlistJSON);
            componentsArrayJSON.put(componentJSON);
        }
        topologyJSON.put("components", componentsArrayJSON);
        topologyString.append(topologyJSON);
        topologyString.append("]");
        fileContents.append(topologyString);
        try {
            writeFileContents(fileContents.toString(), "savedTopologies.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    /**
     * Method that returns a StringBuilder containing what's inside the save file
     * @param path
     * @return StringBuilder containing file contents
     * @throws IOException
     */
    private static StringBuilder getFileContents(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        reader.close();

        return stringBuilder;
    }

    /**
     * Method that writes the contents of a string in a given file
     * @param contents
     * @param path
     * @return True if no errors occurred else False
     * @throws IOException
     */
    private static boolean writeFileContents(String contents, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(contents);
        writer.close();

        return true;
    }
}
