import edu.duke.*;
/**
 * Write a description of CeaserBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CeaserBreaker {
    public int[] CountLetters(String message){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        
        for(int i = 0 ; i < message.length() ; i = i+1){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alpha.indexOf(ch);
            
            if(dex !=-1){
                count[dex] += 1; 
            }
        }
        return count;
    }
    
    public String decrypt (String encrypt){
        CeasarCipher cc = new CeasarCipher();
        int dkey = getKey(encrypt);
        
      return cc.encrypt(encrypt , 26-dkey);
    }
    
    public int maxIndex(int[] val){
        int maxdex = 0;
        for(int i = 0 ; i < val.length; i++){
            if(val[i] > val[maxdex]){
                maxdex = i;
            }
        }
        return maxdex;
    }
    
    public void TestDecrypt(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(decrypt(message));
        
        
    }
    
    public String getHalfString(String message , int start){
        StringBuilder mess = new StringBuilder(message);
        StringBuilder mess_half = new StringBuilder();
        for(int i = start ; i < message.length() ; i = i + 2){
            char ch = Character.toLowerCase(mess.charAt(i));
            if(Character.isLetter(ch)){
                mess_half.append(ch);
        }
    }
    return mess_half.toString();
}

public int getKey(String encrypt){
    int[] freq = CountLetters(encrypt);
        int maxdex = maxIndex(freq);
        int dkey = maxdex - 4;
        
        if(maxdex < 4){
            dkey = 26-(4 - maxdex);
        }
        
    return dkey;
}

public String decryptTwoKeys(String encrypt){
    String encrypt_E = getHalfString(encrypt , 0);
    String encrypt_O = getHalfString(encrypt , 1);
    
    int key1 = getKey(encrypt_E);
    int key2 = getKey(encrypt_O);
    
    System.out.println("Key1 is " + key1 + " Key2 is " + key2);
    
   CeasarCipher cc = new CeasarCipher();
   
   return cc.encryptTwoKeys(encrypt , 26-key1 , 26-key2);
    
}

public void testDecryptTwoKeys(){
    FileResource fr = new FileResource();
    String message = fr.asString();
    String decrypted = decryptTwoKeys(message);
    
    System.out.println(decrypted);
}
}


