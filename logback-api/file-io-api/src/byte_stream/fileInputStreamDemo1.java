package byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class fileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //创建一个文件字节流输入流管道与源文件接通
        InputStream is = new FileInputStream("file-io-api/data.txt");

        //读取一个自己返回
        /*
        int b1 = is.read();
        System.out.println((char) b1);

        int b2 = is.read();
        System.out.println((char) b2);

         */
        //改进以上代码
        //int b;
        //while ((b = is.read()) != -1){
        //    System.out.print((char) b);
        //}

        byte[] buffer = new byte[3];
        int len;
        while ((len = is.read(buffer)) != -1) {
            System.out.print(new String(buffer,0,len));
        }
    }
}
