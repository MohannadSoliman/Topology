package mohannad.soliman;

import mohannad.soliman.Entities.Topology;
import mohannad.soliman.JSON.ReaderJSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReaderJSONTest {
    @Test
    public void readJSON_ObjectExist(){
        Topology topology = ReaderJSON.readTopology("topology.json");
        String actual = topology.getID();
        String expected = "top1";
        assertEquals(expected, actual);
    }
    @Test
    public void readJSON_ObjectNotExist(){
        Topology topology = ReaderJSON.readTopology("topologyxyz.json");
        assertNull(topology);
    }
    @Test
    public void readJSON_WrongFormat(){
        Topology topology = ReaderJSON.readTopology("topology3.json"); // contains invalid json
        assertNull(topology);
    }
}
