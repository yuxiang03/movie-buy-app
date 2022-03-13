package byte_stream;

import java.io.*;

public class byteBufferTimeDemo {
    private static final String SRC_FILE = "/Users/yuxiang/Documents/video/Java/[P152]08影片下架修改展示排片信息用户购票-16464917698059902.mp4";
    private static final String DEST_FILE = "/Users/yuxiang/Documents/video/";
    public static void main(String[] args) {
        //code1();  太慢了，直接淘汰
        code2();    //使用低级字节流按照一个一个字节数组的形式复制文件；比较慢，但是还是可哟接受的
        code3();    //缓冲流一个一个字节复制，很慢，不建议使用
        code4();    //缓冲流一个一个字节数组复制，飞快，简直太完美了
    }

    private static void code4() {
        long startTime = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(DEST_FILE+"video4.mp4");
                OutputStream bos = new BufferedOutputStream(os)
        ) {
            int a;
            byte[] buffer = new byte[1024];
            while ((a = bis.read(buffer)) != -1){
                bos.write(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用缓冲字节流按照一个一个字节数组的形式复制文件耗时："+(endTime-startTime)/1000.0+"s");
    }

    private static void code3() {
        long startTime = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(DEST_FILE+"video3.mp4");
                OutputStream bos = new BufferedOutputStream(os)
        ) {
            int a;
            while ((a = bis.read()) != -1){
                bos.write(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用缓冲字节流按照一个一个字节的形式复制文件耗时："+(endTime-startTime)/1000.0+"s");
    }


    private static void code2() {
        long startTime = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE+"video2.mp4")
        ) {
            byte[] buffer = new byte[1024];
            int a;
            while ((a = is.read(buffer)) != -1){
                os.write(buffer,0,a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级字节流按照一个一个字节数组的形式复制文件耗时："+(endTime-startTime)/1000.0+"s");
    }


    private static void code1() {
        long startTime = System.currentTimeMillis();
        try(
                InputStream is = new FileInputStream(SRC_FILE);
                OutputStream os = new FileOutputStream(DEST_FILE+"video1.mp4")
                ) {
            int a;
            while ((a = is.read()) != -1){
                os.write(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级字节流按照一个一个字节的形式复制文件耗时："+(endTime-startTime)/1000.0+"s");
    }
}
