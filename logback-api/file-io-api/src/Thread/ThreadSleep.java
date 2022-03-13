package Thread;

public class ThreadSleep {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            System.out.println("输出："+i);
            if (i == 3){
                Thread.sleep(3000);
            }
        }
    }
}
