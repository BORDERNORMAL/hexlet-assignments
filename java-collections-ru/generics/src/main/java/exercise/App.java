package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static <T> ArrayList findWhere(List<Map <T,T>> list, Map<T, T> map) {
        ArrayList<Map <T, T>> result = new ArrayList<>();

        for (var book : list) {
            int needed = map.size();
            int count = 0;
            for (Map.Entry <T, T> neededData : map.entrySet()) {
                if (book.containsValue(neededData.getValue())) {
                    count++;
                }
            }
            if (count == needed) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
