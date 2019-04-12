package entitymanager;
import entities.Tulajdonos;


public class TulajdonosManager {
    private static TulajdonosManager instance = new TulajdonosManager();
    private TulajdonosManager(){}
    public static TulajdonosManager getInstance(){
        return instance;
    }
    public Tulajdonos createTulajdonos(String nev, String jogositvanyszam, String lakcim){
        return new Tulajdonos(nev, jogositvanyszam,lakcim);
    }
}
