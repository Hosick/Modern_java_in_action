package thread.support;

public class SleepThread extends Thread {
    long sleepTime;

    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            System.out.println("sleeping " + getName());
            Thread.sleep(sleepTime);
            System.out.println("Stopping " + getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
