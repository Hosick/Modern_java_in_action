package thread;

public class DaemonThread extends Thread {
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
