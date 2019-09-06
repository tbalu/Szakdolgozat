package entities;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

    public class Szereles2 {
        private SimpleStringProperty Rendszam;
        private LocalDate SzerelesKezdete;
        private LocalDate SzerelesBefejezese;
        private Integer MunkavegzesKoltsege;

        private String Problema;
        //private String Jogositvanyszam;

        public Szereles2(){}

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public Szereles2(SimpleStringProperty rendszam,LocalDate szerelesKezdete ) {
            SzerelesKezdete = szerelesKezdete;
            Rendszam = rendszam;
            //Jogositvanyszam = jogositvanyszam;
        }


        public void setBefejezesIdeje(LocalDate BefejezesIdeje) {
            this.SzerelesBefejezese = BefejezesIdeje;
        }


        public LocalDate getBefejezesIdeje() {
            return this.SzerelesBefejezese;
        }


        public void setMunkavegzesKoltsege(Integer MunkavegzesKoltsege) {
            this.MunkavegzesKoltsege = MunkavegzesKoltsege;
        }



        public Integer getMunkavegzesKoltsege() {
            return this.MunkavegzesKoltsege;
        }


        public void setSzerelesMegkezdese(LocalDate szerelesMegkezdese) {
            this.SzerelesKezdete = szerelesMegkezdese;
        }


        public LocalDate getSzerelesMegkezdese() {
            return this.SzerelesKezdete;
        }


        public void setRendszam(SimpleStringProperty Rendszam) {
            this.Rendszam = Rendszam;
        }


        public SimpleStringProperty getRendszam() {
            return this.Rendszam;
        }


        public void setProblema(String problema) {
            this.Problema = problema;
        }


        public String getProblema() {
            return this.Problema;
        }


        public String toString() {
            return "Szereles2{" +
                    "SzerelesKezdete=" + SzerelesKezdete +
                    ", SzerelesBefejezese=" + SzerelesBefejezese +
                    ", MunkavegzesKoltsege=" + MunkavegzesKoltsege +
                    ", Rendszam='" + Rendszam + '\'' +
                    ", Problema='" + Problema + '\'' +
                    '}';
        }
    }


