package controllers;

import entities.Szereles;
import guidemo.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FolyamatbanLevoSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> FolyamatbanLevoSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> AutoMarkajaOszlop;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesKezdeteOszlop;

    @FXML private TextField MunkavegzesKoltsege;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AutoMarkajaOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("Auto markaja"));
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("Rendszam"));
        SzerelesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles, LocalDate>("Szereles kezdete"));

        tableView.setItems(getPeople());

        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/java/view/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
