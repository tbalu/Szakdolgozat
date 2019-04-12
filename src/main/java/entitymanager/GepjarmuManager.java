package entitymanager;

import datastore.DataStore;
import entities.Gepjarmu;

public class GepjarmuManager {
    private static GepjarmuManager instance = new GepjarmuManager();
    private GepjarmuManager(){}
    public static GepjarmuManager getInstance(){
        return instance;
    }

    /*public Gepjarmu createGepjarmu(String Marka,String Rendszam){
        return new Gepjarmu(Marka,Rendszam);
    }*/
    public Gepjarmu addGepjarmuvekhez(String Marka,String Rendszam){
        Gepjarmu gepjarmu = new Gepjarmu(Marka,Rendszam);
        DataStore.getGepjarmuvek().add(gepjarmu);
        return gepjarmu;
    }
}
