package controllers;

import daos.*;
import entities.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nezetek.FelhasznaltAlkatreszekNezet;
import nezetek.JavitasokNezet;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SzerelesSzerkesztese extends BasicController implements Initializable {


    private Szereles szereles;

    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());

    private OradijasJavitasTipusDao oradijasJavitasTipusDao = new OradijasJavitasTipusDao(EntityManagerCreator.getEntityManager());
    private JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
    private JavitasTipusDao javitasTipusDao = new JavitasTipusDao(EntityManagerCreator.getEntityManager());

    private AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
    private FelhasznaltAlkatreszDao felhasznaltAlkatreszDao = new FelhasznaltAlkatreszDao(EntityManagerCreator.getEntityManager());

    @FXML private TableView javitasokTV;
    @FXML private TextArea leirasTA;
    @FXML private TextField munkaorakSzamaTF;
    @FXML private TextField javitasGaranciaIdotartamaTF;

    @FXML private TableView felhasznaltAlkatreszekTV;
    @FXML private TextField nevTF;
    @FXML private TextField arTF;
    @FXML private TextField felhasznaltAlkatreszgaranciaIdotartamaTF;
    @FXML private TextField cikkszamTF;

    private TableManager<FelhasznaltAlkatreszekNezet> felahasznaltAlkatreszekTM;
    private TableManager<JavitasokNezet> javitasokTM ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.felahasznaltAlkatreszekTM = new TableInjector<>(this.felhasznaltAlkatreszekTV);
        this.javitasokTM = new TableInjector<>(this.javitasokTV);

       // Logger.info(this.szerelesDao.getById(12).getSzerelesKezdete());

        List<Object> idk = new ArrayList<>();
        /*idk.add(19);
       // idk.add(20);
        this.felhasznaltAlkatreszDao.removeAll(idk);*/
    }


    public void intiData(Szereles szereles){

        this.szereles = szereles;
        Logger.info("szereles id" + this.szereles.getId());
        this.javitasokTM.setEntitasok(JavitasokNezet.of(this.javitasDao.findAll(this.szereles.getJavitasokIdk())));

    }

    private OradijasJavitasTipus ujOradijasJavitasTipusMentese(){
        OradijasJavitasTipus oradijasJavitasTipus =
                new OradijasJavitasTipus(this.leirasTA.getText(),Integer.parseInt(this.javitasGaranciaIdotartamaTF.getText()));
        oradijasJavitasTipusDao.persist(oradijasJavitasTipus);
        return oradijasJavitasTipus;

    }

    private OradijasJavitas ujOradijasJavitasMentese(OradijasJavitasTipus oradijasJavitasTipus){

        OradijasJavitas oradijasJavitas =
                new OradijasJavitas(this.szereles,oradijasJavitasTipus,Integer.parseInt(this.munkaorakSzamaTF.getText()));

            this.javitasDao.persist(oradijasJavitas);
            return oradijasJavitas;
    }

    public void javitastHozzaad(){

        OradijasJavitas oradijasJavitas = ujOradijasJavitasMentese(this.ujOradijasJavitasTipusMentese());
        this.javitasokTM.addEntity(JavitasokNezet.of(oradijasJavitas));

    }


    public Alkatresz ujAlkatreszMentese(){

        Alkatresz alkatresz = new Alkatresz(this.nevTF.getText(), Integer.parseInt(this.arTF.getText()),
                Integer.parseInt(this.felhasznaltAlkatreszgaranciaIdotartamaTF.getText()));

        this.alkatreszDao.persist(alkatresz);
        return alkatresz;
    }

    public FelhasznaltAlkatresz felhasznaltAlkatresztHozzaad(Alkatresz alkatresz, Javitas javitas){

        FelhasznaltAlkatresz felhasznaltAlkatresz = new FelhasznaltAlkatresz(Integer.parseInt(this.cikkszamTF.getText()),alkatresz,javitas);

        this.felhasznaltAlkatreszDao.persist(felhasznaltAlkatresz);
        return felhasznaltAlkatresz;
    }

    public void alkatresztHozzaad(){

        Alkatresz alkatresz = ujAlkatreszMentese();

        Javitas javitas = this.javitasDao.getById( this.javitasokTM.getSelectedEntity().getId());

        FelhasznaltAlkatresz felhasznaltAlkatresz = this.felhasznaltAlkatresztHozzaad(alkatresz,javitas);
        this.felahasznaltAlkatreszekTM.addEntity(new FelhasznaltAlkatreszekNezet(felhasznaltAlkatresz));


    }

    public void felhasznaltAlkatreszeinekMegjelenitese(){

        Javitas javitas = this.javitasDao.getById(this.javitasokTM.getSelectedEntity().getId());
        Logger.info(javitas.getId());
        Logger.info(javitas.getFelhasznaltAlkatreszek().size());
        this.felahasznaltAlkatreszekTM.setEntitasok(FelhasznaltAlkatreszekNezet.of(javitas.getFelhasznaltAlkatreszek()));

    }

    public void  javitasTorlese(){

        Javitas javitas =  this.javitasDao.getById(this.javitasokTM.getSelectedEntity().getId());
        Logger.info("felhasznalt alkatreszek idei"+javitas.getFelhasznaltAlkatreszekIdei());
        Logger.info("19es: " + felhasznaltAlkatreszDao.getById(20));
        //this.felhasznaltAlkatreszDao.removeAll(javitas.getFelhasznaltAlkatreszekIdei());

        /*for(FelhasznaltAlkatresz felhasznaltAlkatresz: javitas.getFelhasznaltAlkatreszek()){

            this.felhasznaltAlkatreszDao.remove(felhasznaltAlkatresz);

        }*/

        this.javitasDao.remove(javitas);
        this.javitasokTM.removeSelectedEntity();
        this.javitasokTM.rerfreshTable();
        this.felahasznaltAlkatreszekTM.removeAll();
    }

    public void alkatreszTorlese(){
        Logger.info("alkatresz torlese");
        Logger.info(this.felahasznaltAlkatreszekTM.getSelectedEntity().getId());
        Logger.info("az alkatresz:" +this.alkatreszDao.getById(this.felahasznaltAlkatreszekTM.getSelectedEntity().getId()));

        this.felhasznaltAlkatreszDao.remove(this.felhasznaltAlkatreszDao.getById(this.felahasznaltAlkatreszekTM.getSelectedEntity().getId()));
        this.felahasznaltAlkatreszekTM.removeSelectedEntity();
        this.felahasznaltAlkatreszekTM.rerfreshTable();
    }

}
