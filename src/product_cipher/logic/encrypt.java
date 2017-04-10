package product_cipher.logic;

/**
 * @author Chanuka Wijayakoon
 */
import java.util.Random;
public class encrypt {
    
//    private Random
    
    public static String encryptMsg(String msg){
        String cipherText = "";
        
        for (char x: msg.toCharArray()){
            cipherText += Character.reverseBytes(x);
////            if (Character.isWhitespace(x)){
//                System.out.println(Character.getNumericValue(x));
////            }
        }
        
        return cipherText;
    }
    
    public static String decryptMsg(String msg){
        String decryptedText = "";
        
        for (char x: msg.toCharArray()){
            decryptedText += Character.reverseBytes(x);
        }
        
//        System.out.print(decryptedText);
        
        return decryptedText;
    }
}
