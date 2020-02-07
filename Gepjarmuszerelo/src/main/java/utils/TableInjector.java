package utils;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;


public class TableInjector<E> implements TableManager<E> {

    protected TableView tabla;

    public TableInjector(TableView tabla)  {


        this.tabla = tabla;

        this.setTableColumnokPropValue();

    }

    @Override
    public void setEntitasok(List entities) {

            System.out.println("Íme a tábla: " + this.tabla);
            this.tabla.setItems(FXCollections.observableArrayList(entities));

    }

    @Override
    public List<E> getJelenlegiEntitasok() {
        return new ArrayList(this.tabla.getItems());
    }

    @Override
    public void setTabla(TableView<E> tabla) {
        this.tabla = tabla;
    }

    @Override
    public E getSelectedItem() {
        return (E)this.tabla.getSelectionModel().getSelectedItem();
    }

    @Override
    public void addEntity(E entity) {

        this.tabla.getItems().add(entity);
    }

    @Override
    public void addEntity(List<E> entities) {

        this.tabla.setItems(FXCollections.observableArrayList(entities));
        Logger.info("----"+this.tabla.getItems());
    }

    @Override
    public E getSelectedEntity() {

        return (E)this.tabla.getSelectionModel().getSelectedItem();

    }

    @Override
    public void setEntities(List<E> entities) {

        this.tabla.setItems(FXCollections.observableArrayList(entities));

    }

    @Override
    public void removeSelectedEntity() {

        this.tabla.getItems().remove(this.getSelectedEntity());

    }

    @Override
    public void setSelectedEntity(E entity) {
        this.getJelenlegiEntitasok().set(this.tabla.getItems().indexOf(this.getSelectedItem()),entity);

    }

    @Override
    public void rerfreshTable() {
        this.tabla.refresh();
    }

    @Override
    public void removeAll() {
        this.tabla.getItems().removeAll(this.tabla.getItems());
    }


    private void setTableColumnokPropValue(){

        Logger.info(this.tabla.getColumns());
        for(Object tc: this.tabla.getColumns()){

            ((TableColumn) tc).setCellValueFactory(
                    new PropertyValueFactory<>(((TableColumn) tc).getId()
                            .replace("Oszlop","")));

        }

    }


}

  /*          ((TableColumn) tc).setCellValueFactory(
                    new PropertyValueFactory<>(((TableColumn) tc).getId()
        .toLowerCase().replace("oszlop","")));
*/