/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Articulo;
import model.Empleado;
import servicios.ServiciosArticulos;
import servicios.ServiciosEmpleado;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaBorrarEmpleadoController implements Initializable {

    private FXMLPantallaPrincipalController inicio;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }
    @FXML
    private TableView fxTableView;
    @FXML
    private ComboBox fxComboBox;

    public void cargarComboBox() {
        ServiciosEmpleado se = new ServiciosEmpleado();
        List<Empleado> empleados;
        empleados = se.cargarTodosLosEmpleados();
        fxComboBox.getItems().addAll(empleados);
    }

    @FXML
    public void cargarTabla() {
//        ServiciosEmpleado se = new ServiciosEmpleado();
//        List<Empleado> empleados;
//        empleados = se.cargarTodosLosEmpleados();
        TableColumn dni = new TableColumn("DNI");
        TableColumn nombre = new TableColumn("Nombre");
        TableColumn apellidos = new TableColumn("Apellidos");
        TableColumn telefono = new TableColumn("Teléfono");
        TableColumn ubicacion = new TableColumn("Ubicación");

        nombre.setPrefWidth(140);
        dni.setPrefWidth(140);
        apellidos.setPrefWidth(140);
        ubicacion.setPrefWidth(140);
        telefono.setPrefWidth(140);
        fxTableView.getColumns().addAll(dni, nombre, apellidos, telefono, ubicacion);
        nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        dni.setCellValueFactory(new PropertyValueFactory("dni"));
        apellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        ubicacion.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        Empleado e = (Empleado) fxComboBox.getSelectionModel().getSelectedItem();
        fxTableView.getItems().add(e);
//        for (int i = 0; i < empleados.size(); i++) {
//            fxTableView.getItems().addAll(empleados.get(i));
//        }
    }

    @FXML
    public void borrarEmpleado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        ServiciosEmpleado se = new ServiciosEmpleado();
        if (fxComboBox.getSelectionModel().getSelectedItem() != null) {
            Empleado e = (Empleado) fxComboBox.getSelectionModel().getSelectedItem();
            int num = se.borrarEmpleado(e);
            if (num > 0) {
                alert.setContentText("Se ha borrado correctamente");
                alert.showAndWait();
            } else {
                //COMPLETAR
            }

        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Debe seleccionar a un empleado");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
