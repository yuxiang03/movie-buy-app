package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("===========客户端启动===========");
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                System.out.println("离线成功！");
                socket.close();
                break;
            }
            byte[] buffer = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
            //发送数据出去
            socket.send(packet);
        }
        socket.close();
    }
}
