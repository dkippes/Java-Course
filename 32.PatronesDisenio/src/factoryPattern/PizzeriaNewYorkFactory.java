package factoryPattern;

import factoryPattern.producto.PizzaNewYorkItaliana;
import factoryPattern.producto.PizzaNewYorkPeperoni;
import factoryPattern.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        // Se puede usar un ENUM para queso pepperoni etc
        return switch (tipo) {
            case "vegenariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPeperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}
