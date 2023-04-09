package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] array = sentence.split(" ");
        Map<String, Integer> map = new HashMap<>();
        if (sentence.length() > 0) {
            for (var word : array) {
                if (map.containsKey(word)) {
                    int newVal = (map.get(word)) + 1;
                    map.replace(word, newVal);
                } else {
                    map.put(word, 1);
                }
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() > 0) {
            String result = "{\n";
            for (Map.Entry<String, Integer> word : map.entrySet()) {
                result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
            }
            result = result + "}";
            return result;
        } else {
            return "{}";
        }
    }
}


//END
