package factoryPattern.ejemplo;

import factoryPattern.PizzaProducto;
import factoryPattern.PizzeriaCaliforniaFactory;
import factoryPattern.PizzeriaNewYorkFactory;
import factoryPattern.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Diego ordena la pizza " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("Juan ordena la pizza " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("Camila ordena la pizza " + pizza.getNombre());

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("John ordena la pizza " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
