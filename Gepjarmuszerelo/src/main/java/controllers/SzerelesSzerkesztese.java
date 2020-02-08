package controllers;

import daos.*;
import entities.*;
import filters.JavitasTipusFilter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nezetek.FelhasznaltAlkatreszekNezet;
import nezetek.JavitasTipusNezet;
import nezetek.JavitasokNezet;
import org.pmw.tinylog.Logger;
import utils.TableInjector;
import utils.TableManager;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SzerelesSzerkesztese extends BasicControllerWithInitData implements Initializable {


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
    @FXML private TextField fixArTF;

    @FXML private TableView felhasznaltAlkatreszekTV;
    @FXML private TextField nevTF;
    @FXML private TextField arTF;
    @FXML private TextField felhasznaltAlkatreszgaranciaIdotartamaTF;
    @FXML private TextField cikkszamTF;

    @FXML private TableView<JavitasTipusNezet> javitasTipusokTV;

    private TableManager<FelhasznaltAlkatreszekNezet> felahasznaltAlkatreszekTM;
    private TableManager<JavitasokNezet> javitasokTM ;
    private TableManager<JavitasTipusNezet> javitasTipusTM;

    private OradijasJavitasTipus kivalasztottJavitasTipus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.felahasznaltAlkatreszekTM = new TableInjector<>(this.felhasznaltAlkatreszekTV);
        this.javitasokTM = new TableInjector<>(this.javitasokTV);
        this.javitasTipusTM = new TableInjector<>(this.javitasTipusokTV);

    }


    @Override
    public void initData(Object o) {
        Szereles szereles = (Szereles)o;
        this.szereles = szereles;

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

    //Itt van a régi javitastHozzaad().
    /*
    public void javitastHozzaad(){

        OradijasJavitas oradijasJavitas = ujOradijasJavitasMentese(this.ujOradijasJavitasTipusMentese());
        this.javitasokTM.addEntity(JavitasokNezet.of(oradijasJavitas));

    }
*/

    private void hozzaadhatJavitast(){

        if(this.kivalasztottJavitasTipus instanceof FixAruJavitasTipus){
            FixAruJavitas fixaruJavitas =
                    this.ujFixaruJavitasTipusMentese((FixAruJavitasTipus)this.kivalasztottJavitasTipus);
            this.javitasokTM.addEntity(JavitasokNezet.of(fixaruJavitas));

        }
        else if(this.kivalasztottJavitasTipus instanceof OradijasJavitasTipus){
            OradijasJavitas oradijasJavitas= this.ujOradijasJavitasMentese(this.kivalasztottJavitasTipus);
            this.javitasokTM.addEntity(JavitasokNezet.of(oradijasJavitas));
        }


    }

    public void javitastHozzaad(){

        if(this.kivalasztottJavitasTipus!=null){

         this.hozzaadhatJavitast();

        }else{
            this.nincsKivalasztottjavitasTipusFigyelmeztetes();
        }

    }

    private FixAruJavitas ujFixaruJavitasTipusMentese(FixAruJavitasTipus kivalasztottJavitasTipus) {

        FixAruJavitas fixAruJavitas =
                new FixAruJavitas(this.szereles,kivalasztottJavitasTipus);

        this.javitasDao.persist(fixAruJavitas);
        return fixAruJavitas;

    }

    private void nincsKivalasztottjavitasTipusFigyelmeztetes() {
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
        javitas.getFelhasznaltAlkatreszek().add(felhasznaltAlkatresz);
        this.javitasDao.update(javitas);

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


    public void javitasTipustKeres(){
        JavitasTipusFilter javitasTipusFilter = this.javitasTipusFilterLetrehozasa();


        List javitasTipusok;

        if(javitasTipusFilter.getFixar()==null) {
                        javitasTipusok = this.javitasTipusDao.findOradijasJavitasTipus(javitasTipusFilter);
        }else{
            javitasTipusok = this.javitasTipusDao.findFixaruJavitasTipusok(javitasTipusFilter);

        }

        javitasTipusok.addAll(javitasTipusok);
        this.javitasTipusTM.setEntitasok(JavitasTipusNezet.of(javitasTipusok));

    }

    public JavitasTipusFilter javitasTipusFilterLetrehozasa(){

        JavitasTipusFilter javitasTipusFilter = new JavitasTipusFilter();
        javitasTipusFilter.setId(null);
        javitasTipusFilter.setLeiras(this.leirasTA.getText());
        String fixar = this.fixArTF.getText();
        String garanciaIdotartama = this.javitasGaranciaIdotartamaTF.getText();
        Logger.info(fixar + "  -----  " + garanciaIdotartama);
        if(!fixar.equals("")){
            javitasTipusFilter.setFixar(Integer.parseInt(fixar));
        }

        if(!garanciaIdotartama.equals("")){
            javitasTipusFilter.setGaranciIdotartama(Integer.parseInt(garanciaIdotartama));
        }

        return javitasTipusFilter;
    }

    public void javitasTipustValaszt(){

        OradijasJavitasTipus oradijasJavitasTipus =  this.javitasTipusDao.getById(this.javitasTipusTM.getSelectedEntity().getId());
        this.leirasTA.setText(oradijasJavitasTipus.getLeiras());
        if(oradijasJavitasTipus instanceof FixAruJavitasTipus){
            this.fixArTF.setText(((FixAruJavitasTipus) oradijasJavitasTipus).getAr().toString());
        }
        this.javitasGaranciaIdotartamaTF.setText(oradijasJavitasTipus.getGaranciaIdotartama()!=null ?
                oradijasJavitasTipus.getGaranciaIdotartama().toString(): "");

        this.kivalasztottJavitasTipus = oradijasJavitasTipus;
    }

}
