package exercise.dto.users;

// BEGIN
import java.util.List;

import exercise.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> users;
}
// END
