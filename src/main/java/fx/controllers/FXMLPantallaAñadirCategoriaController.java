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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Categoria;
import servicios.ServiciosCategoria;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaAñadirCategoriaController implements Initializable {

    @FXML
    private TextField fxNombre;
    @FXML
    private TextArea fxDescripcion;
    @FXML
    private TextField fxNombreNuevo;
    @FXML
    private TextArea fxDescripcionNuevo;
    @FXML
    private ComboBox fxCategoria;
    @FXML
    private ComboBox fxCategoria2;
    @FXML
    private TableView fxTablaBorrar;

    private FXMLPantallaPrincipalController inicio;
    private Alert alertError;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }

    public void cargar() {
        ServiciosCategoria sc = new ServiciosCategoria();
        fxCategoria.getItems().clear();
        fxCategoria2.getItems().clear();
        ArrayList<Categoria> categorias = (ArrayList<Categoria>) sc.cargarTodosLasCategorias();
        fxCategoria.getItems().addAll(categorias);
        fxCategoria2.getItems().addAll(categorias);

    }

    public void AñadirCategoria() {

        if (fxNombre.getText().equals("") || fxDescripcion.getText().equals("")) {
            alertError.setContentText("Introduzca todos los datos");
            alertError.showAndWait();
        } else {
            Categoria c = new Categoria(0, fxNombre.getText(), fxDescripcion.getText());
            ServiciosCategoria sc = new ServiciosCategoria();
//            if ("añadir la pinche categoria hijo de la chingada wey") {
//                Alert a = new Alert(Alert.AlertType.INFORMATION, "Categoria creada", ButtonType.CLOSE);
//                a.showAndWait();
//                fxNombre.clear();
//                fxDescripcion.clear();
//               
//            } else {
//                alertError.setContentText("Ha ocurrido un error");
//                alertError.showAndWait();
//            }

        }
    }

    public void actualizarCategoria() {
        ServiciosCategoria sc = new ServiciosCategoria();
        if (fxNombreNuevo.getText().equals("") || fxDescripcionNuevo.getText().equals("")) {
            alertError.setContentText("Introduzca todos los datos");
            alertError.showAndWait();
        } else {
            Categoria c = new Categoria(0, fxNombreNuevo.getText(), fxDescripcionNuevo.getText());

//            if ("Pues actualiza la pinche categoria otaco culiao") {
//                Alert aa = new Alert(Alert.AlertType.INFORMATION, "Categoria actualizada", ButtonType.CLOSE);
//                aa.showAndWait();
//                fxNombreNuevo.clear();
//                fxDescripcionNuevo.clear();
//                
//            } else {
//                alertError.setContentText("Ha ocurrido un error");
//                alertError.showAndWait();
//            }

        }
    }
    
    public void BorrarCategoria() {
        //PREGUNTAR pa que coño es el segundo combobox que no lo enchiendo pinche furro 

//        if (fxNombre.getText().equals("") || fxDescripcion.getText().equals("")) {
//            alertError.setContentText("Introduzca todos los datos");
//            alertError.showAndWait();
//        } else {
//            Categoria c = new Categoria(0, fxNombre.getText(), fxDescripcion.getText());
//            ServiciosCategoria sc = new ServiciosCategoria();
////            if ("añadir la pinche categoria hijo de la chingada wey") {
////                Alert a = new Alert(Alert.AlertType.INFORMATION, "Categoria creada", ButtonType.CLOSE);
////                a.showAndWait();
////                fxNombre.clear();
////                fxDescripcion.clear();
////               
////            } else {
////                alertError.setContentText("Ha ocurrido un error");
////                alertError.showAndWait();
////            }
//
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertError = new Alert(Alert.AlertType.ERROR);
    }

}
