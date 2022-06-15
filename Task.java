import java.util.Date;
import java.util.Calendar;

public class Task {
    private Date dueDate;
    private String taskDescription;

    public Task(String taskDescription, Date dueDate) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    private String getDueDate() {
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

        return day + "." + month + "." + date ;
    }

    @Override
    public String toString(){
        return "(" + this.taskDescription + ", " + this.getDueDate() + ")" ;
    }

    @Override
    public int hashCode() {
        int descriptionHash = this.taskDescription.hashCode();
        int dateHash = this.dueDate.hashCode();
        return descriptionHash*dateHash;

    }

    @Override
    public boolean equals(Task otherTask) {
        if (this == otherTask) {
            return true;
        }
        if (otherTask == null) {
            return false;
        }
        if (this.getTaskDescription().equals(otherTask.getTaskDescription())) {
            if (this.getDueDate().equals(otherTask.getDueDate())) {
                return true;
            }
        }
        return false;
    }
/*
    public boolean equals(Object otherAccurateClock) {
        if (this == otherAccurateClock) {
            return true;
        }
        if (otherAccurateClock == null) {
            return false;
        }

        if (!(otherAccurateClock instanceof AccurateClock)) {
            return false;
        }
        AccurateClock other = (AccurateClock) otherAccurateClock;
        if ((this.className != ACCURATE_CLOCK_CLASS_NAME) || (other.className != ACCURATE_CLOCK_CLASS_NAME)) {
            return false;
        }

        return (this.hour == other.hour && this.minute == other.minute && this.second == other.second);
    }
    */
}
