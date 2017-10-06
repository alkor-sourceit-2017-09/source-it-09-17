package interfaces;

import domain.Product;

import java.util.List;

public interface IConnection {
    public List<Product> getAllProducts();
    public void addProducts(Product product);
}
