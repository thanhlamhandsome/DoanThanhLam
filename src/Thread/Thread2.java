package Thread;

public class Thread2 extends Thread  {
    NumberPrint numberPrint  ;

    public Thread2(NumberPrint numberPrint) {
        this.numberPrint = numberPrint;
    }

    @Override
    public void run() {
        synchronized (numberPrint) {
            try {
                for (int i = 97; i <= 122; i++) {
                    System.out.println((char) i);
                    numberPrint.notify(); // Thông báo cho luồng khác rằng đã in ra một ký tự
                    if (i < 122) {
                        numberPrint.wait(); // Chờ cho đến khi luồng khác thông báo được
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
