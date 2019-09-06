package view;

import daos.EntityManagerCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.applet.Applet;
import java.net.URL;
import java.nio.file.Paths;

public class MainAppClass extends Application {

    private void setUp(){
        EntityManagerCreator.emf = Persistence.createEntityManagerFactory("test");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setUp();

        URL url = Paths.get("src/main/java/view/TulajdonosokListaja.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
