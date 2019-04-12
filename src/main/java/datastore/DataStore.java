package datastore;

import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStore {
        public static List<Tulajdonos> Tulajdonosok = new ArrayList<Tulajdonos>();
        public static List<Gepjarmu> Gepjarmuvek = new ArrayList<Gepjarmu>();
        public static List<Szereles> Szerelesek = new ArrayList<Szereles>();

        public static void loadTulajdonosok(){
            /* TODO */
            Tulajdonosok.add(new Tulajdonos("Tóth Balázs","Debrecen, Nagycsere tanya HRSZ.:02147/5","123"));
            Logger.info(Tulajdonosok.toString());
        }
        public static void loadGepjarmuvek(){
        /* TODO */
            Gepjarmuvek.add(new Gepjarmu("Tesla Model S","ABC-123","123"));
            Logger.info(Gepjarmuvek.toString());
        }
        public static void loadSzerelesek(){
        /* TODO */
            Szerelesek.add(new Szereles(LocalDate.of(2019, Month.APRIL,5),"ABC-123"));
            Logger.info(Szerelesek.toString());
        }

    public static List<Tulajdonos> getTulajdonosok() {
        return Tulajdonosok;
    }

    public static List<Gepjarmu> getGepjarmuvek() {
        return Gepjarmuvek;
    }

    public static List<Szereles> getSzerelesek() {
        return Szerelesek;
    }

    //Teszt
    public static List<Szereles> getBefejezetlenSzerelesek(){
            return DataStore.getSzerelesek().stream().filter(c->c.getBefejezesIdeje()==null)
                    .collect(Collectors.toList());
    }
    public static List<Szereles> getBefejezettSzerelesek(){
        return DataStore.getSzerelesek().stream().filter(c->c.getBefejezesIdeje()!=null)
                .collect(Collectors.toList());
    }

}