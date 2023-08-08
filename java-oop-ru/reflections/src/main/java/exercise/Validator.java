package exercise;

import exercise.demo.RandomNumber;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> list = new ArrayList<>();
        for (Field field: address.getClass().getDeclaredFields()) {
            Annotation x = field.getAnnotation(NotNull.class);
            if (x != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        list.add(field.getName());
                    }
               } catch (Exception e) {
               }
            }
        }
        return list;
    }
}
// END
