package file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("file-io-api/data.txt");
        System.out.println(f1.getAbsoluteFile());
        //创建文件夹
        File f2 = new File("file-io-api/data2.txt");
        System.out.println(f2.createNewFile());
        //mkdir创建一级文件夹
        File f3 = new File("file-io-api/aaa");
        System.out.println(f3.mkdir());
        //mkdirs创建多级文件夹
        File f4 = new File("file-io-api/ccc/ddd/eee/fff");
        System.out.println(f4.mkdirs());
        //删除文件或空文件夹
        File f5 = new File("file-io-api/aaa");
        System.out.println(f5.delete()); //占用一样可以删除
    }
}
