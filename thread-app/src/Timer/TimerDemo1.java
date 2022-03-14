package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
    public static void main(String[] args) {
        Timer timer = new Timer();  //定时器本身就是一个单线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行一次");
            }
        },3000,2000);
    }
}
