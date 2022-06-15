public class ArrayQueue<T> implements Queue, Cloneable {
    public int maxCapacity;
    public ArrayQueue(int maxCapacity){
        if (maxCapacity < 0) {
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
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
