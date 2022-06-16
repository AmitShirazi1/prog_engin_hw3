public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException() {}
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
