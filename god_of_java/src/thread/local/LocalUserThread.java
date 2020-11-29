package thread.local;

public class LocalUserThread extends Thread {
    public void run() {
        int value = ThreadLocalSample.generateNumber();
        System.out.println(this.getName() + " LocalIserThread value=" + value);

        OtherLogic otherLogic = new OtherLogic();
        otherLogic.printMyNumber();
        ThreadLocalSample.remove();
    }
}
