package entitymanager;

import datastore.DataStore;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.ListIterator;

public class GepjarmuManager {
    private static GepjarmuManager instance = new GepjarmuManager();
    private GepjarmuManager(){}
    public static GepjarmuManager getInstance(){
        return instance;
    }

    /*public Gepjarmu createGepjarmu(String Marka,String Rendszam){
        return new Gepjarmu(Marka,Rendszam);
    }*/

    public void addGepjarmuvekhez(String Marka,String Rendszam,String TulajdonosJogositvanyszama) {

       /* DataStore.getTulajdonosok().stream().filter(c -> c.getJogositvanyszam() == TulajdonosJogositvanyszama)
                .findFirst().ifPresent(c -> c.getGepjarmuvek().add(new Gepjarmu(Rendszam, Marka, new ArrayList<Szereles>(), TulajdonosJogositvanyszama)));
    */}/*
        ListIterator<Gepjarmu> listIterator = DataStore.Gepjarmuvek.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getRendszam().equals(Rendszam)){
                Logger.info("Már van ilyen rendszamu kocsi");
                return;
            }
        }*/
        /*
    public void addGepjarmuvekhez(String Marka,String Rendszam,String TulajdonosJogositvanyszama){
        ListIterator<Gepjarmu> listIterator = DataStore.Gepjarmuvek.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getRendszam().equals(Rendszam)){
                Logger.info("Már van ilyen rendszamu kocsi");
               return;
            }
        }*/
      /*  Gepjarmu gepjarmu = new Gepjarmu(Marka,Rendszam, TulajdonosJogositvanyszama);

        DataStore.getGepjarmuvek().add(gepjarmu);
        Logger.info(DataStore.getGepjarmuvek().toString());

    }*/
}
