package entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "szerelo")
public class Szerelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    // Lesznek még további funkciók

    @ManyToMany(mappedBy = "szerelok")
    private List<Javitas> elvegzettJavitasok;

}
