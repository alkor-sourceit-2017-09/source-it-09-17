package utils;

import domain.*;

public class PersonFactory extends AbstractFactory{
	@Override
	public Person getPerson(String type) {
		if (type == null) {
			throw new IllegalArgumentException("Type cannot be null");
		}
		if (type.equalsIgnoreCase("employee")) {
			return Employee.newBuilder().build();
		} else if (type.equalsIgnoreCase("customer")) {
			return new Customer();
		}
		throw new IllegalArgumentException("Couldn't instantiate object with type: " + type);
	}

	@Override
	public Product getProduct(String type) {
		return null;
	}
}
