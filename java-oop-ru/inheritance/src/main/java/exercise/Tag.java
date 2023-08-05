package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag{
    private String name;
    private Map<String, String> atts;

    public Tag(String name, Map<String, String> atts) {
        this.name = name;
        this.atts = atts;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAtts() {
        return atts;
    }

    public String getAttsAsString() {
        String result = atts.keySet().stream()
                .map(o -> o + "=\"" + atts.get(o) + "\"")
                .collect(Collectors.joining(" "));
        return result.trim();
    }

    public abstract String toString();
}
// END
