import java.util.*;


public class ToDoList implements Cloneable, TaskIterable {
    //represents a list of tasks.
    public ArrayList<Task> tasks;
    public ToDoList(){
        this.tasks = new ArrayList<Task>();
    }
    private Date scanningDueDate;


    public void setScanningDueDate(Date scanningDueDate){
        this.scanningDueDate = scanningDueDate;
    }

    public void addTask(Task newTask) throws TaskAlreadyExistsException{
        for (Task task : this) {
            if (task.getTaskDescription().equals(newTask.getTaskDescription())) {
                throw new TaskAlreadyExistsException();
            }
        }
        this.tasks.add(newTask);
        throw new TaskAlreadyExistsException();
    }

    @Override
    public Iterator<Task> iterator() {
        //dueDate comparator
        Comparator<Task> compareByDate = Comparator.comparing(Task :: getDueDate);
        //ABC comparator
        Comparator<Task> compareByABC = Comparator.comparing(Task :: getTaskDescription);
        //Compare by DueDate and then by ABC (multiple fields)
        Comparator<Task> compareByDateAndABC = compareByDate.thenComparing(compareByABC);
        //use comparator
        ToDoList toDoListCopy = this.clone();
        Collections.sort(toDoListCopy.tasks, compareByDateAndABC);


        return new ToDoListIterator(toDoListCopy.tasks, changeTasksSize());
    }

    // Set the
    public int changeTasksSize() {

        if(this.scanningDueDate != null){
            int i=0;
            for (; i<=this.tasks.size() && this.tasks.get(i).getDueDate().before(ToDoList.this.scanningDueDate); i++) {}
            return (i+1);
        }
        return this.tasks.size(); //the whole list if no specific date given

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
    public boolean equals (Object other) {
        ToDoList otherList = null;
        if (other.getClass().equals(this.getClass())) {
            otherList = (ToDoList) other;
        }
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

    @Override
    public ToDoList clone() {
        try {
            ToDoList toDoListCopy = (ToDoList) super.clone();
            ArrayList<Task> tasksListCopy = (ArrayList<Task>) this.tasks.clone();
            for (int i = 0; i < tasks.size(); i++) {
                tasksListCopy.add(i, (Task) this.tasks.get(i).clone());
            }
            return toDoListCopy;

        } catch (CloneNotSupportedException exception) {
            return null;
        }
    }
}



