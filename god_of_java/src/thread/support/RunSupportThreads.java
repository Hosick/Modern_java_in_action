package thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        //sample.checkThreadState1();
        sample.checkJoin();
    }

    public void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);

        try {
            System.out.println("Thread state="+thread.getState());
            thread.start();
            System.out.println("Thread state(after start)="+thread.getState());

            Thread.sleep(1000);
            System.out.println("Thread state(after 1 sec)="+thread.getState());

            thread.join();
            thread.interrupt();
            System.out.println("Thread state(after join)="+thread.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void checkJoin(){
        SleepThread thread = new SleepThread(2000);
        try {
            thread.start();
            thread.join(2020);
            thread.interrupt();
            System.out.println("thread state(after join)="+thread.getState());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
