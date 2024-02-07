package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository ar;

    @Autowired
    private AuthorMapper am;

    public List<AuthorDTO> getAll() {
        var authors = ar.findAll();
        return authors.stream()
                .map(am::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO data) {
        var author = am.map(data);
        ar.save(author);
        return am.map(author);
    }

    public AuthorDTO findById(Long id) {
        var author = ar.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return am.map(author);
    }

    public AuthorDTO update(AuthorUpdateDTO dto, Long id) {
        var author = ar.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        am.update(dto, author);
        ar.save(author);
        return am.map(author);
    }

    public void delete(Long id) {
        ar.deleteById(id);
    }
    // END
}
