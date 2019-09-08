package controllers;

import daos.EntityManagerCreator;
import daos.TulajdonosDao;
import entities.Tulajdonos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TulajdonosokListajaController implements Initializable {

    @FXML private TableView<Tulajdonos> tulajdonosTabla;
    @FXML private TableColumn<Tulajdonos,String> jogositvanyOszlop;
    @FXML private TableColumn<Tulajdonos,String> nevOszlop;
    @FXML private TableColumn<Tulajdonos, String> lakcimOszlop;

    @FXML private TextField nevTextField;

    TulajdonosDao tulajdonosDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //AutoMarkajaOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("AutoMarkaja"));
        jogositvanyOszlop.setCellValueFactory(new PropertyValueFactory<>("jogositvanyszam"));
        nevOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("nev"));
        lakcimOszlop.setCellValueFactory(new PropertyValueFactory<Tulajdonos, String>("lakcim"));


        this.tulajdonosDao = new TulajdonosDao(EntityManagerCreator.getEntityManager());

        tulajdonosTabla.setItems(FXCollections.observableArrayList(tulajdonosDao.getAll()));
        tulajdonosTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        /*
        FolyamatbanLevoSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        */
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //MunkavegzesKezdeteOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
    /*
        FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
  */
    }

    public void keresButtonPushed(){

        String nev = this.nevTextField.getText();
        Logger.info("Erre a névre keres rá a felhasználó: " +nev);
        if(nev.equals("")){
            Logger.info("Az összes tulajdonos lekérdezése.");
            tulajdonosTabla.setItems(FXCollections.observableArrayList(tulajdonosDao.findAll()));
        } else {
            ObservableList o = FXCollections.observableArrayList(this.tulajdonosDao.getByNev(nev));
            tulajdonosTabla.setItems(o);
        }
    }

    public void gepjarmuveiButtonPushed(ActionEvent event) throws IOException{

        Tulajdonos kivalasztottTulajdonos = tulajdonosTabla.getSelectionModel().getSelectedItem();
        Logger.info(kivalasztottTulajdonos);




        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("resources/TulajdonosGepjarmuvei.fxml"));
        loader.setLocation(FXMLLoader.getDefaultClassLoader()
                .getResource("TulajdonosGepjarmuvei.fxml"));
        Parent root = loader.load();
        TulajdonosGepjarmuveiController controller = loader.getController();

        controller.initData(kivalasztottTulajdonos.getId());



        /*
        URL url = FXMLLoader.getDefaultClassLoader()
                .getResource("TulajdonosGepjarmuvei.fxml");
        Parent tableViewParent = FXMLLoader.load(url);*/
        Scene tableViewScene = new Scene(root);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("TulajdonosEsAutoAdatai.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
