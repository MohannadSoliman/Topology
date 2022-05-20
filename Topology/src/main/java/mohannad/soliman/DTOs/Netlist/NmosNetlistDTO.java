package mohannad.soliman.DTOs.Netlist;

public class NmosNetlistDTO implements INetlistDTO{
    private String drain;
    private String gate;
    private String source;

    public NmosNetlistDTO(String drain, String gate, String source) {
        this.drain = drain;
        this.gate = gate;
        this.source = source;
    }

    public NmosNetlistDTO() {

    }

    public String getDrain() {
        return drain;
    }

    public void setDrain(String drain) {
        this.drain = drain;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
