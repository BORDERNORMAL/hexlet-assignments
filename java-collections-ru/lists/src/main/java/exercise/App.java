package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        char[] arr = letters.toCharArray();
        word = word.toLowerCase();
        boolean isScrabblable = true;
        List<Character> list = new ArrayList<>(arr);
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (list.contains(current)) {
                int index = list.indexOf(current);
                list.remove(index);
            } else {
                isScrabblable = false;
            }
        }
        return isScrabblable;
    }
}
//END
