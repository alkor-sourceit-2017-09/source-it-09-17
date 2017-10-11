package interfaces;

import java.util.Map;
import java.util.Set;

public interface Smartable {
	public boolean isUnique(Map<String, String> map);
	public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2);
	public Set<String> removeEvenLength(Set<String> set);
}
