package TCP;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo3 {
    public static void main(String[] args) {
        try {
            System.out.println("=========客户端启动=========");
            Socket socket = new Socket("127.0.0.1",8383);
            OutputStream os = socket.getOutputStream();
            //把低级的字节流打包装成打印流
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("请说：");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
