package product_cipher.logic;

/**
 * @author Chanuka Wijayakoon
 */


public class encrypt {
    
//    Encryption method
    public static String encryptMsg(String msg, int numRows, int tpRounds){
        String cipherText;
        
        cipherText = substitute(msg);
        
        for (int i=0; i<tpRounds; i++){
            cipherText = transpose(cipherText, numRows);
        }
        
        return cipherText;
    }
    
    
//    Decryption method
    public static String decryptMsg(String cipher, int numRows, int tpRounds){
        String decryptedText = "";
        
        decryptedText = reSubstitute(cipher);
        
        for (int j=0; j< tpRounds; j++){
            decryptedText = retranspose(decryptedText, numRows);
        }
        
        return decryptedText;
    }
    
//    Substitution process
    public static String substitute(String s){
        String cipher = "";
        for (char x: s.toCharArray()){
            cipher += Character.reverseBytes(x);
        }
        return cipher;
    }
    
    
//    Transposition process
    public static String transpose(String s, int numRows){
        int padding = 0;
        String transpositionInput = s;
        
        if (s.length()%numRows !=0){
            padding = numRows- (s.length()%numRows);
            
            for (int j = 0; j < padding; j++) {
                transpositionInput += "/";
            }
        }
              
        
        StringBuilder transpositionOutput = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < transpositionInput.length() / numRows; j++) {
                char c = transpositionInput.charAt(i + (j * numRows));
                transpositionOutput.append(c);
            }
        }
        return new String(transpositionOutput);
    }
    
//    Reverse substitution
    public static String reSubstitute(String s){
        String decipher = "";
        for (char x: s.toCharArray()){
            decipher += Character.reverseBytes(x);
        }
        return decipher;
    }

//    Reverse transposition
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
