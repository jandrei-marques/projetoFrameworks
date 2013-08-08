package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Font;

/**
 *
 * @author Jandrei
 */
public class AtendimentoController implements Initializable {
    
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnProxSenha;

    @FXML
    private Label lbDuracao;

    @FXML
    private Label lbPreferencial;

    @FXML
    private Label lbProxSenha;

    @FXML
    private Label lbSenhaAtual;

    @FXML
    private TitledPane painelAtendimento;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
