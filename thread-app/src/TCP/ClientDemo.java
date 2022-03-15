package TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("=========客户端启动=========");
        try {
            Socket socket = new Socket("127.0.0.1",7777);
            OutputStream os = socket.getOutputStream();
            //把低级的字节流打包装成打印流
            PrintStream ps = new PrintStream(os);
            ps.print("我是TCP客户端，我已经与你对接，并发出了邀请:约吗？");
            ps.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
