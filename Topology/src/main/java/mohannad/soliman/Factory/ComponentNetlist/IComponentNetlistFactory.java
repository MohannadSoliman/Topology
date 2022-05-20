package mohannad.soliman.Factory.ComponentNetlist;

import mohannad.soliman.DTOs.Netlist.INetlistDTO;
import org.json.JSONObject;

/**
 * Interface for Factory Design Pattern for creating a Component Netlist DTO
 */
public interface IComponentNetlistFactory {
    /**
     * Method that creates a Netlist DTO depending on the type of component and JSONObject
     * @param type type of property
     * @param arrayObject json object of property
     * @return INetListDTO : Marker interface for both ResistorNetlistDTO & NmosNetlistDTO
     */
    INetlistDTO createNetlistDTO(String type, JSONObject arrayObject);
}
