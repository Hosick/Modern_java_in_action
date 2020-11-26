package thread;

public class RunEndlessThreads {
    public static void main(String[] args) {
        RunEndlessThreads runEndlessThreads = new RunEndlessThreads();
        runEndlessThreads.endless();
    }

    public void endless() {
        EndlessThread endlessThread = new EndlessThread();
        endlessThread.run();
    }
}
