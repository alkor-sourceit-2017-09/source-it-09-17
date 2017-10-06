import java.text.MessageFormat;
import java.util.*;

public class PersonList implements IPersonList {
    private int lastFilledId; //real filled id (i.e. real length of array)
    private int delta = 16;   //used for increase array

    private Person[] innerArr;

    public PersonList() {
        innerArr = new Person[delta];
        lastFilledId = -1;
    }

    public PersonList(Person[] arr) {
        this.innerArr = Arrays.copyOf(arr, arr.length);
        int halfLength = arr.length / 2;
        delta = halfLength > 16 ? halfLength : 16;
        lastFilledId = arr.length - 1;
    }

    @Override
    public int size() {
        return lastFilledId + 1;
    }

    @Override
    public boolean isEmpty() {
        return lastFilledId == -1;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if ((o instanceof Person)) {
            for (Object item : innerArr) {
                if (item != null && item.equals(o)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(innerArr).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(innerArr, lastFilledId + 1);
    }

    @Override
    public boolean add(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        if (lastFilledId >= innerArr.length - 1) {
            innerArr = Arrays.copyOf(innerArr, innerArr.length + delta);
        }
        innerArr[++lastFilledId] = person;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }
        Person[] firstArr = null;
        for (int i = 0; i < innerArr.length; i++) {
            Person item = innerArr[i];
            if (item != null && item.equals(o)) {
                firstArr = new Person[innerArr.length - 1];
                System.arraycopy(innerArr, 0, firstArr, 0, i);
                System.arraycopy(innerArr, i + 1, firstArr, i, innerArr.length - i - 1);
                lastFilledId--;
                innerArr = firstArr;
            }
        }
        return firstArr != null;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object item : c) {
            if (!(item instanceof Person)) {
                return false;
            }
        }

        int newSize;
        if (lastFilledId + c.size() > innerArr.length - 1) {
            newSize = c.size() + lastFilledId + 1;
        } else {
            newSize = innerArr.length;
        }
        Person[] newArr = new Person[newSize];

        System.arraycopy(innerArr, 0, newArr, 0, lastFilledId + 1);
        System.arraycopy(c.toArray(), 0, newArr, lastFilledId + 1, c.size());
        lastFilledId = lastFilledId + c.size();
        innerArr = newArr;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for (Object item : c) {
            if (!(item instanceof Person)) {
                return false;
            }
        }

        if (index > lastFilledId + 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int newSize = 0;
        if (lastFilledId + c.size() > innerArr.length - 1) {
            do {
                newSize += delta;
            } while (newSize < c.size() + lastFilledId + 1);
        } else {
            newSize = innerArr.length;
        }
        Person[] newArr = new Person[newSize];

        System.arraycopy(innerArr, 0, newArr, 0, index);
        System.arraycopy(c.toArray(), 0, newArr, index, c.size());
        System.arraycopy(innerArr, index, newArr, index + c.size(), lastFilledId + 1 - index);
        lastFilledId = lastFilledId + c.size();
        innerArr = newArr;
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(innerArr, null);
        lastFilledId = -1;
    }

    @Override
    public Object get(int index) {
        if (index > lastFilledId) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return innerArr[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (!(element instanceof Person) || index > lastFilledId) {
            return null;
        }
        innerArr[index] = (Person) element;
        return element;
    }

    @Override
    public void add(int index, Object element) {
        if (!(element instanceof Person)) {
            return;
        }
        int newSize = innerArr.length;
        if (lastFilledId >= innerArr.length - 1) {
            newSize += delta;
        }
        Person[] newArr = new Person[newSize];
        System.arraycopy(innerArr, 0, newArr, 0, index);
        newArr[index] = (Person) element;
        System.arraycopy(innerArr, index, newArr, index + 1, lastFilledId + 1 - index);
        innerArr = newArr;
        lastFilledId++;
    }

    @Override
    public Object remove(int index) {
        if (index > lastFilledId) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Person result = innerArr[index];
        Person[] newArr = new Person[innerArr.length];
        System.arraycopy(innerArr, 0, newArr, 0, index);
        System.arraycopy(innerArr, index + 1, newArr, index, lastFilledId + 1 - index);
        innerArr = newArr;
        lastFilledId--;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        if (!(o instanceof Person)) {
            return -1;
        }
        for (int i = 0; i < innerArr.length; i++) {
            if (innerArr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (!(o instanceof Person)) {
            return -1;
        }
        int lastIndex = -1;
        for (int i = 0; i < innerArr.length; i++) {
            if (innerArr[i].equals(o)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        return MessageFormat.format("Array: {0}\n\tReal size: {1}\n\tList size: {2}",
                Arrays.toString(innerArr), innerArr.length, this.size());
    }
}
