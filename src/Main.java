import java.util.Scanner;

import static streams.Streams.copyFile;
import static streams.Streams.copyFileAndRename;

// todo - please do not forget creating git repository
//  for this exam and make it public, and also share the link
//  of the project in the group.
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanStr = new Scanner(System.in);
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

            }
            case "3" -> {
                RaceConditionProblem.problem();
            }
            case "0" -> {
                return;
            }
        }

    }

    private static void Streams() {
        copyFileAndRename("src/streams/notes.txt");
        copyFile("src/streams/source.txt", "src/streams/destination.txt");
    }
}
