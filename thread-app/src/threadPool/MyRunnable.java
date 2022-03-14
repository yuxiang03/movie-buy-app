package threadPool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"输出了：Hello World!===>"+i);
            try {
                System.out.println(Thread.currentThread().getName()+"本任务与线程绑定了，线程进入休眠");
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
