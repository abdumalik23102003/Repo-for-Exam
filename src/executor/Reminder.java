package executor;

import java.sql.Date;
import java.util.UUID;

public class Reminder{
    private UUID uuid;
    private String task;
    private Date time;
    private boolean completed;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTime() {
        return time;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Reminder(String task, Date time, boolean completed) {
        this.task = task;
        this.time = time;
        this.completed = completed;
    }

    public Reminder() {
    }

}
