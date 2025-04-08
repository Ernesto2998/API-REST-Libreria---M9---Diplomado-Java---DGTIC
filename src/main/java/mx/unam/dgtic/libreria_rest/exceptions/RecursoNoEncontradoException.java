package mx.unam.dgtic.libreria_rest.exceptions;

public class RecursoNoEncontradoException extends RuntimeException {

    private final Integer idNoEncontrado;

    public RecursoNoEncontradoException(String message, Integer idNoEncontrado) {
        super(message);
        this.idNoEncontrado = idNoEncontrado;
    }

    public Integer getIdNoEncontrado() {
        return idNoEncontrado;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " | ID: " + idNoEncontrado;
    }
}