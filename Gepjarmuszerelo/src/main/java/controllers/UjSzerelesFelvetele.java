package controllers;

import daos.*;
import entities.Gepjarmu;
import entities.Gepjarmuparameter;
import entities.Szereles;
import entities.Ugyfel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import nezetek.TeljesGepjarmuNezet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UjSzerelesFelvetele extends GepjarmuszereloBasicController {

    private UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
    private GepjarmuDao gepjarmuDao= new GepjarmuDao(EntityManagerCreator.getEntityManager());
    private SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());
    private GepjarmuparameterDao gepjarmuparameterDao = new GepjarmuparameterDao(EntityManagerCreator.getEntityManager());

    //@FXML private TextField nevTextField;
    @FXML private TextField telefonszamTF;
    @FXML private TextField lakcimTF;
    @FXML private TextField nevTF;

    @FXML private TextField tipusTF;
    @FXML private TextField motorTerfogataTF;
    @FXML private TextField teljesitmenyTF;

    @FXML private TextField evjaratTF;
    @FXML private DatePicker vizsgaLejartaDP;
    @FXML private TextField alvazszamTF;

    @FXML private TableView<Ugyfel> ugyfelTV;
    @FXML private TableView<Gepjarmuparameter> gepjarmuparameterTV;
    @FXML private TableView<TeljesGepjarmuNezet> teljesGepjarmuTV;


    private TableManager<Ugyfel> ugyfelTM;
    private TableManager<Gepjarmuparameter> gepjarmuparameterTM;
    private TableManager<TeljesGepjarmuNezet> teljesGepjarmuNezetTM;


    //öröklött

   // @FXML private MenuBar menuBar;

    private Ugyfel ugyfel;
    private Gepjarmu gepjarmu;
    private Szereles szereles;
    private Gepjarmuparameter gepjarmuparameter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.ugyfelTM = new TableInjector<>(this.ugyfelTV);
        this.gepjarmuparameterTM = new TableInjector<>(this.gepjarmuparameterTV);
        this.teljesGepjarmuNezetTM = new TableInjector<>(this.teljesGepjarmuTV);


    }

    private Ugyfel ujUgyfelletrehozasa(){

        Ugyfel ugyfel =  new Ugyfel(this.nevTF.getText(), this.telefonszamTF.getText(),this.lakcimTF.getText());
        //this.ugyfel = ugyfel;

        return ugyfel;

    }

    private void ujUgyfelMentese(){

        Ugyfel ugyfel = this.ujUgyfelletrehozasa();

       //kivett persist
       // this.ugyfelDao.persist(ugyfel);
        this.ugyfel = ugyfel;

    }

    public void ujUgyfeletFelveszPushed(){

        Logger.info("asdf");
        if(!this.ugyfelTFekKitolteseHelyes()){
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Hiba történt");
         alert.setHeaderText("Az ügyfél mezők hibásan vannak kitöltve!");
         alert.setContentText("Tanács...");

         Logger.info("error");
         alert.showAndWait();
        }
        else {
            Logger.info("elseben");
            ujUgyfelMentese();
        }
    }
