import executor.Reminder;
import executor.ReminderScheduler;
import race.RaceConditionProblem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import static executor.DataBase.REMINDERS;
import static streams.Streams.copyFile;
import static streams.Streams.copyFileAndRename;

// todo - please do not forget creating git repository
//  for this exam and make it public, and also share the link
//  of the project in the group.
public class Main {
    static Scanner scanStr = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.print("""
                1. Streams
                2. ExecutorService
                3. Race condition problem
                0. Exit
                proyektni tanlang:""");
        String choose = scanStr.nextLine();
        switch (choose) {
            case "1" -> {
                Streams();
            }
            case "2" -> {
                executorService();
            }
            case "3" -> {
                RaceConditionProblem.problem();
            }
            case "0" -> {
                return;
            }
        }

    }

    private static void executorService() {
        System.out.print("""
                1. creat reminder
                2. cancel reminder
                3. mark as completed
                0. Exit
                choose:""");
        String choose = scanStr.nextLine();
        switch (choose){
            case "1" -> {
                creatReminder();
            }
            case "2" -> {
                cancelReminder();
            }
            case "3" -> {
                reminder();
            }
        }
    }

    private static void reminder() {
        Reminder reminder = findReminder();
        if (reminder != null) {
            ReminderScheduler.markReminderAsCompleted(reminder);
        }
    }

    private static boolean cancelReminder() {
        Reminder reminder = findReminder();
        return ReminderScheduler.cancelReminder(reminder);
    }

    private static Reminder findReminder() {
        System.out.print("idi sini kiriting:");
        String id = scanStr.nextLine();

        for (Reminder reminder : REMINDERS) {
            if (reminder.getUuid().equals(UUID.fromString(id))) {
                return reminder;
            }
        }
        return null;
    }

    private static void creatReminder() {
        System.out.print("write text for remind to you:");
        String text = scanStr.nextLine();
        System.out.print("set a time:(in the format \"yyyy-MM-dd HH:mm:ss\")");
        String time = scanStr.nextLine();
        Date date = getDateWithFormat(time);
        Reminder reminder = new Reminder(text, (java.sql.Date) date, false);
        REMINDERS.add(reminder);
        System.out.println("reminder successfully created");
    }

    private static void Streams() {
        copyFileAndRename("src/streams/notes.txt");
        copyFile("src/streams/source.txt", "src/streams/destination.txt");
    }
    public static Date getDateWithFormat(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(input);
            System.out.println("Parsed Date and Time: " + parsedDate);
        } catch (ParseException e) {
            System.err.println("Invalid date and time format. Please use yyyy-MM-dd HH:mm:ss.");
        }
        return parsedDate;
    }
}
