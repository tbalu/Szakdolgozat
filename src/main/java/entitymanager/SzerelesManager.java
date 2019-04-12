package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import entities.SzerelesBefejezese;

import java.time.LocalDate;

public class SzerelesManager {
    private static SzerelesManager instance = new SzerelesManager();
    private SzerelesManager(){}
    public static SzerelesManager getInstance(){
        return instance;
    }
    public Szereles createSzereles(LocalDate SzerelesKezdete,LocalDate SzerelesBefejezese,
                                   String Rendszam, String Jogositvanyszam){
        Szereles szereles = new Szereles();
        szereles.setRendszam(Rendszam);
        szereles.setSzerelesMegkezdese(LocalDate.now());
        szereles.setJogositvanyszam(Jogositvanyszam);
        return szereles;
    }

        //Teszt
    public Szereles szerelesBefejezese(SzerelesBefejezese szereles, Integer MunkavegzesKoltsege) {
        int index = DataStore.getSzerelesek().indexOf(szereles);
        szereles.setBefejezesIdeje(LocalDate.now());
        szereles.setMunkavegzesKoltsege(MunkavegzesKoltsege);
        DataStore.getSzerelesek().set(index, (Szereles) szereles);
        return (Szereles) szereles;
    }
}
