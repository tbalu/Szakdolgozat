package view;

import datastore.DataStore;
import entities.Tulajdonos;
import entitymanager.StatisztikaManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        URL url = Paths.get("./src/main/java/view/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
       // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    public static void loadMindent(){
        DataStore.loadTulajdonosok();
        DataStore.loadSzerelesek();
        DataStore.loadSzerelesek2();
        DataStore.loadGepjarmuvek();
        DataStore.loadBefejezendoSzerelesek();
    }
    public static void main(String[] args){


        Tulajdonos t = new Tulajdonos("Balu","12341","Debrecen");
        System.out.println(t.toString());
        loadMindent();
//        Logger.info(StatisztikaManager.getInstance().eHaviBevetel());
  //      Logger.info(StatisztikaManager.getInstance().ezEviBevetel());
        launch(args);
        Logger.info(DataStore.getSzerelesek());
        Logger.info(DataStore.getTulajdonosok());
        Logger.info(DataStore.getGepjarmuvek());
    }
}
