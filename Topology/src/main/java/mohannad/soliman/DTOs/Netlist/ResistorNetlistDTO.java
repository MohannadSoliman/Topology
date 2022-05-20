package mohannad.soliman.DTOs.Netlist;

public class ResistorNetlistDTO implements INetlistDTO {
    private String t1;
    private String t2;

    public ResistorNetlistDTO(String t1, String t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public ResistorNetlistDTO() {

    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }
}