package mx.unam.dgtic.libreria_rest.controllers.v1;

import mx.unam.dgtic.libreria_rest.models.Autor;
import mx.unam.dgtic.libreria_rest.services.v1.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autor")
public class AutorRestController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/")
    public ResponseEntity<List<Autor>> getAllAutores(){
        return ResponseEntity.ok(autorService.findAllAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutore(@PathVariable Integer id){
        return ResponseEntity.ok(autorService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor){
        return ResponseEntity.ok(autorService.saveAutor(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id, @RequestBody Autor autor){
        return ResponseEntity.ok(autorService.updateAutor(id, autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> deleteAutor(@PathVariable Integer id){
        return ResponseEntity.ok(autorService.deleteAutor(id));
    }
}
