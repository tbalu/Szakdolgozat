package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.SzerelesDao;
import daos.UgyfelDao;
import entities.Szereles;
import entities.Ugyfel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import nezetek.FolyamatbanLevoSzerelesNezet;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;

import java.io.IOException;
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

    public void szerelesSzerkesztesereNavigal() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("SzerelesSzerkesztese.fxml"));
        loader.setLocation(FXMLLoader.getDefaultClassLoader()
                .getResource("SzerelesSzerkesztese.fxml"));

        Parent root = loader.load();

        SzerelesSzerkesztese controller = loader.getController();

        controller.intiData(this.szerelesDao.getById(this.folyamatbanLevoSzerelesekManager.getSelectedItem().getId()));

        Scene ujScene = new Scene(root);



        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        Stage window = (Stage)menuBar.getScene().getWindow();

        window.setScene(ujScene);
        window.show();
        Logger.info("meghivtak");

    }
}
