package mx.unam.dgtic.libreria_rest.exceptions;

public class NoExisteEditorialException extends RecursoNoEncontradoException {
    public NoExisteEditorialException(String message, Integer idNoEncontrado) {
        super(message, idNoEncontrado);
    }
}
