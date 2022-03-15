package TCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {
    public static void main(String[] args) {
        try {
            System.out.println("=========服务端启动=========");
            //注册端口
            ServerSocket serverSocket = new ServerSocket(8383);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"上线了！");
                new ServerReaderThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
