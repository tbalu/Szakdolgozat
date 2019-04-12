package datastore;

import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import java.util.List;
import java.util.stream.Collectors;

public class DataStore {
        public static List<Tulajdonos> Tulajdonosok;
        public static List<Gepjarmu> Gepjarmuvek;
        public static List<Szereles> Szerelesek;

        public static void loadTulajdonosok(){
            /* TODO */
        }
        public static void loadGepjarmuvek(){
        /* TODO */
        }
        public static void loadSzerelesek(){
        /* TODO */
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
