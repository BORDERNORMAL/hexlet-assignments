package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        var map = data.toMap();
        for (var key : map.keySet()) {
            data.set(map.get(key), key);
            data.unset(key);
        }
        data = new InMemoryKV(map);
    }
}
// END
