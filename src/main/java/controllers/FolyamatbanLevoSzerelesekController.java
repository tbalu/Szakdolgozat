package controllers;

import datastore.DataStore;
import entities.BefejezendoSzereles;
import entities.Szereles;
import entitymanager.SzerelesManager;
import guidemo.Person;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FolyamatbanLevoSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> FolyamatbanLevoSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> AutoMarkajaOszlop;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> MunkavegzesKezdeteOszlop;

    @FXML private TextField MunkavegzesKoltsege;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //AutoMarkajaOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("AutoMarkaja"));
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("Rendszam"));
        MunkavegzesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles, LocalDate>("SzerelesKezdete"));

        FolyamatbanLevoSzerelesekTablaNezet.setItems(DataStore.getBefejezetlenSzerelesek());

        FolyamatbanLevoSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //MunkavegzesKezdeteOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/view/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    public void szerelesVegePushed(){
        //SzerelesManager.getInstance().szerelesBefejezese()
        ObservableList<Szereles>  FolyamatbanLevoSzerelesek;
        Szereles KivalasztottSor;
        FolyamatbanLevoSzerelesek = FolyamatbanLevoSzerelesekTablaNezet.getItems();

        KivalasztottSor = FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().getSelectedItem();
        Logger.info(KivalasztottSor);
        SzerelesManager.getInstance().szerelesBefejezese(KivalasztottSor,Integer.valueOf(MunkavegzesKoltsege.getText()));
        FolyamatbanLevoSzerelesek.remove(KivalasztottSor);
        Logger.info(DataStore.getSzerelesek());
    }
}
