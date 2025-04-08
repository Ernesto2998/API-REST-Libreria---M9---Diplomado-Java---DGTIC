package mx.unam.dgtic.libreria_rest.controllers.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.libreria_rest.dtos.AutorDto;
import mx.unam.dgtic.libreria_rest.models.Autor;
import mx.unam.dgtic.libreria_rest.repositories.AutorRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.AutorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/autor")
public class AutorDtoRestController {

    @Autowired
    AutorDtoService autorDtoService;

    @GetMapping("/")
    public ResponseEntity<List<AutorDto>> getAllAutoresDto(){
        return ResponseEntity.ok(autorDtoService.findAllAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDto> getAutorDto(@PathVariable Integer id){
        return ResponseEntity.ok(autorDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<AutorDto> newAutorDto(@Valid @RequestBody AutorDto autorDto){
        return ResponseEntity.ok(autorDtoService.saveAutor(autorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> updateAutorDto(@Valid @PathVariable Integer id,
                                                   @RequestBody AutorDto autorDto){
        return ResponseEntity.ok(autorDtoService.updateAutor(id, autorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutorDto> deleteAutorDto(@PathVariable Integer id){
        return ResponseEntity.ok(autorDtoService.deleteAutor(id));
    }
}
