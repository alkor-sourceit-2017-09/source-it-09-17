package demo;

import domain.Employee;
import utils.FactoryProducer;
import utils.ProductFactory;

import java.math.BigInteger;

public class Demo {
	public static void main(String[] args) {
		ProductFactory factory = new ProductFactory();
		System.out.println(factory.getProduct("Laptop").getClass());
		System.out.println(factory.getProduct("Monitor").getClass());

		System.out.println(FactoryProducer.getFactory(FactoryProducer.Type.PRODUCT).getProduct("monitor").getClass());
		System.out.println(FactoryProducer.getFactory(FactoryProducer.Type.PERSON).getPerson("employee").getClass());

		Employee employee = Employee.newBuilder()
			.withFein(123456789)
			.withId(new BigInteger("123"))
			.withName("Test")
			.withPhone("123456789")
			.build();
		System.out.println(employee);
	}
}
