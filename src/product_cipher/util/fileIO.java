package product_cipher.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.stage.FileChooser;
import product_cipher.Product_cipher;

public class fileIO {

    public static String openFile() {
        String text = "empty string.";
        try {

            FileChooser fileChooser = new FileChooser();

            File file = fileChooser.showOpenDialog(Product_cipher.getStage());

            if (file!=null) {

                try (Scanner input = new Scanner(file)) {
                    text = "";
                    while (input.hasNextLine()) {
                        text += input.nextLine();
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

}
