package serializable;

import java.io.*;

//对象序列化
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student("张三","zhangsan00",18,"bbbi999");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file-io-api/data5.txt"));
        oos.writeObject(s);
        oos.close();
        System.out.println("对象序列化完成！");
    }
}
