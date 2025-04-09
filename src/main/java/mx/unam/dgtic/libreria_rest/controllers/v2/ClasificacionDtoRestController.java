package mx.unam.dgtic.libreria_rest.controllers.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.libreria_rest.dtos.ClasificacionDto;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.ClasificacionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/clasi")
public class ClasificacionDtoRestController {

    @Autowired
    ClasificacionDtoService clasificacionDtoService;

    @GetMapping("/")
    public ResponseEntity<List<ClasificacionDto>> getAllClasificacionesDto(){
        return ResponseEntity.ok(clasificacionDtoService.findAllClasificaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasificacionDto> getClasificacionDto(@PathVariable Integer id){
        return ResponseEntity.ok(clasificacionDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<ClasificacionDto> newClasificacionDto(@Valid @RequestBody ClasificacionDto clasificacionDto){
        return ResponseEntity.ok(clasificacionDtoService.saveClasificacion(clasificacionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasificacionDto> updateClasificacionDto(@Valid @PathVariable Integer id,
                                                                   @RequestBody ClasificacionDto clasificacionDto){
        return ResponseEntity.ok(clasificacionDtoService.updateClasificacion(id, clasificacionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClasificacionDto> deleteClasificacionDto(@PathVariable Integer id){
        return ResponseEntity.ok(clasificacionDtoService.deleteClasificacion(id));
    }
}
