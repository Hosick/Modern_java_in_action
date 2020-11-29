package thread.local;

public class RunThreadLocal {
    public static void main(String[] args) {
        RunThreadLocal sample = new RunThreadLocal();
        sample.runThread();
    }

    public void runThread() {
        for (int loop = 0; loop < 3; ++loop) {
            try {
                Thread.sleep(100);
                LocalUserThread thread = new LocalUserThread();
                thread.start();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
