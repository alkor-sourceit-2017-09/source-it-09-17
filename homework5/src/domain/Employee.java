package domain;

import java.math.BigInteger;

public class Employee extends Person {
	private BigInteger id;
	private long fein;
	private String name;
	private String phone;

	private Employee() {}

	public static Builder newBuilder() {
		return new Employee().new Builder();
	}

	public class Builder {
		private Builder() {}

		public Builder withId(BigInteger id) {
			Employee.this.id = id;
			return this;
		}

		public Builder withFein(long fein) {
			Employee.this.fein = fein;
			return this;
		}

		public Builder withName(String name) {
			Employee.this.name = name;
			return this;
		}

		public Builder withPhone(String phone) {
			Employee.this.phone = phone;
			return this;
		}

		public Employee build() {
			return Employee.this;
		}
	}

	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", fein=" + fein +
			", name='" + name + '\'' +
			", phone='" + phone + '\'' +
			'}';
	}
}
