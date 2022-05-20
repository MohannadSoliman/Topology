package mohannad.soliman.Factory.ComponentNetlist;

import mohannad.soliman.DTOs.Netlist.INetlistDTO;
import mohannad.soliman.DTOs.Netlist.NmosNetlistDTO;
import mohannad.soliman.DTOs.Netlist.ResistorNetlistDTO;
import org.json.JSONObject;

/**
 * Concrete class for Factory Design Pattern to create Netlist DTO object based on component
 * type and JSONObject contents
 */
public class ComponentNetlistFactory implements IComponentNetlistFactory{
    /**
     * Method that creates a Netlist DTO depending on the type of component and JSONObject
     * @param type
     * @param arrayObject
     * @return INetListDTO : Marker interface for both ResistorNetlistDTO & NmosNetlistDTO
     */
    @Override
    public INetlistDTO createNetlistDTO(String type, JSONObject arrayObject) {
        JSONObject netlistObject = arrayObject.getJSONObject("netlist");

        if (type.equalsIgnoreCase("resistor")){
            ResistorNetlistDTO rnd = new ResistorNetlistDTO();

            rnd.setT1(netlistObject.getString("t1"));
            rnd.setT2(netlistObject.getString("t2"));

            return rnd;
        }
        if (type.equalsIgnoreCase("nmos")){
            NmosNetlistDTO nnd = new NmosNetlistDTO();

            nnd.setDrain(netlistObject.getString("drain"));
            nnd.setGate(netlistObject.getString("gate"));
            nnd.setSource(netlistObject.getString("source"));

            return nnd;
        }
        return null;
    }
}
