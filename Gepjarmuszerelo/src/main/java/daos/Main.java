package daos;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static EntityManager em;

    public static void main(String[] args) throws SQLIntegrityConstraintViolationException {

        //elso();
        //szerelesekLetrehozasa();
        tulajdonosGepjarmuvek();





    }

    public static void tulajdonosGepjarmuvek(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();
        //Daok létrehozása
        TulajdonosDao tulajdonosDao = new TulajdonosDao(em);
        GepjarmuDao gepjarmuDao = new GepjarmuDao(em);
        Tulajdonos t = new Tulajdonos("Tóth Balázs","Debrecen","1234");
        Gepjarmu g1 = new Gepjarmu("1","Tesla",null,t);
        Gepjarmu g2 = new Gepjarmu("2","Tesla",null,t);
        Gepjarmu g3 = new Gepjarmu("3","Tesla",null,t);

        // gepjarmuSet feltoltese
        Set<Gepjarmu> gepjarmuSet = new HashSet<Gepjarmu>();
        gepjarmuSet.add(g1);
        gepjarmuSet.add(g2);
        gepjarmuSet.add(g3);

        t.setGepjarmuvek(gepjarmuSet);

        tulajdonosDao.ment(t);
    }

    public static void elso(){
        // EntityManager létrehozása
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        //Daok létrehozása
        TulajdonosDao tulajdonosDao = new TulajdonosDao(em);
        GepjarmuDao gepjarmuDao = new GepjarmuDao(em);
        SzerelesDao szerelesDao = new SzerelesDao(em);

        Tulajdonos t = new Tulajdonos("Tóth Balázs","Debrecen","1234");
        Gepjarmu g1 = new Gepjarmu("1","Tesla",null,t);
        Gepjarmu g2 = new Gepjarmu("2","Tesla",null,t);
        Gepjarmu g3 = new Gepjarmu("3","Tesla",null,t);

        // gepjarmuSet feltoltese
        Set<Gepjarmu> gepjarmuSet = new HashSet<Gepjarmu>();
        gepjarmuSet.add(g1);
        gepjarmuSet.add(g2);
        gepjarmuSet.add(g3);

        t.setGepjarmuvek(gepjarmuSet);

        Gepjarmu gg= gepjarmuDao.getByRendszam("1");

        Szereles sz1 = new Szereles(gg, LocalDate.now(),null,12);
        Szereles sz2 = new Szereles(gepjarmuDao.getByRendszam("2"),LocalDate.now(),LocalDate.now(),null);
        //gg.getSzerelesek().add(sz1);
        //gepjarmuDao.update(gg);
        szerelesDao.persist(sz1);
        szerelesDao.persist(sz2);

        Set<Szereles> szerelesSet = new HashSet<>();
        szerelesSet.add(sz1);

        tulajdonosDao.ment(t);
        System.out.println(szerelesDao.befejezetlenSzerelesek());

        Gepjarmu g4 = new Gepjarmu("ASD-000","BMW",null,t);
        Gepjarmu g5 = new Gepjarmu("ASD-010","BMW",null,t);

    }


    public static void szerelesekLetrehozasa(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        //Daok létrehozása
        TulajdonosDao tulajdonosDao = new TulajdonosDao(em);
        GepjarmuDao gepjarmuDao = new GepjarmuDao(em);
        SzerelesDao szerelesDao = new SzerelesDao(em);
        //Egyedek letrehozasa
        Gepjarmu gepjarmu = gepjarmuDao.getByRendszam("1");
        Szereles szereles = new Szereles(gepjarmu,LocalDate.now(),LocalDate.now(),null);
        Alkatresz alkatresz = new Alkatresz("Fluxus kondenzátor",1000000);
        SzereleshezHasznaltAlkatresz szereleshezHasznaltAlkatresz =
                new SzereleshezHasznaltAlkatresz(szereles,alkatresz,1, alkatresz.getAr());

        szerelesDao.persist(szereles);
        em.getTransaction().begin();
        em.persist(alkatresz);
        em.persist(szereleshezHasznaltAlkatresz);
        em.getTransaction().commit();

    }



}