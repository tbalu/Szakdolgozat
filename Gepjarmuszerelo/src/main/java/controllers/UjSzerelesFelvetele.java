package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.SzerelesDao;
import daos.UgyfelDao;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Ugyfel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UjSzerelesFelvetele extends BasicController implements Initializable {

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
    @FXML private DatePicker vizsgaLejartaDP;



    //öröklött

   // @FXML private MenuBar menuBar;

    private Ugyfel ugyfel;
    private Gepjarmu gepjarmu;
    private Szereles szereles;


    @Override
    public void initialize(URL location, ResourceBundle resources) {





    }

    private Ugyfel ujUgyfelletrehozasa(){

        Ugyfel ugyfel =  new Ugyfel(this.nevTF.getText(), this.telefonszamTF.getText(),this.lakcimTF.getText());


        return ugyfel;

    }

    private void ujUgyfelMentese(){

        Ugyfel ugyfel = this.ujUgyfelletrehozasa();
        this.ugyfelDao.persist(ugyfel);
        this.ugyfel = ugyfel;

    }

    public void ujUgyfel(){

        ujUgyfelMentese();

    }


    public void ujGepjarmu(){

        Gepjarmu gepjarmu = new Gepjarmu(this.tipusTF.getText(),Integer.parseInt(this.motorTerfogataTF.getText())
                ,Integer.parseInt(this.teljesitmenyTF.getText()),this.vizsgaLejartaDP.getValue(),Integer.parseInt(this.evjaratTF.getText()));
        this.gepjarmuDao.persist(gepjarmu);
        this.gepjarmu = gepjarmu;


    }

    public void szerelesInditasa(){

        if(this.gepjarmu!=null && this.ugyfel != null){

            Logger.info("elinditom a szerelest");
            this.szerelesLetrehozasa();

        }

    }

    private void szerelesLetrehozasa(){

        Szereles szereles = new Szereles(this.gepjarmu,this.ugyfel);
        this.szerelesDao.persist(szereles);
        this.szereles = szereles;

    }

    // ököklődest kell megoldani rá:


}