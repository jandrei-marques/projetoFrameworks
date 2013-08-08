/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Jandrei
 */
public class GeradorController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGerarSenhaAten;

    @FXML
    private Button btnGerarSenhaCaixa;

    @FXML
    private Button btnMaisOpAten;

    @FXML
    private Button btnMaisOpCaixa;

    @FXML
    private Button btnMenosOpAten;

    @FXML
    private Button btnMenosOpCaixa;

    @FXML
    private Label btnTempoAten;

    @FXML
    private CheckBox ckPreferencial;

    @FXML
    private CheckBox ckPreferencialAten;

    @FXML
    private Label lbNumOpAten;

    @FXML
    private Label lbNumOperacaoCaixa;

    @FXML
    private Label lbProxSenha;

    @FXML
    private Label lbProxSenhaAten;

    @FXML
    private Label lbTempoCaixa;

    @FXML
    private Label lbUltAtendimento;

    @FXML
    private Label lbUltSenhaAten;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
