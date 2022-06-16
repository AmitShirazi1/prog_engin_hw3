import java.util.Date;
import java.util.Calendar;

public class Task implements Cloneable{
    private Date dueDate;
    private String taskDescription;

    public Task(String taskDescription, Date dueDate) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }
    public Date getDueDate() { return this.dueDate; }

    public String dueDateToString() {
        int date = this.dueDate.getDate();
        String day = "";
        if (date < 10) {
            day += "0";
        }
        day += date;

        date = this.dueDate.getMonth();
        String month = "";
        if (date < 10) {
            month += "0";
        }
        month += date;

        date = this.dueDate.getYear();

        return day + "." + month + "." + date;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "(" + this.taskDescription + ", " + this.dueDateToString() + ")";
    }

    @Override
    public int hashCode() {
        int descriptionHash = this.taskDescription.hashCode();
        int dateHash = this.dueDate.hashCode();
        return descriptionHash * dateHash;

    }

    @Override
    public boolean equals(Object other) {
        Task otherTask = null;
        if (other.getClass().equals(this.getClass())) {
            otherTask = (Task) other;
        }
        if (this == otherTask) {
            return true;
        }
        if (otherTask == null) {
            return false;
        }
        if (this.getTaskDescription().equals(otherTask.getTaskDescription())) {
            if (this.dueDateToString().equals(otherTask.dueDateToString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Task clone(){
        try {
            Task taskCopy = (Task) super.clone();
            Date dueDateCopy = (Date) this.dueDate.clone();
            taskCopy.setDueDate(dueDateCopy);
            return taskCopy;
        }
        catch (CloneNotSupportedException exception){return null;}
    }
}
