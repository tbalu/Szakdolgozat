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
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nezetek.TeljesGepjarmuNezet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UjSzerelesFelvetele extends BasicController implements Initializable {

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

        ujUgyfelMentese();

    }


    public void ujGepjarmuPushed(){

//        Gepjarmu gepjarmu = new Gepjarmu(this.tipusTF.getText(),Integer.parseInt(this.motorTerfogataTF.getText()),Integer.parseInt(this.teljesitmenyTF.getText()),this.vizsgaLejartaDP.getValue(),Integer.parseInt(this.evjaratTF.getText()));

        if(this.gepjarmuparameter!=null) {
            this.gepjarmu = new Gepjarmu(this.gepjarmuparameter, Integer.parseInt(this.alvazszamTF.getText()),
                    this.vizsgaLejartaDP.getValue(), Integer.parseInt(this.evjaratTF.getText()));
        }
        else{

            this.nincsKivalasztottGepjarmuparameter();

        }



        //      this.gepjarmuDao.persist(gepjarmu);
    //    this.gepjarmu = gepjarmu;


    }

    private void nincsKivalasztottGepjarmuparameter() {


    }

    public void szerelesInditasaPushed(){

        Logger.info(this.gepjarmu.toString());

        if(this.gepjarmu!=null && this.ugyfel != null){

            Logger.info("elinditom a szerelest");
            this.szerelesLetrehozasa();

        }

        this.ujSzereleshezElokeszul();

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

        //SessionFactory sessionFactory;
        //session.saveOrUpdate(new Object());

        //this.gepjarmuparameterDao.saveOrUpdate(this.gepjarmu.getGepjarmuparameter());
        //this.gepjarmuDao.saveOrUpdate(this.gepjarmu);
        //this.ugyfelDao.saveOrUpdate(this.ugyfel);
        this.gepjarmuparameterDao.saveOrUpdate(this.gepjarmuparameter);
        this.gepjarmuDao.saveOrUpdate(this.gepjarmu);
        this.ugyfelDao.saveOrUpdate(this.ugyfel);

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
    }

    public void ugyfeletKivalasztPushed(){
        this.ugyfel = this.ugyfelTM.getSelectedEntity();
    }

    public void gepjarmuvetKivalasztPushed(){
        this.gepjarmuparameter = this.teljesGepjarmuNezetTM.getSelectedEntity().getGepjarmu().getGepjarmuparameter();
        this.gepjarmu = this.teljesGepjarmuNezetTM.getSelectedEntity().getGepjarmu();
    }


}