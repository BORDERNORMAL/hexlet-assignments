package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository br;

    @Autowired
    private BookMapper bm;

    @Autowired
    private AuthorRepository ar;

    public List<BookDTO> getAll() {
        var books = br.findAll();
        var result = books.stream()
                .map(bm::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO data) {
        var book = bm.map(data);
        var authorId = data.getAuthorId();
        var author = ar.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
        var dto = bm.map(book);
        dto.setAuthorFirstName(author.getFirstName());
        dto.setAuthorLastName(author.getLastName());
        dto.setAuthorId(authorId);
        br.save(book);
        return dto;
    }

    public BookDTO update(BookUpdateDTO data, Long id) {
        var book = br.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        var author = ar.findById(data.getAuthorId().get())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Found"));
        bm.update(data, book);
        book.setAuthor(author);
        br.save(book);
        return bm.map(book);
    }

    public BookDTO findById(Long id) {
        var book = br.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        var dto = bm.map(book);
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        return dto;
    }

    public void delete(Long id) {
        br.deleteById(id);
    }
    // END
}
