package domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchDemonstration {
    private int[] arr;

    public SearchDemonstration(int count) {
        arr = new int[count];
        IntStream.range(0, count).forEach(idx -> arr[idx] = (int) (Math.random() * count));
        Arrays.sort(arr);
    }

    private int findNum(int num, int fromIndex, int toIndex) {
        int testIndex = (fromIndex + toIndex) / 2;
        if (arr[testIndex] == num) {
            return testIndex;
        } else if (fromIndex > toIndex) {
            return -1;
        } else {
            fromIndex = arr[testIndex] < num ? testIndex + 1: fromIndex;
            toIndex = arr[testIndex] < num ? toIndex: testIndex - 1;
            return findNum(num, fromIndex, toIndex);
        }
    }

    public boolean contains(int number) {
        return findNum(number, 0, arr.length - 1) != -1;
    }

    @Override
    public String toString() {
        return "SearchDemonstration{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
