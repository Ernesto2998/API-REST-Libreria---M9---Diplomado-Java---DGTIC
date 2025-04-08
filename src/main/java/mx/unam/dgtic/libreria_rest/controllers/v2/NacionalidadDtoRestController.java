package mx.unam.dgtic.libreria_rest.controllers.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.libreria_rest.dtos.NacionalidadDto;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.NacionalidadDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/nacionalidad")
public class NacionalidadDtoRestController {

    @Autowired
    private NacionalidadDtoService nacionalidadDtoService;

    @GetMapping("/")
    public ResponseEntity<List<NacionalidadDto>> getAllNacionalidadesDto(){
        return ResponseEntity.ok(nacionalidadDtoService.findAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NacionalidadDto> getNacionalidadDto(@PathVariable Integer id){
        return ResponseEntity.ok(nacionalidadDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<NacionalidadDto> newNacionalidad(@Valid @RequestBody NacionalidadDto nacionalidadDto){
        return ResponseEntity.ok(nacionalidadDtoService.saveNacionalidad(nacionalidadDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NacionalidadDto> updateNacionalidadDto(@Valid @PathVariable Integer id, @RequestBody NacionalidadDto nacionalidadDto){
        return ResponseEntity.ok(nacionalidadDtoService.updateNacionalidad(id, nacionalidadDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NacionalidadDto> deleteNacionalidadDto(@PathVariable Integer id){
        return ResponseEntity.ok(nacionalidadDtoService.deleteNacionalidad(id));
    }
}
