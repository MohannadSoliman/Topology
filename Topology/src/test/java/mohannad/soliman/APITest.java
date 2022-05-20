package mohannad.soliman;

import static org.junit.Assert.*;

import mohannad.soliman.Entities.Component;
import org.junit.Test;

/**
 * Unit tests for API.
 */
public class APITest
{

    @Test
    public void readJSON_Exist(){
        assertTrue(API.readJSON("topology.json"));
    }
    @Test
    public void readJSON_NotExist(){
        assertFalse(API.readJSON("topology7.json"));
    }
    @Test
    public void writeJSON_Exist(){
        API.readJSON("topology.json"); // place item in topologies data structure
        assertTrue(API.writeJSON(API.queryTopologies()[0].getID()));
    }
    @Test
    public void writeJSON_NotExist(){
        assertFalse(API.writeJSON("wrong id"));
    }
    @Test
    public void queryTopologies_CheckID(){
        API.readJSON("topology.json"); // place item in topologies data structure
        String actual = API.queryTopologies()[0].getID();
        String expected = "top1";
        assertEquals(expected, actual);
    }
    @Test
    public void queryTopologies_CheckLength(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Integer actual = API.queryTopologies().length;
        Integer expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void deleteTopology_Exist(){
        API.readJSON("topology.json"); // place item in topologies data structure
        assertTrue(API.deleteTopology("top1"));
    }
    @Test
    public void deleteTopology_NotExist(){
        API.readJSON("topology.json"); // place item in topologies data structure
        assertFalse(API.deleteTopology("top15"));
    }
    @Test
    public void queryDevices_CheckID(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevices("top1");
        String expected = "res1";
        String actual = components[0].getID();
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevices_CheckSizeEmpty(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevices("top1afad");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevices_CheckSize(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevices("top1");
        Integer actual = components.length;
        Integer expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSize(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevicesWithNetlistNode("top1", "vin");
        Integer actual = components.length;
        Integer expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSizeEmpty_WrongTopology(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevicesWithNetlistNode("top1124", "vin");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckSizeEmpty_WrongNetlist(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevicesWithNetlistNode("top1", "abcdefg");
        Integer actual = components.length;
        Integer expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void queryDevicesWithNetlistNode_CheckType(){
        API.readJSON("topology.json"); // place item in topologies data structure
        Component[] components = API.queryDevicesWithNetlistNode("top1", "vin");
        String expected = components[0].getType();
        String actual = "nmos";
        assertEquals(expected, actual);
    }
}
