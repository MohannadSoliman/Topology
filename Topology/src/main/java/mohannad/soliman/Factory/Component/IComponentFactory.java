package mohannad.soliman.Factory.Component;

import mohannad.soliman.Entities.Component;

/**
 * Interface for Factory Design Pattern for creating component objects based on the type
 */
public interface IComponentFactory {
    /**
     * Method that creates component type (in our case "resistor" or "nmos") based on input string
     * @param type type of component
     * @return Component
     */
    Component createComponent(String type);
}
