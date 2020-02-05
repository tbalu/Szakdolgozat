package controllers;

import entities.GarancialisFixAruJavitasTipus;
import entities.JavitasTipus;
import entities.OsJavitasTipus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import utils.TableInjector;
import utils.TableManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class oroklodesestablaproba implements Initializable {

    @FXML private TableView<OsJavitasTipus> javitasTipusTabla;

    private TableManager<OsJavitasTipus> osJavitasTipusTableManager;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<OsJavitasTipus> javitasTipusok= new ArrayList<>();

        javitasTipusok.add(new JavitasTipus("dugatyu csere"));
        javitasTipusok.add(new GarancialisFixAruJavitasTipus("beallitas", 12,20000));

        this.osJavitasTipusTableManager = new TableInjector<>(this.javitasTipusTabla);

        osJavitasTipusTableManager.addEntity(javitasTipusok);

    }
}
