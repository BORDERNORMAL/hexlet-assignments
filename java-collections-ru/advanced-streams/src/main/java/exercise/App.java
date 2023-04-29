package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String variables) {
        String[] vars = variables.split("\n");

        String[] newvars = Arrays.stream(vars)
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.split(","))
                .flatMap(x -> Stream.of(x))
                .toArray(String[]::new);

        String[] ready = Arrays.stream(newvars)
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replace("X_FORWARDED_", ""))
                .toArray(String[]::new);

        String result = "";

        for (int i = 0; i < ready.length; i++) {
            if (i == (ready.length - 1)) {
                result = result + ready[i];
            } else {
                result = result + ready[i] + ",";
            }
        }

        return result;
    }
}
//END
