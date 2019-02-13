/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Ubicacion;
import servicios.ServiciosUbicacion;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class FXMLPantallaGestionarUbicacionController implements Initializable {

     @FXML
    private TextField fxNombre;
    @FXML
    private TextArea fxDescripcion;
    @FXML
    private TextField fxNombreNuevo;
    @FXML
    private TextArea fxDescripcionNuevo;
    @FXML
    private ComboBox fxUbicacionActualizar;
    @FXML
    private ComboBox fxUbicacionBorrar;
    @FXML
    private TableView fxTablaBorrar;

    private FXMLPantallaPrincipalController inicio;
    private Alert alertError;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }
    
    public void limpiarTabla() {
        fxTablaBorrar.getColumns().clear();
        fxTablaBorrar.getItems().clear();
    }
     public void cargar() {
         ServiciosUbicacion sc = new ServiciosUbicacion();
        fxUbicacionActualizar.getItems().clear();
        fxUbicacionBorrar.getItems().clear();
        fxNombreNuevo.clear();
        fxDescripcionNuevo.clear();
        fxNombre.clear();
        fxDescripcion.clear();
        ArrayList<Ubicacion> ubicaciones = (ArrayList<Ubicacion>) sc.cargarTodasLasUbicaciones();
        fxUbicacionActualizar.getItems().addAll(ubicaciones);
        fxUbicacionBorrar.getItems().addAll(ubicaciones);

    }
    
     public void cargarActualizar() {
        Ubicacion pulsada = (Ubicacion) fxUbicacionActualizar.getSelectionModel().getSelectedItem();
        if (pulsada != null) {
            fxNombreNuevo.setText(pulsada.getNombre_ubicacion());
            fxDescripcionNuevo.setText(pulsada.getDescripcion());
        }
    }
     
      public void cargarTablaBorrar() {
        fxTablaBorrar.getItems().clear();

        TableColumn nombre = new TableColumn("Nombre");
        TableColumn descripcion = new TableColumn("Descripcion");
        nombre.setPrefWidth(200);
        descripcion.setPrefWidth(200);

        fxTablaBorrar.getColumns().addAll(nombre, descripcion);
        nombre.setCellValueFactory(new PropertyValueFactory("nombre_ubicacion"));
        descripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        Ubicacion u = (Ubicacion) fxUbicacionBorrar.getSelectionModel().getSelectedItem();
        fxTablaBorrar.getItems().add(u);
    }
      
       public void añadirUbicacion() {

        if (fxNombre.getText().equals("") || fxDescripcion.getText().equals("")) {
            alertError.setContentText("Introduzca todos los datos");
            alertError.showAndWait();
        } else {
            Ubicacion c = new Ubicacion(0, fxNombre.getText(), fxDescripcion.getText());
            ServiciosUbicacion sc = new ServiciosUbicacion();
            int filas = sc.añadirUbicacion(c);
            if (filas > 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Ubicacion creada", ButtonType.CLOSE);
                a.showAndWait();
                fxNombre.clear();
                fxDescripcion.clear();
                
                fxTablaBorrar.getItems().clear();
                fxUbicacionActualizar.getItems().add(c);
                fxUbicacionBorrar.getItems().add(c);

            } else {
                alertError.setContentText("Ha ocurrido un error");
                alertError.showAndWait();
            }

        }
    }
       
        public void actualizarUbicacion() {
       ServiciosUbicacion sc = new ServiciosUbicacion();
        if (fxNombreNuevo.getText().equals("") || fxDescripcionNuevo.getText().equals("")) {
            alertError.setContentText("Introduzca todos los datos");
            alertError.showAndWait();
        } else {
            Ubicacion u = (Ubicacion) fxUbicacionActualizar.getSelectionModel().getSelectedItem();
            u.setNombre_ubicacion(fxNombreNuevo.getText());
            u.setDescripcion(fxDescripcionNuevo.getText());
            int filas = sc.modificarUbicacion(u);

            if (filas > 0) {
                Alert aa = new Alert(Alert.AlertType.INFORMATION, "Ubicacion actualizada", ButtonType.CLOSE);
                aa.showAndWait();
                fxNombreNuevo.clear();
                fxDescripcionNuevo.clear();
                fxUbicacionBorrar.getItems().remove(u);
                fxUbicacionActualizar.getItems().remove(u);
                fxUbicacionBorrar.getItems().add(u);
                fxUbicacionActualizar.getItems().add(u);

            } else {
                alertError.setContentText("Ha ocurrido un error");
                alertError.showAndWait();
            }
        }
    }
        
        public void borrarUbicacion() {

        ServiciosUbicacion sc = new ServiciosUbicacion();
        if (fxUbicacionBorrar.getSelectionModel().getSelectedItem() == null) {
            alertError.setContentText("Seleccione una categoria");
            alertError.showAndWait();
        } else {
            Ubicacion c = (Ubicacion) fxUbicacionBorrar.getSelectionModel().getSelectedItem();
            int filas = sc.borrarUbicacion(c);

            if (filas > 0) {
                Alert aa = new Alert(Alert.AlertType.INFORMATION, "Ubicacion borrada", ButtonType.CLOSE);
                aa.showAndWait();
                fxNombreNuevo.clear();
                fxDescripcionNuevo.clear();
                fxUbicacionBorrar.getItems().remove(c);
                fxUbicacionActualizar.getItems().remove(c);
                limpiarTabla();

            } else if (filas == -2) {
                alertError.setContentText("No se puede borrar esta Ubicacion");
                alertError.showAndWait();
            } else {
                alertError.setContentText("Ha ocurrido un error");
                alertError.showAndWait();
            }
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
