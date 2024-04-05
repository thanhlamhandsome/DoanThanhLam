package Thread;

public class Thread1 extends Thread {
    NumberPrint numberPrint;

    public Thread1(NumberPrint numberPrint) {
        this.numberPrint = numberPrint;
    }

    @Override
    public  void run() {
        synchronized (numberPrint) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                numberPrint.notifyAll();
                try {
                    numberPrint.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}