package mohannad.soliman.DTOs.Netlist;

/**
 * Concrete Class of Marker Interface
 */
public class ResistorNetlistDTO implements INetlistDTO {
    private String t1;
    private String t2;

    /**
     * Constructor
     * @param t1 first terminal
     * @param t2 second terminal
     */
    public ResistorNetlistDTO(String t1, String t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * empty constructor
     */
    public ResistorNetlistDTO() {

    }

    /**
     * get first terminal value
     * @return first terminal value
     */
    public String getT1() {
        return t1;
    }

    /**
     * sets the value of first terminal
     * @param t1 first terminal value
     */
    public void setT1(String t1) {
        this.t1 = t1;
    }

    /**
     * gets value of second terminal
     * @return value of second terminal
     */
    public String getT2() {
        return t2;
    }

    /**
     * sets the value of the second terminal
     * @param t2 value of the second terminal
     */
    public void setT2(String t2) {
        this.t2 = t2;
    }
}