/* TODO string null  "" helyett */
    private boolean ugyfelTFekKitolteseHelyes() {
            return this.nevTF.getText()!=null && this.lakcimTF.getText()!=null && this.telefonszamTF.getText()!=null;
    }


    public void ujGepjarmuPushed(){

        if(this.gepjarmuparameter!=null) {
            this.gepjarmu = new Gepjarmu(this.gepjarmuparameter, Integer.parseInt(this.alvazszamTF.getText()),
                    this.vizsgaLejartaDP.getValue(), Integer.parseInt(this.evjaratTF.getText()));
        }
        else{

            this.nincsKivalasztottGepjarmuparameter();

        }


    }

    private void nincsKivalasztottGepjarmuparameter() {


    }

    /*TODO beletenni ezt a kódrészletet a dolgozatomba*/
    public void szerelesInditasaPushed(){

//        Logger.info(this.gepjarmu.toString());

        Logger.info(System.currentTimeMillis());
        if(this.vanRogzitettAdatSzerelesInditasahoz()){

            Logger.info("elinditom a szerelest");
            this.szerelesLetrehozasa();

        }
        else{
            this.nincsElegAdatASzerelesInditasahozHiba();
        }

        this.ujSzereleshezElokeszul();

    }

    private void nincsElegAdatASzerelesInditasahozHiba() {
        Logger.info("valami hiányzik");
    }

    private boolean vanRogzitettAdatSzerelesInditasahoz(){

        return this.gepjarmu!=null && this.ugyfel != null;

    }

    private void ujSzereleshezElokeszul() {

        this.regiSzerelesAdataitTorol();
        this.textFieldekTartalmatTorol();
        this.tablakTartalmatTorol();
    }

    private void tablakTartalmatTorol() {
        this.gepjarmuparameterTM.removeAll();
        this.teljesGepjarmuNezetTM.removeAll();
        this.ugyfelTM.removeAll();
    }

    private void textFieldekTartalmatTorol() {

        this.motorTerfogataTF.setText("");
        this.teljesitmenyTF.setText("");
        this.tipusTF.setText("");
        this.alvazszamTF.setText("");
        this.evjaratTF.setText("");
        this.vizsgaLejartaDP.setChronology(null);

        this.lakcimTF.setText("");
        this.nevTF.setText("");
        this.telefonszamTF.setText("");

    }

    private void regiSzerelesAdataitTorol() {

        this.gepjarmuparameter = null;
        this.gepjarmu = null;
        this.ugyfel = null;

    }

    private void szerelesLetrehozasa(){

        this.ugyfelDao.saveOrUpdate(this.ugyfel);
        this.gepjarmuparameterDao.saveOrUpdate(this.gepjarmuparameter);
        this.gepjarmuDao.saveOrUpdate(this.gepjarmu);



        Szereles szereles = new Szereles(this.gepjarmu,this.ugyfel);
        this.szerelesDao.persist(szereles);
        //this.szereles = szereles;

    }

    public void ugyfeltKeresPushed(){


        Logger.info(this.ugyfeletLetrehoz());
        this.ugyfelTM.setEntitasok(this.ugyfelDao.find(this.ugyfeletLetrehoz()));


    }



    private Ugyfel ugyfeletLetrehoz() {

        return new Ugyfel(this.nevTF.getText(),this.telefonszamTF.getText(),this.lakcimTF.getText());

    }

    public void ujGepjarmuparameterFelvetelPushed(){

        this.gepjarmuparameter = new Gepjarmuparameter(this.tipusTF.getText(),
                Integer.parseInt(this.motorTerfogataTF.getText()),Integer.parseInt(this.teljesitmenyTF.getText()));

    }


    public void gepjarmuParameterreKeresPushed(){
        Logger.info(this.gepjarmuvetLetrehoz());
        this.gepjarmuparameterTM.setEntitasok(this.gepjarmuparameterDao.find(this.gepjarmuparametertLetrehoz()));

    }

    private Gepjarmuparameter gepjarmuparametertLetrehoz() {
        return new Gepjarmuparameter(this.tipusTF.getText(),this.motorTerfogataTF.getText().equals("")?null:Integer.parseInt(this.motorTerfogataTF.getText()),
                this.teljesitmenyTF.getText().equals("")?null:Integer.parseInt(this.telefonszamTF.getText()));
    }

    public void gepjarmureKeresPushed(){


        this.teljesGepjarmuNezetTM.setEntitasok(TeljesGepjarmuNezet.of(this.gepjarmuDao.find(this.gepjarmuvetLetrehoz())));

    }

    private Gepjarmu gepjarmuvetLetrehoz() {

        return new Gepjarmu(null,!this.alvazszamTF.getText().equals("")?Integer.parseInt(this.alvazszamTF.getText()):null,this.vizsgaLejartaDP.getValue(),
                this.evjaratTF.getText().equals("")?null:Integer.parseInt(this.evjaratTF.getText()));

    }

    public void gepjarmuParametertKivalasztPushed(){
        this.gepjarmuparameter = this.gepjarmuparameterTM.getSelectedEntity();
        this.gepjarmuparameterTFekKitoltese();
    }

    private void gepjarmuparameterTFekKitoltese() {
        if(this.gepjarmuparameter!=null){
            this.tipusTF.setText(this.gepjarmuparameter.getTipus());
            this.motorTerfogataTF.setText(this.gepjarmuparameter.getMotorterfogat().toString());
            this.teljesitmenyTF.setText(this.gepjarmuparameter.getTeljesitmeny().toString());
        }
    }

    public void ugyfeletKivalasztPushed(){
        this.ugyfel = this.ugyfelTM.getSelectedEntity();
        this.ugyfelTFekKitoltese();
    }

    private void ugyfelTFekKitoltese() {
        if(this.ugyfel!= null){
            this.nevTF.setText(this.ugyfel.getNev());
            this.telefonszamTF.setText(this.ugyfel.getTelefonszam());
            this.lakcimTF.setText(this.ugyfel.getLakcim());
        }
    }


    public void gepjarmuvetKivalasztPushed(){
        //demeter törvényének megsértése
        this.gepjarmuparameter = this.teljesGepjarmuNezetTM.getSelectedEntity().getGepjarmu().getGepjarmuparameter();
        this.gepjarmu = this.teljesGepjarmuNezetTM.getSelectedEntity().getGepjarmu();
        this.gepjarmuparameterTFekKitoltese();
        this.gepjarmuTFekKitoltese();
    }

    private void gepjarmuTFekKitoltese() {
        if(this.gepjarmu!=null) {
            this.alvazszamTF.setText(this.gepjarmu.getAlvazszam().toString());
            this.evjaratTF.setText(this.gepjarmu.getEvjarat().toString());
            this.vizsgaLejartaDP.setValue(this.gepjarmu.getVizsgaLejarta());
        }
    }


}