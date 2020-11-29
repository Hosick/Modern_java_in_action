package thread.local;

public class OtherLogic {
    public void printMyNumber() {
        System.out.println(Thread.currentThread().getName() + " OtherLogic value=" + ThreadLocalSample.get());
    }
}