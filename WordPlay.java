import java.util.*;
import java.io.*;
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public boolean isVowel(char ch){
        char ch_U = Character.toUpperCase(ch);
        String Test_Vowel = "AEIOU";
        
        for (int i = 0 ; i < Test_Vowel.length() ; i = i +1){
            char test_char = Test_Vowel.charAt(i);
            if (ch_U == test_char){
                return true;
            }
        }
        
        return false;
   }
   
   public void TestisVowel(){
       if(isVowel('A')){
        System.out.println("true");
    }
       if(isVowel('a')){
        System.out.println("true");
    }
      if(!(isVowel('B'))){
        System.out.print("true");
    }
    }
   
   public String replaceVowels(String phrase , char ch){
       StringBuilder ph = new StringBuilder(phrase);
       
       
       for (int i = 0 ; i < phrase.length() ; i ++){
           char currChar = ph.charAt(i);
           if (isVowel(currChar)){
               ph.setCharAt(i,ch);
           }
       }
       return ph.toString();
   }
   
   public void TestreplaceVowels(){
    String replaced_vowel = replaceVowels("Hello World" , '*');
    System.out.println("Replaced Vowel :" + replaced_vowel); 
   }
   
   public String emphasize ( String phrase , char ch){
       StringBuilder ph = new StringBuilder(phrase);
       
       for(int i = 0 ; i < phrase.length() ; i = i+1){
            char currChar = ph.charAt(i);
            if( i%2 == 0 && currChar == ch){
                ph.setCharAt(i , '*');
            }
            
            if (i%2 != 0 && currChar == ch){
                ph.setCharAt(i , '+');
            }
       }
       
       return ph.toString();
   }
   
   public void Testemphasize(){
        String replaced_char = emphasize("dna ctgaaactga", 'a');
        System.out.println(replaced_char);
        
        
   }
}
