package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import entities.SzerelesBefejezese;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.pmw.tinylog.Logger;

import java.time.LocalDate;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class SzerelesManager {
    private static SzerelesManager instance = new SzerelesManager();
    private SzerelesManager(){}
    public static SzerelesManager getInstance(){
        return instance;
    }

    public void addSzerelesekhez(String Rendszam,String Jogositvanyszam){
        ListIterator<Szereles> listIterator = DataStore.getSzerelesek().listIterator();
        while(listIterator.hasNext()){
            Szereles szereles = listIterator.next();
            if(szereles.getRendszam().equals(Rendszam)&&szereles.getSzerelesKezdete().equals(LocalDate.now())){
                Logger.info("Már van ilyen szerelesunk");
                return;
            }
        }
        DataStore.getSzerelesek().add(this.createSzereles(Rendszam));
        Logger.info(DataStore.getSzerelesek().toString());
    }
    //Teszt
    public Szereles createSzereles(String Rendszam){
        Szereles szereles = new Szereles();
        szereles.setRendszam(Rendszam);
        szereles.setSzerelesKezdete(LocalDate.now());

        Logger.info(szereles.toString());
        return szereles;
    }

        //Teszt
    public Szereles szerelesBefejezese(SzerelesBefejezese szereles, Integer MunkavegzesKoltsege) {
        int index = DataStore.getSzerelesek().indexOf(szereles);
        szereles.setSzerelesBefejezese(LocalDate.now());
        szereles.setMunkavegzesKoltsege(MunkavegzesKoltsege);
        DataStore.getSzerelesek().set(index, (Szereles) szereles);
        return (Szereles) szereles;
    }
    //Teszt
    public ObservableList<Szereles> getBefejezettSzerelesek(){
        return FXCollections.observableArrayList(DataStore.Szerelesek.stream()
                                .filter(c->c.getSzerelesBefejezese()!=null).collect(Collectors.toList()));
    }
}
