//Tim Lee Pd 3 

import java.util.*;
import java.io.*;
public class Vigenere{
   
   //main method
   public static void main(String[]args){
      
      System.out.println(vigenere());
      
   }
   
   //encrypting method
   public static String encrypt(String p, String k){
   
   //Take a key k, and plaintext p
   
      int kLen = 0;
      int letterVal = 0;
      String output = "";
      char current = 'a';
      String ori = p;
      p = p.toUpperCase();
      k = k.toUpperCase();
      
   //plaintext char at index is not alphabet, just add to string output;
   //get ASCII values for characters and use vigenere equation to get the ciphered values of each character
      for (int i = 0; i < p.length(); i ++){
         if (Character.isLetter(p.charAt(i))){
            kLen  = kLen % (k.length());
            letterVal = (char)(p.charAt(i) - 65);
            current = (char)(((letterVal + (k.charAt(kLen) - 65)) % 26)+65);
            kLen ++;
            if (Character.isLowerCase(ori.charAt(i)))
               output += Character.toLowerCase(current);
            else
               output += current;
         }
         else
            output += p.charAt(i);
      
      }
      return output;
   }
   //main 
   //use regex to validate the string input and then cipher
   public static int vigenere(){
   
      Scanner in = new Scanner(System.in);
      out:
      while(true){
         System.out.println("Enter a key");
         String k = in.next();
         boolean b = k.matches("[a-zA-Z]+");
      
         if (!b){
            System.out.println("Alphabetic Characters Only!!!");
            return 1;
         }
         System.out.println("Enter something to encrypt");
         String p = in.next();
         p += in.nextLine();
         System.out.println(encrypt(p, k));
         
         return 0;
         
         
         
      }
   
   }
}