package mohannad.soliman.Entities;

import mohannad.soliman.DTOs.Netlist.NmosNetlistDTO;

import java.util.HashMap;
/**
 * Subclass from Component class with the addition of setNetlist
 */
public class Nmos extends Component{
    public Nmos(){
        this.setType("nmos");
        this.setProperty("m(l)");
    }
    /**
     * Method that sets netlist map given a DTO object
     * @param obj
     */
    @Override
    public void setNetlist(Object obj) {
        NmosNetlistDTO nnd = (NmosNetlistDTO) obj;
        this.netlist = new HashMap<>();
        this.netlist.put("drain", nnd.getDrain());
        this.netlist.put("gate", nnd.getGate());
        this.netlist.put("source", nnd.getSource());
    }
}
