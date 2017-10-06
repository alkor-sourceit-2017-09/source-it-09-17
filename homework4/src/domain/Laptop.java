package domain;

import java.math.BigInteger;
import java.util.Date;

public class Laptop extends Product {
    private static int categoryCount;
    private static Date lastChanged;

    static {
        categoryCount = 0;
        lastChanged = new Date();
    }

    enum Manufacturer {
        LENOVO, ACER, APPLE, ASUS
    }

    private String cpu;
    private double lcd;
    private int ram;
    private String hddType;
    private String os;

    public Laptop() {
    }

    public Laptop(String manufacturer, String model) {
        setModel(model);
        setManufacturer(manufacturer);
    }

    public Laptop(String manufacturer, String model, double price) {
        setModel(model);
        setManufacturer(manufacturer);
        setPrice(price);
    }

    public String getCpu() {
        return cpu;
    }

    public Laptop setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public double getLcd() {
        return lcd;
    }

    public Laptop setLcd(double lcd) {
        this.lcd = lcd;
        return this;
    }

    public int getRam() {
        return ram;
    }

    public Laptop setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public String getHddType() {
        return hddType;
    }

    public Laptop setHddType(String hddType) {
        this.hddType = hddType;
        return this;
    }

    public String getOs() {
        return os;
    }

    public Laptop setOs(String os) {
        this.os = os;
        return this;
    }

    public Laptop setCount(int count) {
        if (isCountValid(count)) {
            this.count = count;
        }
        return this;
    }

    public Laptop setManufacturer(String manufacturer) {
        this.manufacturer = isManufacturerValid(manufacturer) ? manufacturer : "Unknown";
        return this;
    }

    public Laptop setManufacturer() {
        this.manufacturer = "Unknown";
        return this;
    }

    public Laptop setModel(String model) {
        this.model = isModelValid(model) ? model : "Unknown";
        return this;
    }

    public Laptop setModel() {
        this.model = "Unknown";
        return this;
    }

    public Laptop setPrice(double price) {
        this.price = isPriceValid(price) ? price : null;
        return this;
    }

    @Override
    public Laptop setId(BigInteger id) {
        if (isIdValid(id)) {
            this.id = id;
        }
        return this;
    }

    private static boolean isCountValid(int count) {
        return count >= 0;
    }

    private static boolean isManufacturerValid(String manufacturer) {
        if (manufacturer != null) {
            manufacturer = manufacturer.toUpperCase();
        }
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
        Laptop laptop = (Laptop) o;
        return laptop.manufacturer.equals(manufacturer) && laptop.model.equals(model);
    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Laptop().setPrice(this.price)
                .setManufacturer(this.manufacturer)
                .setModel(this.model)
                .setId(this.id)
                .setCount(this.count)

                .setCpu(this.cpu)
                .setHddType(this.hddType)
                .setLcd(this.lcd)
                .setOs(this.os)
                .setRam(this.ram);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "os='" + os + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
