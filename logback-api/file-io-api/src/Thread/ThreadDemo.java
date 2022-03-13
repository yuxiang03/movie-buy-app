package Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程1运行输出："+i);
                }
            }
        };
        Thread t = new Thread(target);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2运行输出："+i);
                }
            }
        }).start();

        new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程3运行输出："+i);
                }
        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程运行输出："+i);
        }
    }
}
