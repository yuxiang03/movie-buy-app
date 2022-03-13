package byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class fileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        File f = new File("file-io-api/data3.txt");
        InputStream is = new FileInputStream(f);
/*
        byte[] buffer = new byte[(int) f.length()];
        int len = is.read(buffer);
        System.out.println(f.getName()+"文件中的内容为："+new String(buffer));

 */
        byte[] buffer = is.readAllBytes();
        System.out.println(f.getName()+"文件中的内容为："+new String(buffer));

    }
}
