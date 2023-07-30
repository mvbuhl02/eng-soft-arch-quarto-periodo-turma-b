package Sandro_Matheus_Ramos.calculator_console.src;

import Sandro_Matheus_Ramos.calculator_console.src.service.CalculatorSerivce;
import Sandro_Matheus_Ramos.calculator_console.src.service.MenuService;

public class App {
    
    public static void main(String[] args) {
        var menu = new MenuService();
        var calculartor = new CalculatorSerivce();

        menu.showMenu();
    }

}
