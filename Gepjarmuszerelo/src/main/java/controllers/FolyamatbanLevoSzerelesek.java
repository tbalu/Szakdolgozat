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

public class FolyamatbanLevoSzerelesek extends GepjarmuszereloBasicController {

    @FXML private TableView<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesekTV;

    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());


    private TableManager<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesekManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       folyamatbanLevoSzerelesekManager = new TableInjector<>(this.folyamatbanLevoSzerelesekTV);

        List<Szereles> folyamatbanLevoSzerelesek = this.szerelesDao.folyamatbanLevoSzerelesek();

        List<FolyamatbanLevoSzerelesNezet> folyamatbanLevoSzerelesNezetek =
                FolyamatbanLevoSzerelesNezet.listaLetrehozas(folyamatbanLevoSzerelesek);

        Logger.info(folyamatbanLevoSzerelesek.size());

        this.folyamatbanLevoSzerelesekManager.addEntity(folyamatbanLevoSzerelesNezetek);

    }

    public void szerelesSzerkesztesereNavigal() throws IOException {
        Logger.info( "kivalasztott szereles id-ja");
    Logger.info( this.getKivalasztottSzerelesEntity().getId());
    szerelesSzerkesztesereNavigal("SzerelesSzerkesztese", this.getKivalasztottSzerelesEntity() );
    }

    private void szerelesSzerkesztesereNavigal(String fxmlNev, Szereles szereles) throws IOException {
        this.scenetValt(fxmlNev, szereles);


    }

    private Szereles getKivalasztottSzerelesEntity(){

        return this.szerelesDao.getById(this.folyamatbanLevoSzerelesekManager.getSelectedItem().getId());

    }

}
