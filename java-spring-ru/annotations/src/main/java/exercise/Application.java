package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method m : Address.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Inspect.class)) {
                var name = m.getName();
                var type = m.getReturnType().toString();
                if (type.contains(".")) {
                    var index = type.lastIndexOf(".") + 1;
                    type = type.substring(index);
                }
                System.out.println("Method " + name + " returns a value of type " + type + ".");
            }
        }

        // END
    }
}
