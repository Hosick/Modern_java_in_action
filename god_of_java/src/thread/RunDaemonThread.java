package thread;

public class RunDaemonThread {
    public static void main(String[] args) {
        RunDaemonThread thread = new RunDaemonThread();
        thread.runDaemonThread();
    }

    public void runDaemonThread(){
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }
}
