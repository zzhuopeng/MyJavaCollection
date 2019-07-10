public class IAmThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {

    int timer = 0;

    @Override
    public void run() {

        while (true) {
            System.out.println("I am Thread Timer , now is " + timer++);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}