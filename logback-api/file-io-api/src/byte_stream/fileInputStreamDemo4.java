package byte_stream;

import java.io.*;

public class fileInputStreamDemo4 {
    public static void main(String[] args){
        /*
        手动释放资源
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("/Users/yuxiang/Documents/video/Git/[P5]04Git的安装-16465309533949449.mp4");
            os = new FileOutputStream("/Users/yuxiang/Documents/video/test/new.mp4");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            System.out.println("复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null)os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         */
        try(    //自动释放资源
                //这里只能放置资源对象，用完会自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                InputStream is = new FileInputStream("/Users/yuxiang/Documents/video/Git/[P5]04Git的安装-16465309533949449.mp4");
                OutputStream os = new FileOutputStream("/Users/yuxiang/Documents/video/test/new.mp4")

        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            System.out.println("复制完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
