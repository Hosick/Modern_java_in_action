package thread.sync;

public class CommonCalculate {
    private int amount;

    public CommonCalculate() {
        amount = 0;
    }

    public synchronized void plus(int value) {
        amount += value;
    }

    public void minus(int value) {
        synchronized(this){
            amount -= value;
        }
    }

    public int getAmount() {
        return amount;
    }
}
