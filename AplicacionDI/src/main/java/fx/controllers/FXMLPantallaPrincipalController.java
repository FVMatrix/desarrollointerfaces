/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaPrincipalController implements Initializable {

    @FXML
    private BorderPane fxRoot;
    @FXML
    private MenuBar fxMenuBar;

    @FXML
    private AnchorPane pantallaActualizarArticulo;
    private FXMLPantallaActualizarArticuloController controllerActualizarArticulo;

    private AnchorPane pantallaActualizarEmpleado;
    private FXMLPantallaActualizarEmpleadoController controllerActualizarEmpleado;

    private AnchorPane pantallaActualizarCategoria;
    private FXMLPantallaActualizarCategoriaController controllerActualizarCategoria;

    private AnchorPane pantallaAñadirArticulo;
    private FXMLPantallaAñadirArticuloController controllerAñadirArticulo;

    private AnchorPane pantallaAñadirEmpleado;
    private FXMLPantallaAñadirEmpleadoController controllerAñadirEmpleado;

    private AnchorPane pantallaAñadirCategoria;
    private FXMLPantallaAñadirCategoriaController controllerAñadirCategoria;

    private AnchorPane pantallaBorrarArticulo;
    private FXMLPantallaBorrarArticuloController controllerBorrarArticulo;

    private AnchorPane pantallaBorrarEmpleado;
    private FXMLPantallaBorrarEmpleadoController controllerBorrarEmpleado;

    private AnchorPane pantallaBorrarCategoria;
    private FXMLPantallaBorrarCategoriaController controllerBorrarCategoria;

    private AnchorPane pantallaLogin;
    private FXMLPantallaLoginController controllerLogin;

    // <editor-fold defaultstate="collapsed" desc="Precargas de Pantallas">  
    private void preCargaLogin() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaLogin.fxml"));
            pantallaLogin = loaderMenu.load();
            controllerLogin = loaderMenu.getController();
            controllerLogin.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaActualizarArticulo() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaActualizarArticulo.fxml"));
            pantallaActualizarArticulo = loaderMenu.load();
            controllerActualizarArticulo = loaderMenu.getController();
            controllerActualizarArticulo.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaActualizarEmpleado() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaActualizarEmpleado.fxml"));
            pantallaActualizarEmpleado = loaderMenu.load();
            controllerActualizarEmpleado = loaderMenu.getController();
            controllerActualizarEmpleado.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaActualizarCategoria() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaActualizarCategoria.fxml"));
            pantallaActualizarCategoria = loaderMenu.load();
            controllerActualizarCategoria = loaderMenu.getController();
            controllerActualizarCategoria.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaAñadirArticulo() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaAñadirArticulo.fxml"));
            pantallaAñadirArticulo = loaderMenu.load();
            controllerAñadirArticulo = loaderMenu.getController();
            controllerAñadirArticulo.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaAñadirEmpleado() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaAñadirEmpleado.fxml"));
            pantallaAñadirEmpleado = loaderMenu.load();
            controllerAñadirEmpleado = loaderMenu.getController();
            controllerAñadirEmpleado.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaAñadirCategoria() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaAñadirCategoria.fxml"));
            pantallaAñadirCategoria = loaderMenu.load();
            controllerAñadirCategoria = loaderMenu.getController();
            controllerAñadirCategoria.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaBorrarArticulo() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaBorrarArticulo.fxml"));
            pantallaBorrarArticulo = loaderMenu.load();
            controllerBorrarArticulo = loaderMenu.getController();
            controllerBorrarArticulo.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaBorrarEmpleado() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaBorrarEmpleado.fxml"));
            pantallaBorrarEmpleado = loaderMenu.load();
            controllerBorrarEmpleado = loaderMenu.getController();
            controllerBorrarEmpleado.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaBorrarCategoria() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLPantallaBorrarCategoria.fxml"));
            pantallaBorrarCategoria = loaderMenu.load();
            controllerBorrarCategoria = loaderMenu.getController();
            controllerBorrarCategoria.setInicio(this);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// </editor-fold>     

    // <editor-fold defaultstate="collapsed" desc="Cargas de Pantallas">  
    @FXML
    public void cargarPantallaActualizarArticulo() {
        fxRoot.setCenter(pantallaActualizarArticulo);
    }

    @FXML
    public void cargarPantallaActualizarEmpleado() {
        fxRoot.setCenter(pantallaActualizarEmpleado);
    }

    @FXML
    public void cargarPantallaActualizarCategoria() {
        fxRoot.setCenter(pantallaActualizarCategoria);
    }

    @FXML
    public void cargarPantallaAñadirArticulo() {
        fxRoot.setCenter(pantallaAñadirArticulo);
    }

    @FXML
    public void cargarPantallaAñadirEmpleado() {
        fxRoot.setCenter(pantallaAñadirEmpleado);
    }

    @FXML
    public void cargarPantallaAñadirCategoria() {
        fxRoot.setCenter(pantallaAñadirCategoria);
    }

    @FXML
    public void cargarPantallaBorrarArticulo() {
        fxRoot.setCenter(pantallaBorrarArticulo);
    }

    @FXML
    public void cargarPantallaBorrarEmpleado() {
        fxRoot.setCenter(pantallaBorrarEmpleado);
    }

    @FXML
    public void cargarPantallaBorrarCategoria() {
        fxRoot.setCenter(pantallaBorrarCategoria);
    }

    @FXML
    public void cargarPantallaLogin() {
        fxRoot.setCenter(pantallaLogin);
    }

    // </editor-fold>  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //BORRAR PANTALLAS DE ACTUALIZAR Y BORRAR CATEGORIA YA QUE ESTA TODO JUNTADO EN UNA(FXMLAÑADIRCATEGORIA)
        preCargaLogin();
        preCargaActualizarArticulo();
        preCargaActualizarCategoria();
        preCargaActualizarEmpleado();
        preCargaAñadirArticulo();
        preCargaAñadirCategoria();
        preCargaAñadirEmpleado();
        preCargaBorrarArticulo();
        preCargaBorrarCategoria();
        preCargaBorrarEmpleado();
        cargarPantallaLogin();

    }

}
