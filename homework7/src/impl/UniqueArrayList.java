package impl;

import java.util.ArrayList;
import java.util.Collection;

public class UniqueArrayList<T> extends ArrayList<T> {
    @Override
    public boolean add(T element) {
        return !this.contains(element) && super.add(element);
    }

    @Override
    public void add(int index, T element) {
        if (!this.contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
        for (T elem: c) {
            result = result && add(elem);
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean result = true;
        for (T elem: c) {
            boolean isContains = contains(elem);
            result = result && !isContains;
            if (!isContains) {
                add(index++, elem);
            }
        }
        return result;
    }
}
