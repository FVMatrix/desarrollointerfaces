/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Categoria;
import model.Articulo;
import model.Empleado;
import servicios.ServiciosArticulos;
import servicios.ServiciosCategoria;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaAñadirArticuloController implements Initializable {

    private FXMLPantallaPrincipalController inicio;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }

    @FXML
    private TextField fxNombre;
    @FXML
    private ComboBox fxComboBoxCategoria;
    @FXML
    private ComboBox fxComboBoxResponsable;
    @FXML
    private ComboBox fxComboBoxUbicacion;
    @FXML
    private TextArea fxTextAreaDescripcion;

    @FXML
    public void cargarComboBoxCategoria() {
        servicios.ServiciosCategoria sc = new ServiciosCategoria();
        List<Categoria> categorias = sc.cargarTodosLasCategorias();

    }

    @FXML
    public void cargarComboBoxUbicacion() {
        List<String> ubicaciones = new LinkedList();
        ubicaciones.add("Despacho Director");
        ubicaciones.add("Departamento Marketing");
        ubicaciones.add("Departamento Contabilidad");
        ubicaciones.add("Departamento Producción");
        fxComboBoxUbicacion.getItems().addAll(ubicaciones);
    }

    @FXML
    public void cargarComboBoxResponsable() {

    }

    @FXML
    public void añadirArticulo() {
        servicios.ServiciosArticulos sa = new ServiciosArticulos();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        if (!fxNombre.getText().equals("") && fxComboBoxCategoria.getSelectionModel().getSelectedItem() != null && !fxTextAreaDescripcion.getText().equals("")) {
            Empleado u = null;
            String ubicacion = null;
            if (fxComboBoxResponsable.getSelectionModel().getSelectedItem() != null) {
                u = (Empleado) fxComboBoxResponsable.getSelectionModel().getSelectedItem();
            }
            if (fxComboBoxUbicacion.getSelectionModel().getSelectedItem() != null) {
                ubicacion = fxComboBoxUbicacion.getSelectionModel().getSelectedItem().toString();
            }

            Categoria cat = (Categoria) fxComboBoxCategoria.getSelectionModel().getSelectedItem();
            Articulo o = new Articulo(0, fxNombre.getText(),cat.getIdCategoria(), "imagenes", fxTextAreaDescripcion.getText(), ubicacion, u.getId_empleado(), Date.valueOf(LocalDate.now()));
            int num = sa.añadirArticulo(o);
            if (num > 0) {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();
            } else {

            }

        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Debe Rellenar los campos obligatorios");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
