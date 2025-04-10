package mx.unam.dgtic.libreria_rest.controllers.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.libreria_rest.dtos.LibroDto;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.LibroDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/libro")
public class LibroDtoRestController {

    @Autowired
    LibroDtoService libroDtoService;

    @GetMapping("/")
    public ResponseEntity<List<LibroDto>> getAllLibrosDto(){
        return ResponseEntity.ok(libroDtoService.findAllLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibroDto(@PathVariable Integer id){
        return ResponseEntity.ok(libroDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<LibroDto> newLibroDto(@Valid @RequestBody LibroDto libroDto){
        return ResponseEntity.ok(libroDtoService.saveLibro(libroDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDto> updateLibroDto(@Valid @PathVariable Integer id,
                                                   @RequestBody LibroDto libroDto){
        return ResponseEntity.ok(libroDtoService.updateLibro(id, libroDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LibroDto> deleteLibroDto(@PathVariable Integer id){
        return ResponseEntity.ok(libroDtoService.deleteLibro(id));
    }
}
