package entitymanager;
import datastore.DataStore;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import java.util.ListIterator;


public class TulajdonosManager {
    private static TulajdonosManager instance = new TulajdonosManager();
    private TulajdonosManager(){}
    public static TulajdonosManager getInstance(){
        return instance;
    }

    public Tulajdonos createTulajdonos(String nev, String jogositvanyszam, String lakcim){
        return new Tulajdonos(nev, jogositvanyszam,lakcim);
    }

    public void addTulajdonosokhoz(String nev,  String lakcim,String jogositvanyszam){
        /*for (Tulajdonos t: DataStore.getTulajdonosok() ){
            if(t.getJogositvanyszam()==jogositvanyszam)
                Logger.info("Ilyen tulajdonos már van");
                return;
        }*/
        boolean vanMarIlyen=false;
        ListIterator<Tulajdonos> listIterator = DataStore.getTulajdonosok().listIterator();
        while(listIterator.hasNext()){
            Logger.info("Whileban vagyok");
            //Logger.info(listIterator.next().getJogositvanyszam()+" "+jogositvanyszam);
            if(listIterator.next().getJogositvanyszam().equals(jogositvanyszam)){
                //Logger.info(listIterator.next().getJogositvanyszam()+" "+jogositvanyszam);
                Logger.info("Már van " + jogositvanyszam+ " számú tulajdonos");
                return;
            }
        }
        DataStore.Tulajdonosok.add(new Tulajdonos(nev,lakcim,jogositvanyszam));
        Logger.info(DataStore.getTulajdonosok().toString());
    }
}
