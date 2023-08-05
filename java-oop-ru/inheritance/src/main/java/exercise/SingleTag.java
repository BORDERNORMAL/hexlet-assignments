package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> atts) {
        super(name, atts);
    }

    @Override
    public String toString() {
        if (!this.getAtts().isEmpty()) {
            return "<" + this.getName() + " " + this.getAttsAsString() + ">";
        } else {
            return "<" + this.getName() + ">";
        }
    }
}
// END
