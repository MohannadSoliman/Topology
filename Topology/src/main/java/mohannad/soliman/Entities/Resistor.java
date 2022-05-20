package mohannad.soliman.Entities;

import mohannad.soliman.DTOs.Netlist.ResistorNetlistDTO;

import java.util.HashMap;

/**
 * Subclass from Component class with the addition of setNetlist
 */
public class Resistor extends Component{
    /**
     * Constructor
     */
    public Resistor(){
            this.setType("resistor");
            this.setProperty("resistance");

    }

    /**
     * Method that sets netlist map given a DTO object
     * @param obj netlist node object to be used to fill variables
     */
    @Override
    public void setNetlist(Object obj) {
        ResistorNetlistDTO rnd = (ResistorNetlistDTO) obj;
        this.netlist = new HashMap<>();
        this.netlist.put("t1", rnd.getT1());
        this.netlist.put("t2", rnd.getT2());
    }
}
