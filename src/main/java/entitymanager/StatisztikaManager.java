package entitymanager;

import datastore.DataStore;
import entities.Szereles;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.chrono.ChronoLocalDate;

public class StatisztikaManager {
    private static StatisztikaManager instance = new StatisztikaManager();
    private StatisztikaManager(){}
    public static StatisztikaManager getInstance(){
        return instance;
    }

    //Teszt
    public Integer evesBevetel(int Ev){
        return DataStore.getBefejezetlenSzerelesek().stream().filter(c->c.getBefejezesIdeje()
                .isAfter(LocalDate.of(Ev, Month.JANUARY,1))&&c.getBefejezesIdeje()
                .isAfter(LocalDate.of(Ev, Month.DECEMBER,31))).map(Szereles::getMunkavegzesKoltsege).reduce((a,b)->a+b).get();
    }
}
