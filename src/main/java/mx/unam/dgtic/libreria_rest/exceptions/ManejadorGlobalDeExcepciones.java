package mx.unam.dgtic.libreria_rest.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalDeExcepciones {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> manejarPeticionesErroneas(
            HttpMessageNotReadableException ex,
            HttpServletRequest request
    ) {
        HashMap<String, Object> detalle = new HashMap<>();
        detalle.put("mensaje","La petición esta mal formada");
        detalle.put("timeStamp", LocalDateTime.now().toString());
        detalle.put("ruta", request.getRequestURI());
        detalle.put("code", 400);

        return ResponseEntity.badRequest().body(detalle);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, Object>> erroresDeValidacion(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ){
        HashMap<String, Object> detalle = new HashMap<>();
        detalle.put("mensaje","Error de validación");
        detalle.put("timeStamp", LocalDateTime.now().toString());
        detalle.put("ruta", request.getRequestURI());
        HashMap<String, String> detalleCampos = new HashMap<>();

        for(FieldError err : ex.getBindingResult().getFieldErrors()){
            detalleCampos.put(err.getField(), err.getDefaultMessage());
        }
        detalle.put("detalle", detalleCampos);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON).body(detalle);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HashMap<String, Object>> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex,
            HttpServletRequest request
    ) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("mensaje", "Error de integridad de datos. Verifica los campos obligatorios.");
        response.put("error", ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage());
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("ruta", request.getRequestURI());
        response.put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<HashMap<String, Object>> getNoExisteElemento(
            RecursoNoEncontradoException ex,
            HttpServletRequest request
    ){
        HashMap<String, Object> detalle = new HashMap<>();
        detalle.put("mensaje",ex.getMessage());
        detalle.put("timeStamp", LocalDateTime.now().toString());
        detalle.put("ruta", request.getRequestURI());
        detalle.put("status", HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalle);
        return ResponseEntity.ok(detalle);
    }
}
