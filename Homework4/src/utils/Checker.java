package utils;

import domain.Laptop;
import domain.Monitor;
import domain.Product;

public class Checker {
    private Checker() {
    }

    public static String getRealType(Product product) {
        if (product instanceof Laptop) {
            return "Laptop";
        }
        if (product instanceof Monitor) {
            return "Monitor";
        }
        return "Unknown";
    }
}
