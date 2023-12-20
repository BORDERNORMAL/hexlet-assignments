package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Post show(@PathVariable Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @PutMapping(path = "/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post data) {
        if (postRepository.findById(id).isPresent()) {
            var post = postRepository.findById(id).get();
            post.setBody(data.getBody());
            post.setTitle(data.getTitle());
            return post;
        } else {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        if (postRepository.findById(id).isPresent()) {
            commentRepository.deleteByPostId(id);
            postRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Post with id" + id + " not found");
        }
    }
}
// END
