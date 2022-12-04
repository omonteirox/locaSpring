package ifgoiano.FGSeguradora.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
    public ObjectNotFoundException(Long id) {
        super("Objeto com id: "+id+" não encontrado!");
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
