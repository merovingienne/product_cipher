package product_cipher.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.stage.FileChooser;
import product_cipher.Product_cipher;

public class fileIO {

    public static File openFile() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open text file");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("XML", "*.xml")
        );

        File file = fileChooser.showOpenDialog(Product_cipher.getStage());

        return file;
    }

    public static String readFile(File file) {
        String text = new String();

        if (file != null) { // if user clicks cancel without selecting a file
            try (Scanner input = new Scanner(file)) {
                text = "";
                while (input.hasNextLine()) {
                    text += input.nextLine() + "\n";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(fileIO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return text;
    }

    public static File saveFile() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save cipher text");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("XML", "*.xml")
        );

        File file = fileChooser.showSaveDialog(Product_cipher.getStage());

        return file;
    }

    public static boolean writeFile(File file, String cipherText) {
        System.out.println(cipherText);
        if (file != null) {
            try {
                OutputStreamWriter char_output = new OutputStreamWriter(
                        new FileOutputStream(file),
                        Charset.forName("UTF-16").newEncoder()
                );
                
                char_output.append(cipherText);
                
                char_output.close();
                
                return true;
            } catch (IOException ex) {
                Logger.getLogger(fileIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static String readCipherFile(File file) {
        String text = new String();

        if (file != null) { // if user clicks cancel without selecting a file
            try (Scanner input = new Scanner(file, "UTF-16")) {
                text = "";
                while (input.hasNextLine()) {
                    text += input.nextLine() + "\n";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(fileIO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return text;
    }

}
