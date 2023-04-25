package exercise;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(o -> o.get("gender").equals("male"))
                .sorted(new Comparator<Map<String, String>>() {
                    @Override
                    public int compare(Map<String, String> o1, Map<String, String> o2) {
                        return -(LocalDate.parse(o2.get("birthday")).compareTo(LocalDate.parse(o1.get("birthday"))));
                    }
                })
                .map(o -> o.get("name"))
                .collect(Collectors.toList());
    }
}
// END
