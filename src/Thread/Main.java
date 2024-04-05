package Thread;
import Thread.Thread1;
import Thread.NumberPrint;
import Thread.Thread2;
public class Main {
    public static void main(String[] args) {
        NumberPrint numberPrint  = new NumberPrint();
        Thread1 t1 = new Thread1(numberPrint);
        Thread2 t2 = new Thread2(numberPrint);
        t1.start();
        t2.start();

    }
}