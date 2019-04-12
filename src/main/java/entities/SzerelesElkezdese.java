package entities;

import java.time.LocalDate;

public interface SzerelesElkezdese {
    void setSzerelesMegkezdese(LocalDate szerelesMegkezdese);
    LocalDate getSzerelesMegkezdese();
    void setRendszam(String gepjarmuRendszama);
    String getRendszam();
    void setProblema(String problema);
    String getProblema();

}
