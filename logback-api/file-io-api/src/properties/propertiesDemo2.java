package properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        System.out.println(properties);

        properties.load(new FileReader("file-io-api/data6.txt"));
        System.out.println(properties);
        String rs = properties.getProperty("zhangsan");
        System.out.println(rs);
        String rs1 = properties.getProperty("admin");
        System.out.println(rs1);
    }
}
