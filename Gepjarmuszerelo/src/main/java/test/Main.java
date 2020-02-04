package test;

import daos.*;
import entities.*;

import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    private static void setUp(){
        EntityManagerCreator.emf = Persistence.createEntityManagerFactory("test");

    }

    public static void main(String[] args){

    setUp();
    teljesAlkatreszteszt();
    }

    public static void teljesAlkatreszteszt(){

        AlkatreszDao alkatreszDao = new AlkatreszDao(EntityManagerCreator.getEntityManager());
        EladottAlkatreszDao eladottAlkatreszDao = new EladottAlkatreszDao(EntityManagerCreator.getEntityManager());
        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao = new GarancialisAlkatreszTipusDao(EntityManagerCreator.getEntityManager());


        OsJavitas javitas = new Javitas("xyz",12000);

        OsAlkatresz alkatresz = new Alkatresz("fluxus kondenzátor",2234,new ArrayList<>());

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
