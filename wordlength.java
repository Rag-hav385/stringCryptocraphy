import edu.duke.*;
/**
 * Write a description of wordlength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordlength {
    public int[] countWordLengths( FileResource fr , int[] counts){
        
        for(String word : fr.words()){
            int length = getlength(word);
            counts[length] = counts[length] + 1;
        }
        return counts;
    }
    
    public int getlength(String word){
        StringBuilder word_SB = new StringBuilder(word);
        int length = 0;
        for(int i = 0 ; i < word.length();i ++){
            char currChar = word_SB.charAt(i);
            if (Character.isLetter(currChar)){
                length = length + 1;
            }
            
        }
        return length;
    }
    
    public void TestcountWordLengths(){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        int[] freqs = countWordLengths( fr , counts);
        // for (int i = 1 ; i < 31 ; i++){
            // if (freqs[i] > 0){
                // System.out.println("No. of words of length" + i + "are :" + freqs[i]);
                
            // }
        // }
        
        int maxWordindex = indexofmax(freqs);
        System.out.println("Max word length : " + maxWordindex + " with " + freqs[maxWordindex] + " times ");
    }
    
    public int indexofmax(int[] count){
        int max = 0;
        int maxindex = 0;
        for (int i = 0 ; i < count.length ; i++){
            if (count[i] > max){
                max = count[i];
                maxindex = i;
            }
        }
        return maxindex;
    }
}
