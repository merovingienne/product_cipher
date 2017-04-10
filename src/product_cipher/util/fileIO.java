package product_cipher.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(cipherText);
                writer.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(fileIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
