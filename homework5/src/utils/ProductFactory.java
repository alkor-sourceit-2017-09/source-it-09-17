package utils;

import domain.Laptop;
import domain.Monitor;
import domain.Person;
import domain.Product;

public class ProductFactory extends AbstractFactory {
	@Override
	public Product getProduct(String type) {
		if (type == null) {
			throw new IllegalArgumentException("Type cannot be null");
		}
		if (type.equalsIgnoreCase("laptop")) {
			return new Laptop();
		} else if (type.equalsIgnoreCase("monitor")) {
			return new Monitor();
		}
		throw new IllegalArgumentException("Couldn't instantiate object with type: " + type);
	}

	@Override
	public Person getPerson(String type) {
		return null;
	}
}
