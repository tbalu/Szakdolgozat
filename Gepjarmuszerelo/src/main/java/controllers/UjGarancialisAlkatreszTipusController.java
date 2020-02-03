package controllers;

import daos.EntityManagerCreator;
import daos.GarancialisAlkatreszTipusDao;
import entities.Alkatresz;
import entities.GarancialisAlkatreszTipus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class UjGarancialisAlkatreszTipusController implements Initializable {


    GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao;

    @FXML
    TextField nevTextField;
    @FXML
    TextField garanciaIdotartamaTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.garancialisAlkatreszTipusDao = new GarancialisAlkatreszTipusDao(EntityManagerCreator.getEntityManager());


    }

    public void letrehozasPushed(){
        this.garancialisAlkatreszTipusDao.persist(new GarancialisAlkatreszTipus(this.nevTextField.getText(),
                Integer.parseInt(this.garanciaIdotartamaTextField.getText())));
    }
}
