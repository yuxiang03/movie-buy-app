package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//反序列化
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file-io-api/data5.txt"));
        Student s = (Student) ois.readObject();
        System.out.println(s);
    }
}
