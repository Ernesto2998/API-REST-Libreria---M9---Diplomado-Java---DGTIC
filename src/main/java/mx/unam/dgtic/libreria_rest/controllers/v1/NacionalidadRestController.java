package mx.unam.dgtic.libreria_rest.controllers.v1;

import mx.unam.dgtic.libreria_rest.models.Nacionalidad;
import mx.unam.dgtic.libreria_rest.services.v1.interfaces.NacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nacionalidad")
public class NacionalidadRestController {

    @Autowired
    private NacionalidadService nacionalidadService;

    @GetMapping("/")
    public ResponseEntity<List<Nacionalidad>> getAllNacionalidades(){
        return ResponseEntity.ok(nacionalidadService.findAllNacionalidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidad> getNacionalidad(@PathVariable Integer id){
        return ResponseEntity.ok(nacionalidadService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Nacionalidad> createNacionalidad(@RequestBody Nacionalidad nacionalidad){
        return ResponseEntity.ok(nacionalidadService.saveNacionalidad(nacionalidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nacionalidad> updateNacionalidad(@PathVariable Integer id, @RequestBody Nacionalidad nacionalidad){
        return ResponseEntity.ok(nacionalidadService.updateNacionalidad(id, nacionalidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Nacionalidad> deleteNacionalidad(@PathVariable Integer id){
        return ResponseEntity.ok(nacionalidadService.deleteNacionalidad(id));
    }
}
