package test;

import daos.*;
import entities.GarancialisAlkatresz;
import entities.GarancialisAlkatreszTipus;
import entities.GarancialisJavitas;
import entities.Javitas;

import javax.persistence.Persistence;

public class Main {

    private static void setUp(){
        EntityManagerCreator.emf = Persistence.createEntityManagerFactory("test");

    }

    public static void main(String[] args){

    setUp();
    javitasteszt2();
    }

    public static void javitasteszt2(){

        JavitasDao javitasDao = new JavitasDao(EntityManagerCreator.getEntityManager());
        Javitas javitas = new Javitas("xyz",12000);
        GarancialisJavitas garancialisJavitas = new GarancialisJavitas("cba",200000,36);

        javitasDao.persist(garancialisJavitas);
        javitasDao.persist(javitas);

    }


    public static void alkatresztesz() {

        GarancialisAlkatreszDao garancialisAlkatreszDao = new GarancialisAlkatreszDao(EntityManagerCreator.emf.createEntityManager());
        GarancialisAlkatreszTipusDao garancialisAlkatreszTipusDao =
                new GarancialisAlkatreszTipusDao(EntityManagerCreator.emf.createEntityManager());

        GarancialisAlkatreszTipus garancialisAlkatreszTipus = garancialisAlkatreszTipusDao.getById(1);

        GarancialisAlkatresz garancialisAlkatresz = new GarancialisAlkatresz(garancialisAlkatreszTipus,10000,1235);

        garancialisAlkatreszTipusDao.persist(garancialisAlkatreszTipus);
        garancialisAlkatreszDao.persist(garancialisAlkatresz);

    }

}
