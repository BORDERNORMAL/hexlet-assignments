package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String variables) {
        String[] vars = variables.split("\n");

        return Arrays.stream(vars)
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.split(","))
                .flatMap(x -> Stream.of(x))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
