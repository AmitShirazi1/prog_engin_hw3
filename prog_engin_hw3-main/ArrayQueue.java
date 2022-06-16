import java.util.ArrayList;

public class ArrayQueue<T> implements Queue, Cloneable {
    private static int FIRST_ELEMENT_INDEX=0;
    public int maxCapacity;
    public ArrayList<T> elements;
    private int numberOfElements = 0;
    private int head=0;
    private int rear=0;


    public ArrayQueue(int maxCapacity){
        if (maxCapacity < 0) {
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
        this.elements = new ArrayList<T>();
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public void enqueue(T element) throws QueueException{
        if(numberOfElements+1 >= maxCapacity) {
            throw new QueueOverflowException();
        }
        elements.add(++rear, element);
        numberOfElements++;
    }

    public T dequeue() throws QueueException{
        T popped = this.peek();

        }
        return popped;
    }
    public T peek() throws QueueException{
        if(numberOfElements==0){
            throw new EmptyQueueException();
        }
        T popped = this.elements.get(FIRST_ELEMENT_INDEX);
        return popped;
    }
    @Override
    public ArrayQueue<T> clone() {
        try {
            return (ArrayQueue) super.clone();
        }
        catch (Exception exception) {
            return null;
        }
    }
}
