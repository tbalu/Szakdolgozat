package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

import java.io.IOException;

public class GepjarmuszereloBasicController extends BasicController {

    @FXML
    protected MenuBar menuBar;

    public void folyamatbanLevoSzerelesek(ActionEvent event) throws IOException {

        this.scenetValt("FolyamatbanLevoSzerelesek");

    }

    public void ujSzereles() throws IOException {

        this.scenetValt("UjSzerelesFelvetele");

    }


    public void ujJavitasTipus()throws IOException{


        ujAblak("UjJavitasTipus", "Új javítástipus");


    }
}
