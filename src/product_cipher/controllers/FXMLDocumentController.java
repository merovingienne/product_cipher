/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_cipher.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import product_cipher.util.fileIO;
import product_cipher.logic.encrypt;

/**
 *
 * @author Chanuka Wijayakoon
 */
public class FXMLDocumentController implements Initializable {
    
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
    private JFXButton decryptButton;

    @FXML
    void decryptText(ActionEvent event) {
        decrypted_text.setText(encrypt.decryptMsg(encrypted_text.getText()));
    }

    @FXML
    void openFileChooser(ActionEvent event) {
        
        String x = fileIO.openFile();
        
//        System.out.println(x);
        
        input_text.setText(x);
        
//        fileChooser.showOpenDialog(null);
    }
    

    @FXML
    void encryptText(ActionEvent event) {
        encrypted_text.setText(encrypt.encryptMsg(input_text.getText()));
        decryptButton.setDisable(false);
        clearButton.setDisable(false);
    }
    
    @FXML
    void clearAll(ActionEvent event){
        input_text.clear();
        encrypted_text.clear();
        decrypted_text.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        encryptButton.setDisable(true);
        decryptButton.setDisable(true);
        clearButton.setDisable(true);
        
    }    
    
}
