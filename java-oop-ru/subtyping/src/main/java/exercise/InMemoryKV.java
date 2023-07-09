package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;

    InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }

    public void set(String key, String value) {
        var data = new HashMap<String, String>(this.map);
        data.put(key, value);
        this.map = data;
    }

    public void unset(String key) {
        var data = new HashMap<String, String>(this.map);
        data.remove(key);
        this.map = data;
    }

    public String get(String key, String defaultValue) {
        var data = new HashMap<String, String>(this.map);
        if (data.containsKey(key)) {
            return data.get(key);
        } else  {
            return defaultValue;
        }
    }

    public Map<String, String> toMap() {
        return new HashMap<>(this.map);
    }
}
// END
