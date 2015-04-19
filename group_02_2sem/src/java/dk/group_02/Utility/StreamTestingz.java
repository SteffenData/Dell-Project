/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Utility;

import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTestingz
{

    public boolean streamToFile(String targetPath, InputStream input)
    {
        try
        {
            byte[] b = new byte[input.available()];
            //convert file into array of bytes
            input.read(b);

            //the variable targetPath should be the entire path to the file you want to create, something like: "C:\Users\Pagh\Desktop\kasperErSygtAwesome.png"
            FileOutputStream fileOuputStream = new FileOutputStream(targetPath);
            fileOuputStream.write(b);
            fileOuputStream.close();

            System.out.println("Done");
            return true;
        } catch (IOException e) 
        {
            //Denne exception bliver kastet hvis noget går galt (funktionen returnerer falsk, in that cast), så som at den angivne targetPath er en mappe i stedet for en fil, eller at target kun er read og ikke write etc etc...
            return false;
        }
    }
}
