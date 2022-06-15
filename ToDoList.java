import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToDoList implements Iterable<Task> {
    //represents a list of tasks.
    public List<Task> tasks;
    public ToDoList(){
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task newTask) {
        try {
            for (Task task : this) {
                if (task.getTaskDescription().equals(newTask.getTaskDescription())) {
                    throw new TaskAlreadyExistsException();
                }
            }
            this.tasks.add(newTask);
        }
        catch (TaskAlreadyExistsException TaskAlreadyExistsException);
    }

    @Override
    public Iterator<Task> iterator() {
        return this.tasks.iterator();
    }

    @Override
    public String toString() {
        String toDoList = "[";
        int taskCount = 0;
        for (Task task : this.tasks) {
            if (taskCount > 0) {
                toDoList += "," + task.toString();
            }
            else {
                toDoList += task.toString();
                taskCount ++;
            }
        }
        toDoList += "]";
        return toDoList;
    }

    @Override
    public int hashCode() {
        int tasksHash = 0;
        int counter = 1;
        for (Task task : this.tasks) {
            tasksHash += (task.hashCode() - tasksHash) / counter ;
            counter++;
        }
        return tasksHash;

    }

    @Override
    public boolean equals(ToDoList otherList) {
        int tdlLength = this.tasks.size();
        int otherLength = otherList.tasks.size();
        if ( (tdlLength != otherLength) || (tdlLength == 0) || (otherList == null) ) {
            return false;
        }
        int count = 0;

        for (Task task : this.tasks) {
            for (Task otherTask : otherList.tasks) {
                if (task.equals(otherTask)) {
                    count++;
                }
            }
            if (count < otherLength) {
                return false;
            }
        }
        return true;
    }
}

