package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("===========客户端启动===========");
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = "徐世茂在狗叫，你在听吗？".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
        //发送数据出去
        socket.send(packet);

        socket.close();
    }
}
