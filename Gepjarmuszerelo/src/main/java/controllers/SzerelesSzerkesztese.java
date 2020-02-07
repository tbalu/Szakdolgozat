package controllers;

import daos.*;
import entities.OradijasJavitas;
import entities.OradijasJavitasTipus;
import entities.Szereles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.pmw.tinylog.Logger;
import utils.TableManager;


import java.net.URL;
import java.util.ResourceBundle;

public class SzerelesSzerkesztese extends BasicController implements Initializable {


    private Szereles szereles;

    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());

    private OradijasJavitasTipusDao oradijasJavitasTipusDao = new OradijasJavitasTipusDao(EntityManagerCreator.getEntityManager());

    private JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());

    @FXML private TableView javitasokTV;
    @FXML private TextArea leirasTA;
    @FXML private TextField munkaorakSzamaTF;

    @FXML private TableView felhasznaltAlkatreszekTV;
    @FXML private TextField nevTF;
    @FXML private TextField arTF;
    @FXML private TextField javitasGaranciaIdotartamaTF;

    private TableManager felahasznaltAlkatreszekTM;
    private TableManager javitasokTM;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void intiData(Szereles szereles){

        this.szereles = szereles;
        Logger.info("szereles id" + this.szereles.getId());

    }

    private OradijasJavitasTipus ujOradijasJavitasTipusMentese(){
        OradijasJavitasTipus oradijasJavitasTipus =
                new OradijasJavitasTipus(this.leirasTA.getText(),Integer.parseInt(this.javitasGaranciaIdotartamaTF.getText()));
        oradijasJavitasTipusDao.persist(oradijasJavitasTipus);
        return oradijasJavitasTipus;

    }

    private OradijasJavitas ujOradijasJavitasMentese(OradijasJavitasTipus oradijasJavitasTipus){

        OradijasJavitas oradijasJavitas =
                new OradijasJavitas(this.szereles,oradijasJavitasTipus,Integer.parseInt(this.munkaorakSzamaTF.getText()));

            this.javitasDao.persist(oradijasJavitas);
            return oradijasJavitas;
    }

    public void javitastHozzaad(){

        ujOradijasJavitasMentese(this.ujOradijasJavitasTipusMentese());


    }

    public void alkatresztHozzaad(){

    }

}
