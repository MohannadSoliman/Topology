package mohannad.soliman;

import mohannad.soliman.Entities.Component;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class ControllerTest {

    @Test
    public void readJSON_Exist(){
        assertTrue(Controller.readJSON("topology.json"));
    }
    @Test
    public void readJSON_NotExist(){
        assertFalse(Controller.readJSON("topology7.json"));
    }
    @Test
    public void writeJSON_Exist(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        assertTrue(Controller.writeJSON(Controller.queryTopologies()[0].getID()));
    }
    @Test
    public void writeJSON_NotExist(){
        assertFalse(Controller.writeJSON("wrong id"));
    }
    @Test
    public void queryTopologies_CheckID(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        String actual = Controller.queryTopologies()[0].getID();
        String expected = "top1";
        assertEquals(expected, actual);
    }
    @Test
    public void queryTopologies_CheckLength(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Integer actual = Controller.queryTopologies().length;
        Integer expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void deleteTopology_Exist(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        assertTrue(Controller.deleteTopology("top1"));
    }
    @Test
    public void deleteTopology_NotExist(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        assertFalse(Controller.deleteTopology("top15"));
    }
    @Test
    public void queryDevices_CheckID(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevices("top1");
        String expected = "res1";
        String actual = components[0].getID();
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevices_CheckSizeEmpty(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevices("top1afad");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevices_CheckSize(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevices("top1");
        Integer actual = components.length;
        Integer expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSize(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevicesWithNetlistNode("top1", "vin");
        Integer actual = components.length;
        Integer expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSizeEmpty_WrongTopology(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevicesWithNetlistNode("top1124", "vin");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSizeEmpty_WrongNetlist(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevicesWithNetlistNode("top1", "abcdefg");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckType(){
        Controller.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = Controller.queryDevicesWithNetlistNode("top1", "vin");
        String expected = components[0].getType();
        String actual = "nmos";
        assertEquals(expected, actual);
    }
}
