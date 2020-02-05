package test;

import daos.*;
import entities.*;

import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static void setUp(){

        EntityManagerCreator.emf = Persistence.createEntityManagerFactory("test");

    }


    public static void teljesTeszt(){
        //Dao-k
        TulajdonosDao tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());
        UgyfelDao ugyfelDao = new UgyfelDao(EntityManagerCreator.getEntityManager());
        GepjarmuDao gepjarmuDao = new GepjarmuDao(EntityManagerCreator.getEntityManager());
        SzereloDao szereloDao = new SzereloDao(EntityManagerCreator.getEntityManager());
        SzerelesDao szerelesDao = new SzerelesDao(EntityManagerCreator.getEntityManager());
        AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao = new GarancialisAlkatreszTipusDao(EntityManagerCreator.getEntityManager());
        EladottAlkatreszDao eladottAlkatreszDao = new EladottAlkatreszDao(EntityManagerCreator.getEntityManager());
        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());

        //Tulajdonos tulajdonos = new Tulajdonos("asdf","asdfg","asdfg");
        //Entitasok létrehozása


        Ugyfel ugyfel = new Ugyfel("+36 ...","Tóth Balázs","Debrecen");
        Gepjarmu gepjarmu = gepjarmuDao.getById(303);
        //Gepjarmu gepjarmu = new Gepjarmu("Tesla",1000,100, LocalDate.of(2020,02,26),2000,null,new ArrayList<>());
        Szereles szereles = new Szereles(new Timestamp(System.currentTimeMillis()-100000),new Timestamp(System.currentTimeMillis()),gepjarmu,ugyfel,20000);

        OsJavitas javitas = new GarancialisJavitas("abc",12000,12);
        javitas.setSzereles(szereles);
        OsAlkatresz alkatresz = new Alkatresz("fluxus kondenzátor", 200000);
        szereles.getJavitasok().add(javitas);
        EladottAlkatresz eladottAlkatresz = new EladottAlkatresz(1234,alkatresz,javitas);
        javitas.getEladottAlkatreszek().add(eladottAlkatresz);

       // ugyfelDao.persist(ugyfel);
       // gepjarmuDao.persist(gepjarmu);

        //gepjarmuDao.update(gepjarmu);
        alkatreszDao.persist(alkatresz);
        szerelesDao.persist(szereles);
        //javitasDao.persist(javitas);
        //eladottAlkatreszDao.persist(eladottAlkatresz);



        //tulajdonos.getGepjarmuvek().add()


    }


    public static void main(String[] args){

    setUp();
    teljesTeszt();
    }

    public static void teljesAlkatreszteszt(){

        AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
        EladottAlkatreszDao eladottAlkatreszDao = new EladottAlkatreszDao(EntityManagerCreator.getEntityManager());
        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao = new GarancialisAlkatreszTipusDao(EntityManagerCreator.getEntityManager());


        OsJavitas javitas = new Javitas("xyz",12000);

        OsAlkatresz alkatresz = new Alkatresz("fluxus kondenzátor",2234);

        EladottAlkatresz eladottAlkatresz = new EladottAlkatresz(1234,alkatresz,javitas);

        javitasDao.persist(javitas);

        alkatreszDao.persist(alkatresz);

        eladottAlkatreszDao.persist(eladottAlkatresz);

        eladottAlkatreszDao.persist(eladottAlkatresz);

    }

    /*public static void alkatreszteszt3(){

        AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao = new GarancialisAlkatreszTipusDao(EntityManagerCreator.getEntityManager());

        OsJavitas javitas = new Javitas("xyz",12000);
        OsJavitas garancialisJavitas = new GarancialisJavitas("cba",200000,36);

        GarancialisAlkatreszTipus garancialisAlkatreszTipus = garancialisAlkatreszTipusDao.getById(1);
        OsAlkatresz alkatresz = new GarancialisAlkatresz("fluxus kondenzátor",2234,200000,garancialisJavitas,garancialisAlkatreszTipus);


        javitasDao.persist(garancialisJavitas);
        javitasDao.persist(javitas);
        alkatreszDao.persist(alkatresz);



    }*/
/*
    public static void alkatreszteszt2(){

        AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        OsJavitas javitas = new Javitas("xyz",12000);
        OsJavitas garancialisJavitas = new GarancialisJavitas("cba",200000,36);
        OsAlkatresz alkatresz = new Alkatresz("fluxus kondenzátor",2234,200000,javitas);

        javitasDao.persist(garancialisJavitas);
        javitasDao.persist(javitas);
        alkatreszDao.persist(alkatresz);


    }*/

    public static void javitasteszt2(){

        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        OsJavitas javitas = new Javitas("xyz",12000);
        OsJavitas garancialisJavitas = new GarancialisJavitas("cba",200000,36);

        javitasDao.persist(garancialisJavitas);
        javitasDao.persist(javitas);

    }


    /*public static void alkatreszteszt1() {

        GarancialisAlkatreszDao garancialisAlkatreszDao = new GarancialisAlkatreszDao(EntityManagerCreator.emf.createEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao =
                new GarancialisAlkatreszTipusDao(EntityManagerCreator.emf.createEntityManager());

        GarancialisAlkatreszTipus garancialisAlkatreszTipus = garancialisAlkatreszTipusDao.getById(1);

        GarancialisAlkatresz garancialisAlkatresz = new GarancialisAlkatresz(garancialisAlkatreszTipus,10000,1235);

        garancialisAlkatreszTipusDao.persist(garancialisAlkatreszTipus);
        garancialisAlkatreszDao.persist(garancialisAlkatresz);

    }*/

}
