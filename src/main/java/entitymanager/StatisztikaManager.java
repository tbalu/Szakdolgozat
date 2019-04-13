package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import org.pmw.tinylog.Logger;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.chrono.ChronoLocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatisztikaManager {
    private static StatisztikaManager instance = new StatisztikaManager();
    private StatisztikaManager(){}
    public static StatisztikaManager getInstance(){
        return instance;
    }

    //Teszt
    public Integer evesBevetel(int Ev){
        return DataStore.getBefejezetlenSzerelesek().stream().filter(c->c.getSzerelesBefejezese()
                .isAfter(LocalDate.of(Ev, Month.JANUARY,1))&&c.getSzerelesBefejezese()
                .isBefore(LocalDate.of(Ev, Month.DECEMBER,31))).map(Szereles::getMunkavegzesKoltsege).reduce((a,b)->a+b).get();
    }
    public Optional<Integer> eHaviBevetel(){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null).filter(c->c.getSzerelesBefejezese().getMonth()==LocalDate.now().getMonth()
                                                        &&c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear())
                                                        .map(Szereles::getMunkavegzesKoltsege)
                                                        .reduce((a,b)->a+b);
    }
    public Optional<Integer> ezEviBevetel(){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null).filter(c->c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear())
                                                    .map(Szereles::getMunkavegzesKoltsege).reduce((a,b)->a+b);
    }
    public Optional<Integer> maiBevetel(){
        /*Logger.info(DataStore.getSzerelesek().stream()
                .filter(c->c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear()
                        && c.getSzerelesBefejezese().getDayOfYear()==c.getSzerelesBefejezese().getDayOfYear()).collect(Collectors.toList()));*/
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null)
                .filter(c->c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear()
                && c.getSzerelesBefejezese().getDayOfYear()==LocalDate.now().getDayOfYear())
                .map(Szereles::getMunkavegzesKoltsege).reduce((a,b) ->a+b);
    }
}
