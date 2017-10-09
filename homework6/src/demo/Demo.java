package demo;

import domain.Product;
import domain.SearchDemonstration;
import exception.CustomException;
import impl.ConnectionImpl;
import utils.Helper;

import java.text.MessageFormat;

public class Demo {
    public static void main(String[] args) {
        try {
            new ConnectionImpl().addProducts(new Product());
        } catch (RuntimeException e) {
            System.out.println("1st exception: " + e.getMessage());
        }

        try {
            new ConnectionImpl().getAllProducts();
        } catch (RuntimeException e) {
            System.out.println("2nd exception: " + e.getMessage());
        }

        Helper.getDouble(null);
        Helper.getElemByIndex(new Object[0], 1);
        try {
            Helper.throwE();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        try {
            Helper.throwRT();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Helper.parseString("sd");

        SearchDemonstration sd = new SearchDemonstration(10);
        int findNum = 2;
        System.out.println(sd);
        System.out.println(MessageFormat.format("Is {0} contained in array: {1}", findNum,
                sd.contains(findNum) ? "yes" : "no"));
    }
}
