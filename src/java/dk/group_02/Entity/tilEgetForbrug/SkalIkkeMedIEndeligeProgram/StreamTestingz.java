package dk.group_02.Entity.tilEgetForbrug.SkalIkkeMedIEndeligeProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.FileUtils;

public class StreamTestingz
{
    public boolean streamToFile(String targetPath, InputStream input)
    {

        try
        {
//            byte[] b = new byte[1024];
//            //convert file into array of bytes
//            input.read(b);

            // outputStream = new FileOutputStream(new File("/Users/mkyong/Downloads/holder-new.js"));
            //the variable targetPath should be the entire path to the file you want to create, something like: "C:\Users\Pagh\Desktop\kasperErSygtAwesome.png"
//            FileOutputStream outputStream = new FileOutputStream(new File(targetPath));
//            int read = 0;;
//            while ((read = input.read(b)) != -1)
//            {
//                outputStream.write(b, 0, read);
//            }
//            //fileOuputStream.write(b);
//            outputStream.close();
            File fil = new File(targetPath);
            FileUtils.copyInputStreamToFile(input, fil);
       
            System.out.println("Done");
            return true;
        } catch (IOException e)
        {
            //Denne exception bliver kastet hvis noget går galt (funktionen returnerer falsk, in that cast), så som at den angivne targetPath er en mappe i stedet for en fil, eller at target kun er read og ikke write etc etc...
            return false;
        }
    }
}
