package impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListChecker {
    public enum ListType {
        ARRAYLIST, LINKEDLIST
    }

    private final int INITIAL_SIZE;
    private List<Integer> list;
    private ListType listType;

    private static int getNewValue() {
        return ((int) (Math.random() * 100));
    }

    private void init() {
        list = listType == ListType.ARRAYLIST ? new ArrayList<>(INITIAL_SIZE) : new LinkedList<>();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            list.add(getNewValue());
        }
    }

    public ListChecker(int initialSize, ListType listType) throws IllegalArgumentException {
        this.INITIAL_SIZE = initialSize;
        this.listType = listType;
        if (listType == null) {
            throw new IllegalArgumentException("listType cannot be null");
        }
        init();
    }

    private void removeFields() {
        int startIndex = INITIAL_SIZE / 2;
        int endIndex = startIndex + 1000;
        for (int i = startIndex; i < endIndex; i++) {
            list.remove(i);
        }
    }

    private void addFieldsToBegin() {
        if (listType == ListType.ARRAYLIST) {
            addFieldsToBegin((ArrayList<Integer>) list);
        } else {
            addFieldsToBegin((LinkedList<Integer>) list);
        }
    }

    private void addFieldsToBegin(LinkedList<Integer> list) {
        for (int i = 0; i < 1000; i++) {
            list.addFirst(getNewValue());
        }
    }

    private void addFieldsToBegin(ArrayList<Integer> list) {
        for (int i = 0; i < 1000; i++) {
            list.add(0, getNewValue());
        }
    }

    private void printElems() {
        int startIndex = INITIAL_SIZE / 2;
        int endIndex = startIndex + 10;
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public void startTests() {
        System.out.println(MessageFormat.format("Time affected to process {0}: ", listType));
        long timeStart = System.currentTimeMillis();
        removeFields();
        System.out.println("\tRemove: " + (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        addFieldsToBegin();
        System.out.println("\tAdding: " + (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        printElems();
        System.out.println("\tPrinting: " + (System.currentTimeMillis() - timeStart));
    }
}
