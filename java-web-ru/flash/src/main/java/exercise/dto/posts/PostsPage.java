package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import exercise.dto.BasePage;

// BEGIN
@Getter
@AllArgsConstructor
public class PostsPage{
    private List<Post> posts;
}
// END
