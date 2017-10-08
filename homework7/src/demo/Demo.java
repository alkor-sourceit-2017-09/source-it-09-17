package demo;

import impl.ListChecker;
import impl.UniqueArrayList;
import impl.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Demo {
	public static void main(String[] args) {
		int size = 1_000_000;
		try {
			new ListChecker(size, ListChecker.ListType.ARRAYLIST).startTests();
			new ListChecker(size, ListChecker.ListType.LINKEDLIST).startTests();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		List<Integer> list = new UniqueArrayList<>();
		list.add(1);
		list.add(1);
		list.add(null);
		list.add(2);
		System.out.println(list);

		{
			Integer[] arr = {0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16};
			System.out.println(Utils.removeInRange(Arrays.asList(arr), 0, 5, 13));
		}

		{
			Integer[] arr1 = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
			Integer[] arr2 = {-5, 15, 2, -1, 7, 15, 36};
			System.out.println(Utils.countCommon(Arrays.asList(arr1), Arrays.asList(arr2)));
		}

		{
			Integer[] arr = {4, 7, 4, -1, 2, 4, 7, 2, 15, 15};
			System.out.println(Utils.maxOccurrences(Arrays.asList(arr)));
		}
	}
}
