package demo;

import impl.SmartableImpl;
import interfaces.Smartable;
import utils.LetterCounter;

import java.text.MessageFormat;
import java.util.*;

public class Demo {
	public static void main(String[] args) {
		{
			final String text = "Lorem Ipsum is simply dummy text of the printing and typesetting " +
				"industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
				"when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
				" It has survived not only five centuries, but also the leap into electronic typesetting," +
				" remaining essentially unchanged. It was popularised in the 1960s with the release of" +
				" Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing" +
				" software like Aldus PageMaker including versions of Lorem Ipsum.";
			Map<Character, Integer> lMap = LetterCounter.getLettersCount(text);
			System.out.println("Letters count:");
			for (final Character key : lMap.keySet()) {
				System.out.println(MessageFormat.format("\t{0}: {1}", key, lMap.get(key)));
			}
			System.out.println();
		}

		Smartable smartable = new SmartableImpl();

		{
			System.out.println("Check unique values");

			Map<String, String> map = new LinkedHashMap<>();
			map.put("Вася", "Иванов");
			map.put("Петр", "Петров");
			map.put("Виктор", "Сидоров");
			map.put("Сергей", "Савельев");
			map.put("Вадим", "Викторов");
			System.out.println(MessageFormat.format("\tValues {0}{1} have duplicates",
				map.values(), smartable.isUnique(map) ? " don't" : ""));
			System.out.println();
		}

		{
			System.out.println("Intersect values");
			Map<String, Integer> map1 = new HashMap<>();
			map1.put("Janet", 87);
			map1.put("Logan", 62);
			map1.put("Whitaker", 46);
			map1.put("Alyssa", 100);
			map1.put("Stefanie", 80);
			map1.put("Jeff", 88);
			map1.put("Kim", 52);
			map1.put("Sylvia", 95);

			Map<String, Integer> map2 = new HashMap<>();
			map2.put("Logan", 62);
			map2.put("Kim", 52);
			map2.put("Whitaker", 52);
			map2.put("Jeff", 88);
			map2.put("Stefanie", 80);
			map2.put("Brian", 60);
			map2.put("Lisa", 83);
			map2.put("Sylvia", 87);
			System.out.println(MessageFormat.format("\tValues1: {0}\n\tValues2: {1}\n\tIntersect: {2}",
				map1, map2, smartable.intersect(map1, map2)));
			System.out.println();
		}

		{
			System.out.println("Remove even: ");
			Set<String> set = new LinkedHashSet<>();
			set.add("foo");
			set.add("buzz");
			set.add("bar");
			set.add("fork");
			set.add("bort");
			set.add("spoon");
			set.add("!");
			set.add("dude");
			System.out.println(MessageFormat.format("\tOriginal: {0}\n\tProcessed: {1}",
				set, smartable.removeEvenLength(set)));
		}
	}
}
