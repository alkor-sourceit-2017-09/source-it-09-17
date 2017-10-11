package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public interface LetterCounter {
	public static Map<Character, Integer> getLettersCount(String text) {
		if (text == null) {
			throw new IllegalArgumentException("Text should be present");
		}

		Map<Character, Integer> result = new TreeMap<>();
		text.chars().filter(Character::isLetter).forEach(i -> {
			char c = (char) i;
			if (result.containsKey(c)) {
				result.replace(c, result.get(c) + 1);
			} else {
				result.put(c, 1);
			}
		});
		return result;
	}
}
