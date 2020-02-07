package controllers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BasicController implements Initializable {


    @FXML protected MenuBar menuBar;

    public void folyamatbanLevoSzerelesek(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("FolyamatbanLevoSzerelesek.fxml"));
        loader.setLocation(FXMLLoader.getDefaultClassLoader()
                .getResource("FolyamatbanLevoSzerelesek.fxml"));

        Parent root = loader.load();

        FolyamatbanLevoSzerelesek controller = loader.getController();

        Scene folyamatbanLevoSzerelesekScene = new Scene(root);



        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        Stage window = (Stage)menuBar.getScene().getWindow();

        window.setScene(folyamatbanLevoSzerelesekScene);
        window.show();

    }

    public void ujSzereles() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("UjSzerelesFelvetele.fxml"));
        loader.setLocation(FXMLLoader.getDefaultClassLoader()
                .getResource("UjSzerelesFelvetele.fxml"));

        Parent root = loader.load();

        UjSzerelesFelvetele controller = loader.getController();

        Scene folyamatbanLevoSzerelesekScene = new Scene(root);



        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        Stage window = (Stage)menuBar.getScene().getWindow();

        window.setScene(folyamatbanLevoSzerelesekScene);
        window.show();
        Logger.info("meghivtak");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
