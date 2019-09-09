package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.TulajdonosDao;
import entities.Gepjarmu;
import entities.Tulajdonos;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Hibernate;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class TulajdonosGepjarmuveiController implements Initializable {

    @FXML
    private TableView<Gepjarmu> gepjarmuTabla;
    @FXML private TableColumn<Gepjarmu,String> rendszamOszlop;
    @FXML private TableColumn<Gepjarmu,String> markaOszlop;

    @FXML
    private Label tul;

    @FXML
    private TextField markaTextField;

    @FXML
    private TextField rendszamTextField;

    private Integer tulajdonosId;
    private GepjarmuDao gepjarmuDao;
    private TulajdonosDao tulajdonosDao;

    private Tulajdonos tulajdonos;

    private List<Gepjarmu> gepjarmuvek;

    /*
    public void initData(Integer id){
        this.tulajdonosId = id;
        Logger.info("inticializálták az id-met");
        this.tul.setText(this.tulajdonosId.toString());
        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());
        this.tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());

        Tulajdonos tulajdonos = this.tulajdonosDao.getEm().getReference(Tulajdonos.class, id);

        tulajdonos.getGepjarmuvek();


    }*/


    public void initData(Tulajdonos tulajdonos){

        this.tulajdonos = tulajdonos;
        markaOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("marka"));
        rendszamOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("rendszam"));

        this.gepjarmuvek = tulajdonos.getGepjarmuvek();
        gepjarmuTabla.setItems(FXCollections.observableArrayList(this.gepjarmuvek));
        gepjarmuTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());

    }

    public void ujGepjarmuPushed(){


        Gepjarmu gepjarmu = new Gepjarmu(this.markaTextField.getText(), this.rendszamTextField.getText(), this.tulajdonos);
        Logger.info("mentés előtt: " + gepjarmu);
        this.gepjarmuDao.persist(gepjarmu);
        Logger.info("mentés után: " + gepjarmu);
        this.gepjarmuvek.add(gepjarmu);
        this.gepjarmuTabla.setItems(FXCollections.observableArrayList(this.gepjarmuvek));
    }
}
