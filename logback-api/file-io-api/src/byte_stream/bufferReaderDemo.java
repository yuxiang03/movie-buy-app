package byte_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class bufferReaderDemo {
    public static void main(String[] args) {
        try (
                Reader fr =new FileReader("file-io-api/data2.txt");
                BufferedReader br = new BufferedReader(fr)
        ){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
