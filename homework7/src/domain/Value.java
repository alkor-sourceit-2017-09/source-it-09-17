package domain;

public class Value implements Comparable<Value> {
    private int num;
    private int occurence;

    public Value(int num) {
        this.num = num;
        occurence = 1;
    }

    public int getOccurence() {
        return occurence;
    }

    public void incrementOccurence() {
        this.occurence++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return num == value.num;
    }

    @Override
    public int hashCode() {
        return num;
    }

    @Override
    public int compareTo(Value o) {
        if (o == null) {
            return -1;
        }
        return o.occurence - occurence;
    }
}
