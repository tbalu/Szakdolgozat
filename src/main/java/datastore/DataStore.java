package datastore;

import entities.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.pmw.tinylog.Logger;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStore {
        /*public static List<Tulajdonos> Tulajdonosok = new ArrayList<Tulajdonos>();
        public static List<Gepjarmu> Gepjarmuvek = new ArrayList<Gepjarmu>();
        public static List<Szereles> Szerelesek = new ArrayList<Szereles>();
        */
        public static ObservableList<Tulajdonos> Tulajdonosok = FXCollections.observableArrayList();
        public static ObservableList<Gepjarmu> Gepjarmuvek = FXCollections.observableArrayList();
        public static ObservableList<Szereles> Szerelesek = FXCollections.observableArrayList();
        public static ObservableList<BefejezendoSzereles> BefejezendoSzerelesek = FXCollections.observableArrayList();
        public static ObservableList<Szereles2> Szerelesek2 = FXCollections.observableArrayList();

    public static void loadTulajdonosok(){
            /* TODO */
            Tulajdonosok.add(new Tulajdonos("Tóth Balázs","Debrecen, Nagycsere tanya HRSZ.:02147/5","123"));
            Logger.info(Tulajdonosok.toString());
        }
        public static void loadGepjarmuvek(){
        /* TODO */
            //Gepjarmuvek.add(new Gepjarmu("Tesla Model S","ABC-123","123"));
            Logger.info(Gepjarmuvek.toString());
        }
        public static void loadSzerelesek(){
        /* TODO */
            Szerelesek.add(new Szereles("ABC-123",LocalDate.of(2019, Month.APRIL,5)));
            Szerelesek.add(new Szereles("ABC-123",LocalDate.of(2019, Month.APRIL,6)
                    ,LocalDate.of(2019, Month.APRIL,6),11,null));
            Logger.info(Szerelesek.toString());
        }
        public static void loadSzerelesek2(){
        /* TODO */
        Szerelesek2.add(new Szereles2(new SimpleStringProperty("ABC-123"),  LocalDate.of(2019, Month.APRIL,5)));
        Logger.info(Szerelesek2.toString());
        }
        public static void loadBefejezendoSzerelesek(){
            BefejezendoSzerelesek.add(new BefejezendoSzereles("ABC-123",LocalDate.of(2019,Month.APRIL,4)));
        }

    public static List<Tulajdonos> getTulajdonosok() {
        return Tulajdonosok;
    }

    public static List<Gepjarmu> getGepjarmuvek() {
        return getTulajdonosok().stream().flatMap(c->c.getGepjarmuvek().stream()).collect(Collectors.toList());
    }

    public static List<Szereles> getSzerelesek() {
        return getGepjarmuvek().stream().flatMap(c->c.getSzerelesek().stream()).collect(Collectors.toList());
    }

    //Teszt
    public static ObservableList<Szereles> getBefejezetlenSzerelesek(){
            return FXCollections.observableArrayList(DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()==null)
                    .collect(Collectors.toList()));
    }
    public static List<Szereles> getBefejezettSzerelesek(){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null)
                .collect(Collectors.toList());
    }

}