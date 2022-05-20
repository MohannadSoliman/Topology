package mohannad.soliman.DTOs.Netlist;

/**
 * Concrete Class for Marker Interace
 */
public class NmosNetlistDTO implements INetlistDTO{
    private String drain;
    private String gate;
    private String source;

    /**
     * Constructor
     * @param drain drain of nmos
     * @param gate gate of nmos
     * @param source source of nmos
     */
    public NmosNetlistDTO(String drain, String gate, String source) {
        this.drain = drain;
        this.gate = gate;
        this.source = source;
    }

    /**
     * empty constructor
     */
    public NmosNetlistDTO() {

    }

    /**
     * get drain value of netlist
     * @return drain value
     */
    public String getDrain() {
        return drain;
    }

    /**
     * set the drain value of netlist
     * @param drain the value to be used for drain in netlist
     */
    public void setDrain(String drain) {
        this.drain = drain;
    }

    /**
     * get the gate value of netlist
     * @return gate value
     */
    public String getGate() {
        return gate;
    }

    /**
     * set the gate value of netlist
     * @param gate value to be used for gate value
     */
    public void setGate(String gate) {
        this.gate = gate;
    }

    /**
     * get the source value of netlist
     * @return source value in netlist
     */
    public String getSource() {
        return source;
    }

    /**
     * set the value of source in netlist
     * @param source the value to be used in netlist source
     */
    public void setSource(String source) {
        this.source = source;
    }
}
