package dk.group_02.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashMaker
{

    public String hasher(String password)
    {
        String encryptedString = null;
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");            
            messageDigest.update (password.getBytes());
            encryptedString = new String(messageDigest.digest());
        } 
        catch (NoSuchAlgorithmException ex)
        {
            System.err.println("Jeg er ironman");
        }
        return encryptedString;
    }

}
