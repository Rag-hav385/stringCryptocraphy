import edu.duke.*;
/**
 * Write a description of CeasarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CeasarCipher {
    public String encrypt(String phrase , int key){
        StringBuilder ph = new StringBuilder(phrase);
        String Test_C = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Test_S = "abcdefghijklmnopqrstuvwxyz";
        String shifted_C = Test_C.substring(key) + Test_C.substring(0 , key);
        String shifted_S = Test_S.substring(key) + Test_S.substring(0 , key);
        for (int i = 0 ; i < phrase.length() ; i = i + 1){
            char currChar = ph.charAt(i);
            int idx_C = Test_C.indexOf(currChar);
            int idx_S = Test_S.indexOf(currChar);
            if(idx_C !=-1 && Character.isUpperCase(currChar)){
                char new_char = shifted_C.charAt(idx_C);
                
                ph.setCharAt(i , new_char);
            }
            
            if(idx_S !=-1 && Character.isLowerCase(currChar)){
                char new_char = shifted_S.charAt(idx_S);
                
                ph.setCharAt(i , new_char);
            }
        }
        return ph.toString();
    }
    
    public void Test(){
        // FileResource fr = new FileResource();
        // String f_content = fr.asString();
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?" , 15));
        
        
    }
    
    public String encryptTwoKeys( String Phrase , int key1 , int key2){
        StringBuffer ph = new StringBuffer(Phrase);
        StringBuffer result = new StringBuffer();
         for(int i = 0 ; i < Phrase.length() ; i = i + 1){
             if (i%2 == 0){
                 char currChar = ph.charAt(i);
                 String currChar_S =  Character.toString(currChar);
                 String encrypt = encrypt(currChar_S , key1);
                 
                 result.append(encrypt);
             }
             else{
                 char currChar = ph.charAt(i);
                 String currChar_S =  Character.toString(currChar);
                 String encrypt = encrypt(currChar_S , key2);
                 
                 result.append(encrypt);
                 
             }
                 
         }
        
        return result.toString();
    }

    public void TestEncryptTwoKeys(){
        FileResource fr = new FileResource();
        String f_content = fr.asString();
        System.out.println(encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy." , 12 , 2));
        
        
    }
    
}



