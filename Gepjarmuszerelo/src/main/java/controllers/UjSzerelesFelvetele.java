package controllers;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.SzerelesDao;
import daos.UgyfelDao;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Ugyfel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import utils.AutoCompleteTextField;

import javax.persistence.DiscriminatorValue;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UjSzerelesFelvetele implements Initializable {

    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());

    //@FXML private TextField nevTextField;
    @FXML private TextField telefonszamTF;
    @FXML private TextField lakcimTF;
    @FXML private TextField nevTF;

    @FXML private TextField tipusTF;
    @FXML private TextField motorTerfogataTF;
    @FXML private TextField teljesitmenyTF;

    @FXML private TextField evjaratTF;
    @FXML private TextField vizsgaLejartaTF;

    private Ugyfel ugyfel;
    private Gepjarmu gepjarmu;
    private Szereles szereles;


    @Override
    public void initialize(URL location, ResourceBundle resources) {





    }

    private Ugyfel ujUgyfelletrehozasa(){

        return new Ugyfel(this.nevTF.getText(), this.telefonszamTF.getText(),this.lakcimTF.getText());


    }

    private void ujUgyfelMentese(){

        this.ugyfelDao.persist(this.ujUgyfelletrehozasa());


    }

    public void ujUgyfel(){}

    public void ujGepjarmu(){}

    public void szerelesInditasa(){}
}