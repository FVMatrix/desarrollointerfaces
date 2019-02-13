/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Articulo;
import model.Empleado;
import servicios.ServiciosArticulos;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaBorrarArticuloController implements Initializable {

    private FXMLPantallaPrincipalController inicio;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }

    @FXML
    private ComboBox fxComboBox;
    @FXML
    private TableView fxTableView;

    @FXML
    public void cargarTabla() {
//        ServiciosArticulos sa = new ServiciosArticulos();
//        List<Articulo> art;
//        art = sa.cargarTodosLosArticulos();

        TableColumn nombre = new TableColumn("Nombre");
        TableColumn categoria = new TableColumn("Categoria");
        TableColumn responsable = new TableColumn("Responsable");
        TableColumn ubicacion = new TableColumn("Ubicación");
        TableColumn descipcion = new TableColumn("Descripción");
        nombre.setPrefWidth(140);
        categoria.setPrefWidth(140);
        responsable.setPrefWidth(140);
        ubicacion.setPrefWidth(140);
        descipcion.setPrefWidth(140);
        fxTableView.getColumns().addAll(nombre, categoria, responsable, ubicacion, descipcion);
        nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        categoria.setCellValueFactory(new PropertyValueFactory("id_categoria"));
        responsable.setCellValueFactory(new PropertyValueFactory("id_responsable"));
        ubicacion.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        descipcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        Articulo a = (Articulo) fxComboBox.getSelectionModel().getSelectedItem();
        fxTableView.getItems().add(a);
//añadirTOdo
//        for (int i = 0; i < art.size(); i++) {
//            fxTableView.getItems().addAll(art.get(i));
//        }
    }

    @FXML
    public void cargarComboBox() {
        ServiciosArticulos sa = new ServiciosArticulos();
        List<Articulo> art;
        art = sa.cargarTodosLosArticulos();
        fxComboBox.getItems().addAll(art);
    }

    @FXML
    public void borrarArticulo() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
