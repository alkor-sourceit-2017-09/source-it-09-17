package demo;

import domain.Laptop;
import domain.Monitor;
import domain.Product;
import utils.Checker;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Testing class type: " + Checker.getRealType(new Laptop()));

        List<Product> products = new ArrayList<>();
        products.add(new Monitor("Samsung", "971P").setColor("black"));
        products.add(new Laptop("APPLE", "ML122").setOs("MacOS 10.13"));
        for (Product product: products) {
            System.out.println(product);
        }

        Product monitor = new Monitor("SAMSUNG", "11");
        ((Monitor)monitor).setColor("black");
        System.out.println(monitor);

        Product laptop = new Laptop("SAMSUNG", "11");
        ((Laptop)laptop).setOs("Linux");
        System.out.println(laptop);
    }
}
