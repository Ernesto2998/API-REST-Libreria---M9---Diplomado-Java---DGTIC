package mx.unam.dgtic.libreria_rest.exceptions;

public class NoExisteAutorException extends RecursoNoEncontradoException {
    public NoExisteAutorException(String message, Integer idNoEncontrado) {
        super(message, idNoEncontrado);
    }
}