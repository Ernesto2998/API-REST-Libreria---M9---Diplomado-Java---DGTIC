package mx.unam.dgtic.libreria_rest.controllers.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.libreria_rest.dtos.EditorialDto;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.EditorialDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/editorial")
public class EditorialDtoController {

    @Autowired
    EditorialDtoService editorialDtoService;

    @GetMapping("/")
    public ResponseEntity<List<EditorialDto>> getAllEditorialesDto(){
        return ResponseEntity.ok(editorialDtoService.findAllEditoriales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialDto> getEditorialDto(@PathVariable Integer id){
        return ResponseEntity.ok(editorialDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<EditorialDto> newEditorialDto(@Valid @RequestBody EditorialDto editorialDto){
        return ResponseEntity.ok(editorialDtoService.saveEditorial(editorialDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialDto> updateEditorialDto(@Valid @PathVariable Integer id,
                                                           @RequestBody EditorialDto editorialDto){
        return ResponseEntity.ok(editorialDtoService.updateEditorial(id, editorialDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EditorialDto> deleteEditorialDto(@PathVariable Integer id){
        return ResponseEntity.ok(editorialDtoService.deleteEditorial(id));
    }
}
