package thread.volat;

public class VolatileSample extends Thread {
    private /*volatile*/ double instanceVariable = 0;

    void setDouble(double value) {
        this.instanceVariable = value;
    }

    /*public void run() {
        while (instanceVariable == 0) ;
        System.out.println(instanceVariable);
    }*/

    public void run() {
        try {
            while (instanceVariable == 0) {
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceVariable);
    }
}
