package domain;

import java.math.BigInteger;

public abstract class Product {
    protected BigInteger id;
    protected String model;
    protected String manufacturer;
    protected Double price;
    protected int count;

    public Product setId(BigInteger id) {
        this.id = id;
        return this;
    }
}
