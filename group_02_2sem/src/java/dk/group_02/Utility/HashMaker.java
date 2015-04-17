//package dk.group_02.Utility;
//
//import java.io.OutputStream;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class HashMaker
//{
//
//    public String hasher(String password)
//    {
//        String encryptedString = null;
//        try
//        {
//            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");            
//            messageDigest.update (password.getBytes());
//            byte[] hashpassword = messageDigest.digest();
//            encryptedString = new String(hashpassword);
//        } 
//        catch (NoSuchAlgorithmException ex)
//        {
//            System.err.println("Jeg er ironman");
//        }
//        return encryptedString;
//    }
//
//}

//  MessageDigest digest=MessageDigest.getInstance("SHA-256");
//  digest.update(password.getBytes());
//  byte[] hashPassword=digest.digest();
//  outputStream.write(hashPassword);
//  FileInputStream inputStream=getContext().openFileInput(FILE_NAME);
//  PasswordStorage storage=new PasswordStorage(inputStream);
//  assert(storage.verifyPassword(password));