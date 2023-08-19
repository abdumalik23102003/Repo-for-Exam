//todo - simulate the race condition problem here
// and the solution with commenting previous state.
public class RaceConditionProblem {
    public static int counter = 0;
    public static final int NUM_THREADS = 4;
    public static final int INCREMENT_TIMES = 1000000;

    public static void problem() throws InterruptedException {

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENT_TIMES; j++) {
                    counter++;
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("Final Counter Value: " + counter);
    }
}