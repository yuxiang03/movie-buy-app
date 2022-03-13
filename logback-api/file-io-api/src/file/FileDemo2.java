package file;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File f = new File("file-io-api");
        String[] names = f.list();
        for (String name : names) {
            System.out.println(name);
        }
        //获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回
        File[] files = f.listFiles();
        for (File f2 : files) {
            System.out.println(f2.getAbsoluteFile());
        }
    }
}
