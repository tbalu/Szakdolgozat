package controllers;

import datastore.DataStore;
import entities.Szereles;
import entitymanager.SzerelesManager;
import guidemo.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BefejezettSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> BefejezettSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesKezdeteOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesVegeOszlop;
    @FXML private TableColumn<Szereles, Integer> ArOszlop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("Rendszam"));
        SzerelesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesKezdete"));
        SzerelesVegeOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesBefejezese"));
        ArOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,Integer>("MunkavegzesKoltsege"));

        BefejezettSzerelesekTablaNezet.setItems(SzerelesManager.getInstance().getBefejezettSzerelesek());

        BefejezettSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
