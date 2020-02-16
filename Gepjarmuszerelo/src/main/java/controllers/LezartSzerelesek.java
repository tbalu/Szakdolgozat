package controllers;

import javafx.fxml.Initializable;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class LezartSzerelesek extends GepjarmuszereloBasicController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        Logger.info("Lezárt szerelések.");
    }
}
