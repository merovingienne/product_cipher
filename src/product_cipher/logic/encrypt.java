package product_cipher.logic;

/**
 * @author Chanuka Wijayakoon
 */
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Base64;

public class encrypt {
    private static String key = "secret";
    
//    private Random
    
    public static String encryptMsg(String msg, int numRows, int tpRounds){
        String cipherText;
        
        cipherText = substitute(msg);
        
        for (int i=0; i<tpRounds; i++){
            cipherText = transpose(cipherText, numRows);
        }
        
        return cipherText;
    }
    
    public static String decryptMsg(String cipher, int numRows, int tpRounds){
        String decryptedText = "";
        
        decryptedText = reSubstitute(cipher);
        
        for (int j=0; j< tpRounds; j++){
            decryptedText = retranspose(decryptedText, numRows);
        }
        
        return decryptedText;
    }
    
    public static String substitute(String s){
        String cipher = "";
        for (char x: s.toCharArray()){
            cipher += Character.reverseBytes(x);
        }
        return cipher;
    }
    
    public static String transpose(String s, int k){
        int padding = 0;
        String transpositionInput = s;
        
        if (s.length()%k !=0){
            padding = k- (s.length()%k);
            
            for (int j = 0; j < padding; j++) {
                transpositionInput += "/";
            }
        }
              
        
        StringBuilder transpositionOutput = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < transpositionInput.length() / k; j++) {
                char c = transpositionInput.charAt(i + (j * k));
                transpositionOutput.append(c);
            }
        }
        return new String(transpositionOutput);
    }
    
    public static String reSubstitute(String s){
        String decipher = "";
        for (char x: s.toCharArray()){
            decipher += Character.reverseBytes(x);
        }
        return decipher;
    }

    public static String retranspose(String s, int k){
        k = s.length() / k;
        StringBuilder retransposed = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < s.length() / k; j++) {
                char c = s.charAt(i + (j * k));
                retransposed.append(c);
            }
        }
        
        return new String(retransposed);
    }
    
    
}
