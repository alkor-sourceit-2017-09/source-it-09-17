package impl;

import interfaces.Smartable;

import java.util.*;

public class SmartableImpl implements Smartable {
	@Override
	public boolean isUnique(Map<String, String> map) {
		if (map == null) {
			throw new IllegalArgumentException("Map can't be null");
		}
		return map.values().size() == map.values().stream().distinct().count();
	}

	@Override
	public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
		if (map1 == null || map2 == null) {
			throw new IllegalArgumentException("Maps can't be null");
		}
		Map<String, Integer> result = new HashMap<>();
		for (String key: map1.keySet()) {
			if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
				result.put(key, map1.get(key));
			}
		}
		return result;
	}

	@Override
	public Set<String> removeEvenLength(Set<String> set) {
		Set<String> result = new LinkedHashSet<>();
		for (String value: set) {
			if (value == null || value.length() % 2 != 0) {
				result.add(value);
			}
		}
		return result;
	}
}
