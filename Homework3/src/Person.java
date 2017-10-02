public class Person {
    private String name;

    public Person(String name) {
        this.name = name != null ? name : "Unknown";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Person && ((Person) obj).name.equals(this.name));
    }

    @Override
    public String toString() {
        return this.name;
    }
}
