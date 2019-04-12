package entities;

import java.time.LocalDate;

public interface SzerelesElkezdese {
    void setSzerelesKezdete(LocalDate szerelesMegkezdese);
    LocalDate getSzerelesKezdete();
    void setRendszam(String gepjarmuRendszama);
    String getRendszam();
    void setProblema(String problema);
    String getProblema();

}
