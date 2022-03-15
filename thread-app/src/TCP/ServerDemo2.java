package TCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) {
        System.out.println("=========服务端启动=========");
        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(9292);
            //必须调用accept方法，等待接收客户端的Socket链接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();
            //从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            //把字节输入流包装成缓冲字符流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg= br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"说了："+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
