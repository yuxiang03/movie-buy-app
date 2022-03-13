package recursion;

import java.io.File;
import java.io.IOException;

public class recursionDemo2 {
    public static void main(String[] args) {
        searchFile(new File("/Users/yuxiang/Documents"),"data.txt");
    }
    public static void searchFile(File dir,String fileName){
        if (dir != null && dir.isDirectory()){
            //提取当前目录下的一级文件对象
            File[] file = dir.listFiles();
            if (file != null && file.length > 0){
                for (File files : file) {
                    //判断当前遍历的一级文件对象是文件还是目录
                    if (files.isFile()){
                        if (files.getName().contains(fileName)){
                            System.out.print(fileName+"的位置为："+files.getAbsolutePath());
                        }
                    }else {
                        searchFile(files,fileName);
                    }
                }
            }
        }else {
            System.out.println("对不起，当前搜索的对象不是文件夹");
        }
    }
}
