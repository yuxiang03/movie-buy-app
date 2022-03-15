package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServiceDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("========服务端启动========");
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        socket.receive(packet);
        int len = packet.getLength();
        String rs = new String(buffer,0,len);
        System.out.println("收到了！"+rs);

        socket.close();
    }
}
