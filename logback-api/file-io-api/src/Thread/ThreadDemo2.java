package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Callable<String> call1 = new MyCallable(100);
        FutureTask<String> ft = new FutureTask<>(call1);
        Thread t = new Thread(ft);
        t.start();

        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> ft2 = new FutureTask<>(call2);
        Thread t2 = new Thread(ft2);
        t2.start();

        try {
            //如果ft任务没有执行完毕，这里的代码会等待，直到线程1跑完才提取结果
            String rs1 = ft.get();
            System.out.println("第一个结果："+rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String rs2 = ft.get();
            System.out.println("第二个结果："+rs2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n){
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return "子线程输出结果："+sum;
    }
}
