package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.TulajdonosDao;
import entities.Gepjarmu;
import entities.Tulajdonos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class TulajdonosGepjarmuveiController implements Initializable {

    @FXML
    private TableView<Gepjarmu> gepjarmuTabla;
    @FXML private TableColumn<Gepjarmu,String> rendszamOszlop;
    @FXML private TableColumn<Gepjarmu,String> markaOszlop;

    @FXML
    private Label tul;

    private Integer tulajdonosId;
    GepjarmuDao gepjarmuDao;

    public void initData(Integer id){
        this.tulajdonosId = id;
        Logger.info("inticializálták az id-met");
        this.tul.setText(this.tulajdonosId.toString());
        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());
        //Logger.info(gepjarmuDao.getByTulajdonosId(id));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Logger.info("A kivalasztott tulajdonos id-ja: " + this.tulajdonosId);
        markaOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("marka"));
        rendszamOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("rendszam"));


        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());

        gepjarmuTabla.setItems(FXCollections.observableArrayList(gepjarmuDao.findAll()));
        gepjarmuTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
