package mohannad.soliman.JSON;

import mohannad.soliman.DTOs.Netlist.INetlistDTO;
import mohannad.soliman.DTOs.Property.PropertyValuesDTO;
import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Topology;
import mohannad.soliman.Factory.Component.ComponentFactory;
import mohannad.soliman.Factory.ComponentNetlist.ComponentNetlistFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Class used for reading JSON files to be converted to Topology
 */
public class ReaderJSON {
    /**
     * Method that reads json file stored in given path
     * it converts the contents into a Topology object
     * @param filePath path of input file
     * @return Topology object if file exists and file format is correct else Null
     */
    public static Topology readTopology(String filePath){

        File file = new File(filePath);
        if (!file.exists()) return null;

        ComponentFactory cf = new ComponentFactory();
        ComponentNetlistFactory cnf = new ComponentNetlistFactory();

        // topology.json
        Topology topology = new Topology();

        // initializing file reading
        InputStream is = setupInputStream(filePath);

        // reading file contents
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object;
        try{
            object = new JSONObject(tokener);
        }catch(Exception e){
            return null;
        }

        // setting topology id
        topology.setID(object.getString("id"));
        ArrayList<Component> components = new ArrayList<>();

        // parse all components to create their objects
        JSONArray componentsJSON = object.getJSONArray("components");
        for (int i=0; i<componentsJSON.length(); i++){
            JSONObject componentElement = componentsJSON.getJSONObject(i);
            String type = componentElement.getString("type");

            // using the factory to get component (resistor or nmos)
            Component component = cf.createComponent(type);
            component.setID(componentElement.getString("id"));

            // get the property
            PropertyValuesDTO pvd = setupPropertyValues(type, componentElement);

            // using the factory to get component netlist object
            INetlistDTO dto = cnf.createNetlistDTO(type, componentElement);

            // inserting values inside component
            component.setPropertyValues(pvd);
            component.setNetlist(dto);

            components.add(component);
        }
        topology.setComponents(components.toArray(new Component[0]));

        return topology;
    }

    /**
     * Method that reads json file
     * @param filePath path of input file
     * @return InputStream of the json file
     */
    private static InputStream setupInputStream(String filePath){
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + filePath);
        }
        return is;
    }

    /**
     * Method that returns a PropertyValuesDTO depending on the component type and the contents of the
     * JSONObject (in our case whether it was "resistance" or "m(l)"
     * @param type property type (in our case "resistance" or "m(l)")
     * @param componentElement json object of property
     * @return PropertyValuesDTO
     */
    private static PropertyValuesDTO setupPropertyValues(String type, JSONObject componentElement){
        JSONObject propertyObject = null;
        PropertyValuesDTO pvd = new PropertyValuesDTO();
        if (type.equalsIgnoreCase("resistor")){
            propertyObject = componentElement.getJSONObject("resistance");
        }
        if (type.equalsIgnoreCase("nmos")){
            propertyObject = componentElement.getJSONObject("m(l)");
        }
        pvd.setMinValue(propertyObject.getFloat("min"));
        pvd.setDefaultValue(propertyObject.getFloat("default"));
        pvd.setMaxValue(propertyObject.getFloat("max"));
        return pvd;
    }
}
