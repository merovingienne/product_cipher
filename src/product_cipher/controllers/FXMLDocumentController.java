package product_cipher.controllers;

/**
 *
 * @author Chanuka Wijayakoon
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import product_cipher.util.fileIO;
import product_cipher.logic.encrypt;

public class FXMLDocumentController implements Initializable {

//    UI Elements
    @FXML
    private JFXTextArea input_text;

    @FXML
    private JFXTextArea encrypted_text;

    @FXML
    private JFXTextArea decrypted_text;

    @FXML
    private JFXButton encryptButton;

    @FXML
    private JFXButton fileSelectButton;

    @FXML
    private JFXButton clearButton;

    @FXML
    private JFXButton clearInputButton;

    @FXML
    private JFXButton decryptButton;

    @FXML
    private JFXTextField tpRounds;

    @FXML
    private JFXTextField numRows;

//    Event listeners
    @FXML
    void decryptText(ActionEvent event) {
        decrypted_text.setText(
                encrypt.decryptMsg(
                        encrypted_text.getText(),
                        Integer.parseInt(numRows.getText()),
                        Integer.parseInt(tpRounds.getText())));
    }

    @FXML
    void openFileChooser(ActionEvent event) {

        String x = fileIO.readFile(fileIO.openFile());

        if (x != null) {
            input_text.setText(x);
            encryptButton.setDisable(false);
        }
    }

    @FXML
    void encryptText(ActionEvent event) {

        if (input_text.getText().length() != 0) {
            decryptButton.setDisable(false);

            encrypted_text.setText(
                    encrypt.encryptMsg(
                            input_text.getText(),
                            Integer.parseInt(numRows.getText()),
                            Integer.parseInt(tpRounds.getText())));
        }
    }

    @FXML
    void clearAll(ActionEvent event) {
        input_text.clear();
        encrypted_text.clear();
        decrypted_text.clear();

        decryptButton.setDisable(true);
        encryptButton.setDisable(true);
    }

    @FXML
    void clearInput(ActionEvent event) {
        input_text.clear();

        encryptButton.setDisable(true);
    }

    @FXML
    void tpRoundsChanged(javafx.scene.input.KeyEvent event) {
        if (tpRounds.getText().length() == 0 || numRows.getText().length() == 0) {
            encryptButton.setDisable(true);
            decryptButton.setDisable(true);
        } else {
            encryptButton.setDisable(false);
            decryptButton.setDisable(false);
        }
    }

    @FXML
    void inputChanged(javafx.scene.input.KeyEvent event) {
        if (input_text.getText().length() == 0) {
            encryptButton.setDisable(true);
        } else {
            encryptButton.setDisable(false);
        }
    }

    @FXML
    void saveCipherText(ActionEvent event) {
        if (encrypted_text.getText().length() != 0) {
            boolean saved = fileIO.writeFile(
                    fileIO.saveFile(),
                    encrypted_text.getText());
        }
    }

    @FXML
    void openCipheredFile(ActionEvent event) {
        String x = fileIO.readCipherFile(fileIO.openFile());

        if (x != null) {
            encrypted_text.setText(x);
            encryptButton.setDisable(true);
            decryptButton.setDisable(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        decryptButton.setDisable(true);
        encryptButton.setDisable(true);

    }

}
