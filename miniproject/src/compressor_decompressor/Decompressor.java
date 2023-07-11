package compressor_decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException {
        String Filepath = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(Filepath + "/DecompressedFile.gz");
        byte buffer[] =new byte[1024];
        int len;
        while((len = gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fis.close();
        gzip.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:/Users/RD/Desktop/CompressedFile.gz");

        method(path);
    }
}
