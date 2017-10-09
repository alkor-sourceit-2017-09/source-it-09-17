package utils;

import domain.Person;
import domain.Product;

public abstract class AbstractFactory {
	public abstract Product getProduct(String type);
	public abstract Person getPerson(String type);
}
