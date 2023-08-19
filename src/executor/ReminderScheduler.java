package executor;

import static executor.DataBase.REMINDERS;

public class ReminderScheduler{
    public static void scheduleReminder(Reminder reminder) {

    }
    public static boolean cancelReminder(Reminder reminder) {
        REMINDERS.remove(reminder);
        return false;
    }
    public static void markReminderAsCompleted(Reminder reminder) {
        reminder.setCompleted(true);
    }
}
