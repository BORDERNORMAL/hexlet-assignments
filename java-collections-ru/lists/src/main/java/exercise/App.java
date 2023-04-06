package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        String[] chars = letters.split("");
        List<String> list = new ArrayList<>(Arrays.asList(chars));
        word = word.toLowerCase();
        String[] wordArr = word.split("");
        for (var letter : wordArr) {
            if (list.contains(letter)) {
                list.remove(letter);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
