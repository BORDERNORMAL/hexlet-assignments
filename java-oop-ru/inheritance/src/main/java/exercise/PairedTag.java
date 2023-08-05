package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> atts, String body, List<Tag> children) {
        super(name, atts);
        this.body = body;
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public String getChildrenAsString() {
        return children.stream()
                .map(o -> o.toString())
                .collect(Collectors.joining(""));
    }

    @Override
    public String toString() {
        if(!this.getAtts().isEmpty()) {
            return "<" + this.getName() + " " + this.getAttsAsString() + ">" + getChildrenAsString() + this.getBody() + "</" + this.getName() + ">";
        } else {
            return "<" + this.getName() + ">" + this.getBody() + "</" + this.getName() + ">";
        }
    }
}
// END
