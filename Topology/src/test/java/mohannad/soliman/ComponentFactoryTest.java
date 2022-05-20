package mohannad.soliman;

import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Nmos;
import mohannad.soliman.Entities.Resistor;
import mohannad.soliman.Entities.Topology;
import mohannad.soliman.Factory.Component.ComponentFactory;
import mohannad.soliman.JSON.ReaderJSON;
import org.junit.Test;


import static org.junit.Assert.*;

public class ComponentFactoryTest {
    @Test
    public void CreateComponent_Resistor(){
        ComponentFactory cf = new ComponentFactory();
        Component c = cf.createComponent("resistor");
        assertTrue(c instanceof Resistor);
    }
    @Test
    public void CreateComponent_Nmos(){
        ComponentFactory cf = new ComponentFactory();
        Component c = cf.createComponent("nmos");
        assertTrue(c instanceof Nmos);
    }
    @Test
    public void CreateComponent_Null(){
        ComponentFactory cf = new ComponentFactory();
        Component c = cf.createComponent("abcd");
        assertNull(c);
    }
}
