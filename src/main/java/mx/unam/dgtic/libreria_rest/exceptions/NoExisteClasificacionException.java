package mx.unam.dgtic.libreria_rest.exceptions;

public class NoExisteClasificacionException extends RecursoNoEncontradoException {
    public NoExisteClasificacionException(String message, Integer idNoEncontrado) {
        super(message, idNoEncontrado);
    }
}
