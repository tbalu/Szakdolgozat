package entities;

import java.time.LocalDate;

public interface SzerelesElkezdese {
    void setSzerelesKezdete(LocalDate szerelesMegkezdese);
    LocalDate getSzerelesKezdete();
    void setGepjarmu(Gepjarmu gepjarmu);
    Gepjarmu getGepjarmu();


}
