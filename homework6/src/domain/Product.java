package domain;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String model;
    private String manufacturer;
    private BigDecimal price;
    private long count;

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Product setModel(String model) {
        this.model = model;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public long getCount() {
        return count;
    }

    public Product setCount(long count) {
        this.count = count;
        return this;
    }
}
