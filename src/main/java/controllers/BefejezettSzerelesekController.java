package controllers;

import datastore.DataStore;
import entities.Szereles;
import entitymanager.StatisztikaManager;
import entitymanager.SzerelesManager;
import guidemo.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class BefejezettSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> BefejezettSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesKezdeteOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesVegeOszlop;
    @FXML private TableColumn<Szereles, Integer> ArOszlop;
    @FXML private Label EzEviBevetel;
    @FXML private Label EHaviBevetel;
    @FXML private Label MaiBevetel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<>("Rendszam"));
        SzerelesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesKezdete"));
        SzerelesVegeOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesBefejezese"));
        ArOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,Integer>("MunkavegzesKoltsege"));

        BefejezettSzerelesekTablaNezet.setItems(SzerelesManager.getInstance().getBefejezettSzerelesek());

        BefejezettSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());


        Optional<Integer> ehavibevetel = StatisztikaManager.getInstance().eHaviBevetel();
        Optional<Integer> ezevibevetel = StatisztikaManager.getInstance().ezEviBevetel();
        Optional<Integer> maibevetel = StatisztikaManager.getInstance().maiBevetel();
        ehavibevetel.ifPresent(c->EHaviBevetel.setText(c.toString()));
        ezevibevetel.ifPresent(c->EzEviBevetel.setText(c.toString()));
        maibevetel.ifPresent(c->MaiBevetel.setText(c.toString()));


        /*
        EHaviBevetel.setText(StatisztikaManager.getInstance().eHaviBevetel().toString());
        EzEviBevetel.setText(StatisztikaManager.getInstance().ezEviBevetel().toString());
        MaiBevetel.setText(StatisztikaManager.getInstance().maiBevetel().toString());*/
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
