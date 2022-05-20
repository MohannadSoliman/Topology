package mohannad.soliman;

import mohannad.soliman.DTOs.Netlist.INetlistDTO;
import mohannad.soliman.DTOs.Netlist.NmosNetlistDTO;
import mohannad.soliman.DTOs.Netlist.ResistorNetlistDTO;
import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Nmos;
import mohannad.soliman.Entities.Resistor;
import mohannad.soliman.Factory.Component.ComponentFactory;
import mohannad.soliman.Factory.ComponentNetlist.ComponentNetlistFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ComponentNetlistFactoryTest {
    @Test
    public void CreateComponentNetlist_Resistor(){
        ComponentNetlistFactory cnf = new ComponentNetlistFactory();
        JSONObject arrayObject = new JSONObject();
        JSONObject netlistObject = new JSONObject();
        netlistObject.put("t1", "res_t1");
        netlistObject.put("t2", "res_t2");
        arrayObject.put("netlist", netlistObject);
        INetlistDTO ndto = cnf.createNetlistDTO("resistor", arrayObject);
        assertTrue(ndto instanceof ResistorNetlistDTO);
    }
    @Test
    public void CreateComponentNetlist_Nmos(){
        ComponentNetlistFactory cnf = new ComponentNetlistFactory();
        JSONObject arrayObject = new JSONObject();
        JSONObject netlistObject = new JSONObject();
        netlistObject.put("drain", "nmos_drain");
        netlistObject.put("gate", "nmos_gate");
        netlistObject.put("source", "nmos_source");

        arrayObject.put("netlist", netlistObject);
        INetlistDTO ndto = cnf.createNetlistDTO("nmos", arrayObject);
        assertTrue(ndto instanceof NmosNetlistDTO);
    }
    @Test
    public void CreateComponentNetlist_Null(){
        ComponentNetlistFactory cnf = new ComponentNetlistFactory();
        JSONObject arrayObject = new JSONObject();
        JSONObject netlistObject = new JSONObject();
        netlistObject.put("t1", "res_t1");
        netlistObject.put("t2", "res_t2");
        arrayObject.put("netlist", netlistObject);
        INetlistDTO ndto = cnf.createNetlistDTO("abcd", arrayObject);
        assertNull(ndto);
    }
}
