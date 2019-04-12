package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface SzerelesBefejezese {
    void setBefejezesIdeje(LocalDate BefejezesIdeje);
    LocalDate getBefejezesIdeje();
    void setMunkavegzesKoltsege(Integer MunkavegzesKoltsege);
    Integer getMunkavegzesKoltsege();
    /*void addAlkatreszek(List<Map<Alkatresz,Integer>> felhasznaltAlkatresz);
    List<Map<Alkatresz,Integer>> getFelhasznaltAlkatreszek();*/
}
