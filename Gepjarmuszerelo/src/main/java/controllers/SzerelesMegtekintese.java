package controllers;

import daos.*;
import entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nezetek.FelhasznaltAlkatreszekNezet;
import nezetek.JavitasTipusNezet;
import nezetek.JavitasokNezet;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SzerelesMegtekintese extends GepjarmuszereloBasicControllerWithInitData{


    private Szereles szereles;


    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());

    private OradijasJavitasTipusDao oradijasJavitasTipusDao = new OradijasJavitasTipusDao(EntityManagerCreator.getEntityManager());
    private JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
    private JavitasTipusDao javitasTipusDao = new JavitasTipusDao(EntityManagerCreator.getEntityManager());

    private AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
    private FelhasznaltAlkatreszDao felhasznaltAlkatreszDao = new FelhasznaltAlkatreszDao(EntityManagerCreator.getEntityManager());


    private List<FelhasznaltAlkatresz> kitorlendoFelhasznaltAlkatreszek = new ArrayList<>();
    private List<Javitas> kitorlendoJavitasok = new ArrayList<>();

    @FXML private TableView javitasokTV;

    //@FXML private TableView felhasznaltAlkatreszekTV;



    @FXML private TableView felhasznaltAlkatreszekTV;

    private TableManager<FelhasznaltAlkatreszekNezet> felahasznaltAlkatreszekTM;
    private TableManager<JavitasokNezet> javitasokTM ;

    

    @Override
    public void initData(Object o) {
        Szereles szereles = (Szereles)o;
        //Hibernate.initialize(szereles);

        this.szereles = szereles;

        Logger.info(this.szereles.getJavitasok());

        //this.javitasokTM.setEntitasok(JavitasokNezet.of(this.javitasDao.findAll(this.szereles.getJavitasokIdk())));
        this.javitasokTM.setEntitasok(JavitasokNezet.of(this.szereles.getJavitasok()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.felahasznaltAlkatreszekTM = new TableInjector<>(this.felhasznaltAlkatreszekTV);
        this.javitasokTM = new TableInjector<>(this.javitasokTV);

    }

    public void felhasznaltAlkatreszeinekMegjelenitesePushed(){

        //Javitas javitas = this.javitasDao.getById(this.javitasokTM.getSelectedEntity().getId());
        Javitas javitas = this.javitasokTM.getSelectedEntity().getJavitas();
        Logger.info(javitas.getId());
        Logger.info(javitas.getFelhasznaltAlkatreszek().size());
        for(FelhasznaltAlkatresz felhasznaltAlkatresz: javitas.getFelhasznaltAlkatreszek()){
            Logger.info(felhasznaltAlkatresz.toString());
        }

        for(FelhasznaltAlkatreszekNezet felhasznaltAlkatreszekNezet: FelhasznaltAlkatreszekNezet.of(javitas.getFelhasznaltAlkatreszek())){

            Logger.info(felhasznaltAlkatreszekNezet.toString());

        }

        this.felahasznaltAlkatreszekTM.setEntitasok(FelhasznaltAlkatreszekNezet.of(javitas.getFelhasznaltAlkatreszek()));

    }

}