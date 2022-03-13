package byte_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class fileReaderDemo {
    public static void main(String[] args) throws Exception {
        Reader fr = new FileReader("file-io-api/data2.txt");
        char[] buffer = new char[1024];
        int len;
        while ((len = fr.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len));
        }
    }
}
