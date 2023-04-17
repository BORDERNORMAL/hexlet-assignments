package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppTest {
    static List<Integer> numbers;
    @BeforeAll
    static void create() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> actual1 = App.take(numbers, 2);
        assertThat(actual1.size()).isEqualTo(2);
        assertThat(actual1.get(0)).isEqualTo(1);
        assertThat(actual1.get(1)).isEqualTo(2);

        List<Integer> actual2 = App.take(numbers, 6);
        assertThat(actual2.size()).isEqualTo(5);
        assertThat(actual2.get(4)).isEqualTo(5);

        // END
    }
}
