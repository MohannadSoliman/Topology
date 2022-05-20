package mohannad.soliman;
import static org.junit.Assert.*;

import org.junit.Test;
public class WriterJSONTest {

    @Test
    public void writeJSON_Exist(){
        API.readJSON("topology.json");
        assertTrue(API.writeJSON("top1"));
    }
    @Test
    public void writeJSON_NotExist(){
        API.readJSON("topology.json");
        assertFalse(API.writeJSON("top1xyz"));
    }
}
