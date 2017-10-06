package impl;

import domain.Product;
import exception.DBException;
import exception.DBExceptionRT;
import interfaces.IConnection;

import java.util.List;

public class ConnectionImpl implements IConnection {
    @Override
    public List<Product> getAllProducts() {
        try {
            throw new DBException("DB Exception");
        } catch (DBException e) {
            throw new DBExceptionRT("hiding checked exception", e);
        }
    }

    @Override
    public void addProducts(Product product) {
        throw new RuntimeException("RT Exception");
    }
}
