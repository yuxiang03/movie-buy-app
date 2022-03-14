package threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        /* 创建线程池对象
        public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)
         */
        ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Runnable p = new MyRunnable();
        pool.execute(p);
        pool.execute(p);
        pool.execute(p);

        pool.execute(p);
        pool.execute(p);
        pool.execute(p);
        pool.execute(p);
        pool.execute(p);

        pool.execute(p);
        pool.execute(p);


    }
}
