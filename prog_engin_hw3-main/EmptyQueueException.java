public class EmptyQueueException extends QueueException{
    public EmptyQueueException() {}
    public EmptyQueueException(String message) {
        super(message);
    }
}
