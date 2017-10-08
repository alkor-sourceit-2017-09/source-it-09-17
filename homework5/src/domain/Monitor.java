package domain;

import java.math.BigInteger;
import java.util.Date;

public class Monitor extends Product {
    private static int categoryCount;
    private static Date lastAdded;

    static {
        categoryCount = 0;
        lastAdded = new Date();
    }

    enum Manufacturer {
        SAMSUNG, LG, APPLE, ASUS
    }

    private double lcd;
    private String resolution;
    private int frequency;
    private String color;
    private String screenType;

    public Monitor() {
    }

    public Monitor(String manufacturer, String model) {
        setModel(model);
        setManufacturer(manufacturer);
    }

    public Monitor(String manufacturer, String model, double price) {
        setModel(model);
        setManufacturer(manufacturer);
        setPrice(price);
    }

    public double getLcd() {
        return lcd;
    }

    public Monitor setLcd(double lcd) {
        this.lcd = lcd;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public Monitor setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public Monitor setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Monitor setColor(String color) {
        this.color = color;
        return this;
    }

    public String getScreenType() {
        return screenType;
    }

    public Monitor setScreenType(String screenType) {
        this.screenType = screenType;
        return this;
    }

    public Monitor setCount(int count) {
        if (isCountValid(count)) {
            count = count;
        }
        return this;
    }

    public Monitor setManufacturer(String manufacturer) {
        if (manufacturer != null) {
            manufacturer = manufacturer.toUpperCase();
        }
        this.manufacturer = isManufacturerValid(manufacturer) ? manufacturer : "Unknown";
        return this;
    }

    public Monitor setManufacturer() {
        this.manufacturer = "Unknown";
        return this;
    }

    public Monitor setModel(String model) {
        this.model = isModelValid(model) ? model : "Unknown";
        return this;
    }

    public Monitor setModel() {
        this.model = "Unknown";
        return this;
    }

    public Monitor setPrice(double price) {
        this.price = isPriceValid(price) ? price : null;
        return this;
    }

    @Override
    public Monitor setId(BigInteger id) {
        if (isIdValid(id)) {
            this.id = id;
        }
        return this;
    }

    private static boolean isCountValid(int count) {
        return count >= 0;
    }

    private static boolean isManufacturerValid(String manufacturer) {
        try {
            Manufacturer.valueOf(manufacturer);
            return true;
        } catch (IllegalArgumentException e) {
            // NOP
        }
        return false;
    }

    private static boolean isModelValid(String model) {
        return model != null;
    }

    private static boolean isPriceValid(double price) {
        return price >= 0;
    }

    private static boolean isIdValid(BigInteger id) {
        return id.intValue() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return monitor.manufacturer.equals(manufacturer) && monitor.model.equals(model);
    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Monitor().setPrice(this.price)
                .setManufacturer(this.manufacturer)
                .setModel(this.model)
                .setId(this.id)
                .setCount(this.count)

                .setFrequency(frequency)
                .setColor(this.color)
                .setLcd(this.lcd)
                .setResolution(this.resolution)
                .setScreenType(this.screenType);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
