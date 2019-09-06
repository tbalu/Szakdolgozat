package controllers;

import daos.EntityManagerCreator;
import daos.TulajdonosDao;
import entities.Tulajdonos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TulajdonosokListajaController implements Initializable {

    @FXML private TableView<Tulajdonos> tulajdonosTabla;
    @FXML private TableColumn<Tulajdonos,String> jogositvanyOszlop;
    @FXML private TableColumn<Tulajdonos,String> nevOszlop;
    @FXML private TableColumn<Tulajdonos, String> lakcimOszlop;

    @FXML private TextField MunkavegzesKoltsege;

    TulajdonosDao tulajdonosDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //AutoMarkajaOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("AutoMarkaja"));
        jogositvanyOszlop.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        nevOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("nev"));
        lakcimOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("lakcim"));


        this.tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());

        tulajdonosTabla.setItems(FXCollections.observableArrayList(tulajdonosDao.getAll()));
/*
        FolyamatbanLevoSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        */
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //MunkavegzesKezdeteOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
    /*
        FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
  */
    }
}
