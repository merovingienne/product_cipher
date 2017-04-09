/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_cipher.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import product_cipher.Product_cipher;

/**
 *
 * @author Chanuka Wijayakoon
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private JFXTextField tf1;

    @FXML
    private JFXButton printButton;
    
    @FXML
    private JFXButton fileSelectButton;

    @FXML
    void openFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        
        fileChooser.showOpenDialog(Product_cipher.getStage());
//        fileChooser.showOpenDialog(null);
    }

    @FXML
    void printText(ActionEvent event) {
        System.out.println(tf1.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
