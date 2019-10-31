package controllers;

import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.TulajdonosDao;
import entities.Gepjarmu;
import entities.Tulajdonos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TulajdonosokListajaController implements Initializable {

    @FXML private TableView<Tulajdonos> tulajdonosTabla;
    @FXML private TableColumn<Tulajdonos,String> jogositvanyOszlop;
    @FXML private TableColumn<Tulajdonos,String> nevOszlop;
    @FXML private TableColumn<Tulajdonos, String> lakcimOszlop;

    @FXML private TableView<Gepjarmu> gepjarmuTabla;
    @FXML private TableColumn<Gepjarmu,String> markaOszlop;
    @FXML private TableColumn<Gepjarmu,String> rendszamOszlop;

    @FXML private TextField markaTextField;
    @FXML private TextField rendszamTextField;

    @FXML private TextField jogositvanyszamTextField;
    @FXML private TextField nevTextField;
    @FXML private TextField lakcimTextField;


    @FXML private TextField keresettNevTextField;

    @FXML private ContextMenu tulajdonosTorleseGomb;

    private TulajdonosDao tulajdonosDao;
    private GepjarmuDao gepjarmuDao;

    private List<Tulajdonos> tulajdonosok;
    private List<Gepjarmu> gepjarmuvek;

    private Tulajdonos kivalasztottTulajdonos;
    private Gepjarmu gepjarmu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        markaOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("marka"));
        rendszamOszlop.setCellValueFactory(new PropertyValueFactory<Gepjarmu, String>("rendszam"));


        this.setDaok();

        this.setTulajdonosTablaOszlopai();
        this.tulajdonosok = new ArrayList<>();

        /*
        this.tulajdonosok = this.tulajdonosDao.findAll();
        this.setTulajdonosTablaErtekei(this.tulajdonosok);*/

        this.setTulajdonosTablaMindenTulajdonossal();

        this.gepjarmuvek = new ArrayList<>();




    }

    private void setTulajdonosTablaMindenTulajdonossal(){
        this.tulajdonosok = this.tulajdonosDao.findAll();
        this.setTulajdonosTablaErtekei(this.tulajdonosok);
    }

    private void setTulajdonosTablaOszlopai(){

        this.jogositvanyOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("jogositvanyszam"));
        this.nevOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("nev"));
        this.lakcimOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("lakcim"));

    }

    private void setTulajdonosTablaErtekei(List<Tulajdonos> tulajdonosok){

        this.tulajdonosTabla.setItems(FXCollections.observableArrayList(tulajdonosok));
        this.tulajdonosTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
    private void setDaok(){

        this.tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());
        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());
    }
    public void keresButtonPushed(){

        String nev = this.keresettNevTextField.getText();
        Logger.info("Erre a névre keres rá a felhasználó: " +nev);
        if(nev.equals("")){
            Logger.info("Az összes tulajdonos lekérdezése.");
            tulajdonosTabla.setItems(FXCollections.observableArrayList(tulajdonosDao.findAll()));
        } else {
            ObservableList o = FXCollections.observableArrayList(this.tulajdonosDao.getByNev(nev));
            tulajdonosTabla.setItems(o);
        }
    }

    private void scenetValt(){



    }


    private void setKivalasztottTulajdonos(){

        this.kivalasztottTulajdonos = this.tulajdonosTabla.getSelectionModel().getSelectedItem();
        Logger.info(this.kivalasztottTulajdonos);

    }

    public void gepjarmuveiButtonPushed(){
        this.setKivalasztottTulajdonos();
        this.setGepjarmuTabla();


    }

    private void setGepjarmuTabla(){

        //List<Gepjarmu> gepjarmuvek = this.kivalasztottTulajdonos.getGepjarmuvek();
        this.setGepjarmuvek();
        if(this.gepjarmuvek != null) {
            this.gepjarmuTabla.setItems(FXCollections.observableArrayList(this.gepjarmuvek));
        }
        else{
            this.gepjarmuTabla.setItems(FXCollections.observableArrayList((new ArrayList<>())));
        }
    }
    /*
    public void gepjarmuveiButtonPushed(ActionEvent event) throws IOException{

        Tulajdonos kivalasztottTulajdonos = tulajdonosTabla.getSelectionModel().getSelectedItem();
        Logger.info(kivalasztottTulajdonos);




        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("TulajdonosGepjarmuvei.fxml"));
        loader.setLocation(FXMLLoader.getDefaultClassLoader()
                .getResource("TulajdonosGepjarmuvei.fxml"));
        Parent root = loader.load();
        TulajdonosGepjarmuveiController controller = loader.getController();



        controller.initData(kivalasztottTulajdonos);
        Logger.info("kivalasztott tulajdonost átadtam " + kivalasztottTulajdonos);


        Scene tableViewScene = new Scene(root);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
*/
    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("TulajdonosEsAutoAdatai.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void ujGepjarmuPushed(){

        this.kivalasztottTulajdonos = tulajdonosTabla.getSelectionModel().getSelectedItem();
        Gepjarmu gepjarmu = new Gepjarmu(this.markaTextField.getText(), this.rendszamTextField.getText(), this.kivalasztottTulajdonos);
        Logger.info("mentés előtt: " + gepjarmu);
        this.gepjarmuDao.persist(gepjarmu);
        Logger.info("mentés után: " + gepjarmu);


        //this.gepjarmuTabla.setItems(FXCollections.observableArrayList(this.kivalasztottTulajdonos.getGepjarmuvek()));

        if(this.kivalasztottTulajdonos.getGepjarmuvek()!=null) {
            this.kivalasztottTulajdonos.getGepjarmuvek().add(gepjarmu);

            Logger.info("Nem nulla a gepjarmu listaja");

            this.gepjarmuvek = this.kivalasztottTulajdonos.getGepjarmuvek();
           // this.gepjarmuvek.add(gepjarmu);
        }
        else {
            Logger.info("nulla a gepjarmuvek listaja");
            this.gepjarmuvek = new ArrayList<>();
            this.kivalasztottTulajdonos.setGepjarmuvek(new ArrayList<>());
            this.kivalasztottTulajdonos.getGepjarmuvek().add(gepjarmu);

            this.gepjarmuvek = this.kivalasztottTulajdonos.getGepjarmuvek();

        }

        this.gepjarmuTabla.setItems(FXCollections.observableArrayList(this.gepjarmuvek));


        //this.kivalasztottTulajdonos.getGepjarmuvek().add(gepjarmu);


       // this.tulajdonosDao.update(this.kivalasztottTulajdonos);
    }

    private void setTulajdonosok(){




    }

    private Tulajdonos buildTulajdonos(){
        return new Tulajdonos(this.jogositvanyszamTextField.getText(),this.nevTextField.getText(),
                this.lakcimTextField.getText() ,null);
    }

    public void ujTulajdonosPushed(){

        Tulajdonos tulajdonos = buildTulajdonos();
        tulajdonos.setId(null);
        this.tulajdonosDao.persist(tulajdonos);
        this.tulajdonosok.add(tulajdonos);
        this.tulajdonosTabla.setItems(FXCollections.observableArrayList(this.tulajdonosok));

    }

    private void setGepjarmuvek(){

        this.gepjarmuvek = new ArrayList<>();
        if(this.kivalasztottTulajdonos!=null && this.kivalasztottTulajdonos.getGepjarmuvek()!=null) {
            for(Gepjarmu gepjarmu: this.kivalasztottTulajdonos.getGepjarmuvek()) {
                this.gepjarmuvek.add(gepjarmuDao.getById(gepjarmu.getId()));

                //this.gepjarmuvek = this.kivalasztottTulajdonos.getGepjarmuvek();
            }
        }
        else {
            this.gepjarmuvek = new ArrayList<>();
        }
    }

    public void tulajdonosTorlesePushed(){

        Tulajdonos tulajdonos = this.tulajdonosTabla.getSelectionModel().getSelectedItem();

        for(Gepjarmu gepjarmu: tulajdonos.getGepjarmuvek()){
            this.gepjarmuDao.remove(this.gepjarmuDao.getById(gepjarmu.getId()));
        }

        this.tulajdonosDao.remove(tulajdonos);

        this.setGepjarmuTabla();
        //this.setTulajdonosTablaOszlopai();
        this.setTulajdonosTablaMindenTulajdonossal();
    }
}
