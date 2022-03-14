package threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo3 {
    public static void main(String[] args) throws Exception {
        //创建固定线程数据的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

    }
}
