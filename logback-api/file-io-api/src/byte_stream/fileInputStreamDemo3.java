package byte_stream;

import java.io.*;

public class fileInputStreamDemo3 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("file-io-api/data4.txt",true); //true表示追加数据，去掉的话每次都会清空之前的数据
        os.write('a');
        os.write(98);

        byte[] buffer = {'a',98,99,100};
        os.write(buffer);
        byte[] buffer2 = "我是中国人".getBytes();
        os.write(buffer2);
        os.flush();  //刷新流，还可以继续写数据
        os.close();  //关闭流，释放资源，但是在关闭之前会先刷新流。一旦关闭，就不能再写数据
    }
}
