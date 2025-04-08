package mx.unam.dgtic.libreria_rest.exceptions;

public class NoExisteNacionalidadException extends RecursoNoEncontradoException {
    public NoExisteNacionalidadException(String message, Integer idNoEncontrado) {
        super(message, idNoEncontrado);
    }
}
