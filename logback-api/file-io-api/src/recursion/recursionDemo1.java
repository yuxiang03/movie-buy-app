package recursion;

public class recursionDemo1 {
    public static void main(String[] args) {
        int result = f(5);
        System.out.println("5的阶乘结果为："+result);
    }
    public static int f(int n){
        if (n == 1){
            return 1;
        }else {
            return f(n-1)*n;
        }
    }
}
