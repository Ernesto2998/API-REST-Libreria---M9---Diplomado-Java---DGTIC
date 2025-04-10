package mx.unam.dgtic.libreria_rest.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

public class NoExisteLibroException extends RecursoNoEncontradoException {
    public NoExisteLibroException(String message, Integer idNoEncontrado) {
        super(message, idNoEncontrado);
    }
}
