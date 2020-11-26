package thread.practice;

import java.util.Date;

public class TimerThread extends Thread {
    public void run() {
        printCurrentTime();
    }

    public void printCurrentTime() {
        try {
            for (int i = 0; i < 10; ++i) {
                Date date = new Date();
                System.out.print(date.toString()+" / ");
                System.out.println(System.currentTimeMillis() % 1000);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
