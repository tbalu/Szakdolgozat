package controllers;

import entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import nezetek.FelhasznaltAlkatreszekNezet;
import nezetek.JavitasokNezet;
import org.pmw.tinylog.Logger;
import utils.TableManagerImpl;
import utils.TableManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SzerelesMegtekintese extends GepjarmuszereloBasicControllerWithInitData{


    protected Szereles szereles;

    @FXML protected TableView javitasokTV;

    //@FXML private TableView felhasznaltAlkatreszekTV;

    @FXML protected TableView felhasznaltAlkatreszekTV;

    protected TableManager<FelhasznaltAlkatreszekNezet> felahasznaltAlkatreszekTM;
    protected TableManager<JavitasokNezet> javitasokTM ;

    

    @Override
    public void initData(Object o) {
        Szereles szereles = (Szereles)o;
        //Hibernate.initialize(szereles);

        this.szereles = szereles;

        Logger.info(this.szereles.getJavitasok());

        //this.javitasokTM.setEntitasok(JavitasokNezet.of(this.javitasDao.findAll(this.szereles.getJavitasokIdk())));
        //Logger.info(JavitasokNezet.of(this.szereles.getJavitasok()));
        List<JavitasokNezet> javitasokNezetek = JavitasokNezet.of(this.szereles.getJavitasok());
        this.javitasokTM.setEntitasok(JavitasokNezet.of(this.szereles.getJavitasok()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.felahasznaltAlkatreszekTM = new TableManagerImpl<>(this.felhasznaltAlkatreszekTV);
        this.javitasokTM = new TableManagerImpl<>(this.javitasokTV);

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