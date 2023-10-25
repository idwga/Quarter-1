   import java.util.*;
   import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

   public class MorseCode
   {
      //here are two arrays, one of English characters and one of their corresponding Morse Code equivalents.
      //english[i] is the English equivalent of code[i] for every index i in the arrays 
      public static final String [] english = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                                   "�","�","�","Ch","�","�","�","�",
            							  "0","1","2","3","4","5","6","7","8","9",
            							  ".",",",":","?","'","-","_","(",""+(char)(34),"@","="};	//char 34 is the quote character
      public static final String [] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
                                ".-.-",".--.-",".--.-","----","..-..","--.--","---.","..--",
            						  "-----",".----","..---","...--","....-",".....","-....","--...","---..","----.",
            						  ".-.-.-","--..--","---...","..--..",".----.","-....-","-..-.","-.--.-",".-..-.",".--.-.","-...-"};	
      

      public void encode() throws IOException
      {
         
         Path fileName = Path.of("english.TXT");
         int a = english.length;
         int b =0;
         String mes = Files.readString(fileName);
         int c = mes.length();
         String temp="";
         String fmes="";
         
         for(int i = 0; i<c;i++) 
         {
            
            temp = mes.substring(i);
            temp = temp.toUpperCase();
            /*
            for(int p=0;p<a;p++)
            {
               if(temp.equals(english[p]))
               {
                  b=p;
               }
            }
            fmes+=code[b]+"/";
            */
            System.out.print(temp);
            
         }  
         System.out.println();  
      }



      public void decode()
      {
         System.out.println("decode");
      }
   }

