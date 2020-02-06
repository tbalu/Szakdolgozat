package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.SzerelesDao;
import daos.UgyfelDao;
import entities.Szereles;
import entities.Ugyfel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nezetek.FolyamatbanLevoSzerelesNezet;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FolyamatbanLevoSzerelesek extends BasicController implements Initializable {

    @FXML private TableView<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesekTV;


    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());


    private TableManager<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesekManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       folyamatbanLevoSzerelesekManager = new TableInjector<>(this.folyamatbanLevoSzerelesekTV);

        List<Szereles> folyamatbanLevoSzerelesek = this.szerelesDao.folyamatbanLevoSzerelesek();

        List<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesNezetek =
                FolyamatbanLevoSzerelesNezet.listaLetrehozas(folyamatbanLevoSzerelesek);

        //folyamatbanLevoSzerelesekManager.addEntity(folyamatbanLevoSzerelesNezetek);
        Logger.info(folyamatbanLevoSzerelesek.size());

        this.folyamatbanLevoSzerelesekManager.addEntity(folyamatbanLevoSzerelesNezetek);
        //folyamatbanLevoSzerelesekManager.setEntitasok(folyamatbanLevoSzerelesNezetek);

       // Logger.info(folyamatbanLevoSzerelesek);
    }
}
