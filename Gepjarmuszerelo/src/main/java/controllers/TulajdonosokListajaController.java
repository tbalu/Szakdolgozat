package controllers;

import com.sun.javafx.image.IntPixelGetter;
import daos.EntityManagerCreator;
import daos.GepjarmuDao;
import daos.TulajdonosDao;
import entities.Gepjarmu;
import entities.Tulajdonos;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;
/*
import otletek.TableInjector;
import otletek.TableManager;
*/
import utils.TableInjector;
import utils.TableManager;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TulajdonosokListajaController implements Initializable {


    private TableManager<Tulajdonos> tulajdonosokTablaManager;
    @FXML
    private TableView<Tulajdonos> tulajdonosTabla;

    @FXML private TableColumn<Tulajdonos,String> jogositvanyszamOszlop;
    @FXML private TableColumn<Tulajdonos,String> nevOszlop;
    @FXML private TableColumn<Tulajdonos, String> lakcimOszlop;

    private TableInjector<Gepjarmu> gepjarmuTablaManager;
    @FXML private TableView<Gepjarmu> gepjarmuTabla;
    @FXML private TableColumn<Gepjarmu,String> markaOszlop;
    @FXML private TableColumn<Gepjarmu,String> rendszamOszlop;

    @FXML private TextField markaTextField;
    @FXML private TextField rendszamTextField;

    @FXML private TextField tipusTextField;
    @FXML private TextField evjaratTextField;
    @FXML private TextField teljesitmenyTextField;
    @FXML private DatePicker vizsgaLejaratDatePicker;
    @FXML private TextField motorTerfogatTextField;

    @FXML private TextField telefonszamTextField;
    @FXML private TextField nevTextField;
    @FXML private TextField lakcimTextField;


    @FXML private TextField keresettNevTextField;

    @FXML private ContextMenu tulajdonosTorleseGomb;

    private TulajdonosDao tulajdonosDao;
    private GepjarmuDao gepjarmuDao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.tulajdonosokTablaManager = new TableInjector<>(this.tulajdonosTabla);

        this.gepjarmuTablaManager = new TableInjector<>(this.gepjarmuTabla);

        this.setDaok();

        this.setTulajdonosTablaMindenTulajdonossal();






    }

    //rendben van
    private void setTulajdonosTablaMindenTulajdonossal(){

        this.tulajdonosokTablaManager.setEntitasok(this.tulajdonosDao.findAll());
    }

    // rendben van
    private void setDaok(){

        this.tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());
        this.gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());
    }

    // rendeben van
    public void keresButtonPushed(){

        String nev = this.keresettNevTextField.getText();

        if(nev.equals("")){

            this.tulajdonosokTablaManager.setEntitasok(tulajdonosDao.findAll());

        } else {

            this.tulajdonosokTablaManager.setEntitasok(tulajdonosDao.getByNev(nev));

        }
    }

    // rendben van
    public void gepjarmuveiButtonPushed(){

        Tulajdonos tulajdonos = this.tulajdonosokTablaManager.getSelectedEntity();

        if(tulajdonos != null
                && tulajdonos.getGepjarmuvek() !=null) {

            List<Gepjarmu> gepjarmuvek = new ArrayList<>();
            for(Gepjarmu gepjarmu: tulajdonos.getGepjarmuvek()) {

                gepjarmuvek.add(gepjarmuDao.getById(gepjarmu.getId()));

            }

            this.gepjarmuTablaManager.setEntities(gepjarmuvek);

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
    /*
    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("TulajdonosEsAutoAdatai.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
*/

    // rendben van.
    private Gepjarmu buildGepjarmu(){

        return new Gepjarmu(this.tipusTextField.getText(),
                new Integer(Integer.parseInt(this.motorTerfogatTextField.getText())),
                new Integer(Integer.parseInt(this.teljesitmenyTextField.getText())),
                this.vizsgaLejaratDatePicker.getValue(),
                new Integer(Integer.parseInt(this.evjaratTextField.getText())),
                this.tulajdonosokTablaManager.getSelectedEntity(),null);


         //return new Gepjarmu(this.markaTextField.getText(), this.rendszamTextField.getText(), this.tulajdonosokTablaManager.getSelectedEntity());
    }


    // rendben van.
    public void ujGepjarmuPushed(){

        Tulajdonos tulajdonos = this.tulajdonosokTablaManager.getSelectedEntity();

        Gepjarmu gepjarmu = this.buildGepjarmu();

        Logger.info("mentés előtt: " + gepjarmu);
        this.gepjarmuDao.persist(gepjarmu);
        Logger.info("mentés után: " + gepjarmu);

        if(tulajdonos.getGepjarmuvek()!=null) {
            tulajdonos.getGepjarmuvek().add(gepjarmu);

            Logger.info("Nem nulla a gepjarmu listaja");



        }
        else {

            tulajdonos.setGepjarmuvek(new ArrayList<>());

            tulajdonos.getGepjarmuvek().add(gepjarmu);

        }

        this.gepjarmuTablaManager.setEntities(tulajdonos.getGepjarmuvek());

    }


    //rendben van.
    private Tulajdonos buildTulajdonos(){

        return new Tulajdonos(this.telefonszamTextField.getText(),this.nevTextField.getText(),
                this.lakcimTextField.getText() ,null);
    }

    // rendben van.
    // tulajdonos.setId(null); nem elfogadható megoldás
    public void ujTulajdonosPushed(){

        Tulajdonos tulajdonos = buildTulajdonos();
        //tulajdonos.setId(null);
        this.tulajdonosDao.persist(tulajdonos);
        this.tulajdonosokTablaManager.addEntity(tulajdonos);

    }



    // rendben van.
    public void tulajdonosTorlesePushed(){

        Tulajdonos tulajdonos = this.tulajdonosokTablaManager.getSelectedEntity();

        //this.tulajdonosDao.tulajdonosGepjarmuinekTorlese(tulajdonos);

        if(tulajdonos.getGepjarmuvek()!=null) {
            for (Gepjarmu gepjarmu : tulajdonos.getGepjarmuvek()) {

                this.gepjarmuDao.remove(this.gepjarmuDao.getById(gepjarmu.getId()));
            }
        }

        this.tulajdonosDao.remove(tulajdonos);

        this.gepjarmuTablaManager.setEntities(new ArrayList<>());

        this.setTulajdonosTablaMindenTulajdonossal();
    }

    public void gepjarmuMegtekintesePushed(){

    }

    public void ujGarancialisAlkatreszTipusPushed(){
        Stage secondaryStage = new Stage();

        try {


            Parent root = FXMLLoader.load(FXMLLoader.getDefaultClassLoader().getResource("UjGarancialisAlkatreszTipus.fxml"));
            secondaryStage.setTitle("Új garanciális alkatrész létrhozása");
            secondaryStage.setScene(new Scene(root, 1200, 900));
            secondaryStage.show();
        }catch (IOException e){

        }
        //URL url = Paths.get("src/main/java/view/TulajdonosokListaja.fxml").toUri().toURL();
        //Parent root = FXMLLoader.load(url);
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

    }

    public void ujGarancialisJavitasTipusPushed(){

    }

}