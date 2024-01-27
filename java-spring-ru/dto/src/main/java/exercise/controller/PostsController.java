package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public List <PostDTO> index() {
        List <PostDTO> list =  new ArrayList<PostDTO>();
        for (var post : postRepository.findAll()) {
            var dto = new PostDTO();
            dto.setId(post.getId());
            dto.setBody(post.getBody());
            dto.setTitle(post.getTitle());;
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> show (@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found."));
        var dto = new PostDTO();
        List <CommentDTO> list = new ArrayList<>();
        for (var comment : commentRepository.findByPostId(post.getId())) {
            var cdto = new CommentDTO();
            cdto.setBody(comment.getBody());
            cdto.setId(comment.getId());
            list.add(cdto);
        }
        dto.setComments(list);
        dto.setTitle(post.getTitle());
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        return ResponseEntity.ok().body(dto);
    }
}
// END
