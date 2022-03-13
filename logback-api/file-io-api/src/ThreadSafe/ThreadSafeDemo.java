package ThreadSafe;

public class ThreadSafeDemo {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-111",100000);
        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();
    }
}
