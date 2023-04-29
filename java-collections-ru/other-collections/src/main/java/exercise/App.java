package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();
        Map<String, String> result = new LinkedHashMap<String, String>();

        for (String key: map1.keySet()) {
            set1.add(key);
        }

        for (String key: map2.keySet()) {
            set2.add(key);
        }

        Set<String> intersection = new HashSet<String>();
        intersection.addAll(set1);
        intersection.retainAll(set2);
        for (String key: intersection) {
            if (map1.get(key).equals(map2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }

        Set<String> difference1 = new HashSet<>();
        difference1.addAll(set1);
        difference1.removeAll(set2);
        for (String key: difference1) {
            result.put(key, "deleted");
        }

        Set<String> difference2 = new HashSet<>();
        difference2.addAll(set2);
        difference2.removeAll(set1);
        for (String key: difference2) {
            result.put(key, "added");
        }

        return result;
    }
}
//END
