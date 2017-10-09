package utils;

public class FactoryProducer {
	public static AbstractFactory getFactory(Type type) {
		if (type == null) {
			throw new IllegalArgumentException("Couldn't get factory with null type");
		}

		if (type == Type.PERSON) {
			return new PersonFactory();
		} else if (type == Type.PRODUCT) {
			return new ProductFactory();
		}

		return null;
	}

	public static enum Type {
		PERSON, PRODUCT
	}
}
