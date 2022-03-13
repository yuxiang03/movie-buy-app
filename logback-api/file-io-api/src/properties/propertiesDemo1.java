package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesDemo1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("zhangsan","789789");
        properties.setProperty("lihua","654321");
        System.out.println(properties);
        //参数以：保存管道 字符输出流管道
        //参数二：保存心得
        properties.store(new FileWriter("file-io-api/data6.txt"),"This is user!!! I am very happy!Give me 100!");
    }
}
