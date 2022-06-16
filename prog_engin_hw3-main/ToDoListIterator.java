import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task> {
    private int currentIndex;
    private int tasksSize;
    private ArrayList<Task> tasks;

    public ToDoListIterator(ArrayList<Task> tasks, int tasksSize) {
        this.currentIndex = 0;
        this.tasks = tasks;
        this.tasksSize = tasksSize;
    }

    public Task next(){
        return this.tasks.get(currentIndex++);
    }

    public boolean hasNext(){
        return (this.currentIndex < (this.tasksSize - 1)) && (this.tasks.get(currentIndex) != null);
    }


}
