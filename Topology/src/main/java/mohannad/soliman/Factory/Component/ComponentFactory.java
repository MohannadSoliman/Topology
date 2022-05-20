package mohannad.soliman.Factory.Component;

import mohannad.soliman.Entities.Component;
import mohannad.soliman.Entities.Nmos;
import mohannad.soliman.Entities.Resistor;

/**
 * Concrete class for Factory Design Pattern for creating component object
 */
public class ComponentFactory implements IComponentFactory{
    /**
     * Method that creates component type (in our case "resistor" or "nmos") based on input string
     * @param type
     * @return Component
     */
    @Override
    public Component createComponent(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("resistor")){
            return new Resistor();
        }
        if (type.equalsIgnoreCase("nmos")){
            return new Nmos();
        }
        return null;
    }
}
