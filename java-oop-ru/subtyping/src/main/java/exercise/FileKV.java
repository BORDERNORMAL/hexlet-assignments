package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> map;
    private String path;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
        Utils.writeFile(path, Utils.serialize(this.map););
    }

    public void set(String key, String value) {
        var data = new HashMap<String, String>(this.map);
        data.put(key, value);
        this.map = data;
        Utils.writeFile(Utils.serialize(data), this.path);
    }

    public void unset(String key) {
        var data = new HashMap<String, String>(this.map);
        data.remove(key);
        this.map = data;
        Utils.writeFile(Utils.serialize(data), this.path);
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
