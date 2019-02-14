/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Articulo;
import servicios.ServiciosArticulos;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author mykha
 */
public class FXMLPantallaVerArticulosController implements Initializable {

    private FXMLPantallaPrincipalController inicio;

    public void setInicio(FXMLPantallaPrincipalController inicio) {
        this.inicio = inicio;
    }
    private String imagenesDeArticulo;
    private String imagenActual;
    private String[] imagenesSeparadas;
    private Articulo articuloSeleccionadoEnelCombo;

    @FXML
    private ComboBox fxComboBox;
    @FXML
    private TableView fxTableView;
    @FXML
    private ImageView fxImageView;
    @FXML
    private Button fxBotonSiguiente;
    @FXML
    private Button fxBotonAnterior;

    public void cargarComboBox() {
        servicios.ServiciosArticulos sa = new ServiciosArticulos();
        fxComboBox.getItems().clear();
        fxComboBox.getItems().addAll(sa.cargarTodosLosArticulos());
        fxComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void cargarDatos() {
        //Este metodo controla el problema de cuando se deja seleccionado algo en el combobox, se va a otra pantalla y se vuelve. el combo se recarga y eso llama una
        //accion y ejecuta el cargar tabla y la image view, y como la seleccion es nula, provoca un nullPointer.
        if (fxComboBox.getSelectionModel().getSelectedItem() != null) {
            cargarTabla();
        }
    }

    @FXML
    public void cargarTabla() {
        Articulo a = (Articulo) fxComboBox.getSelectionModel().getSelectedItem();
        fxTableView.getColumns().clear();
        fxTableView.getItems().clear();
        TableColumn nombre = new TableColumn("Nombre");
        TableColumn categoria = new TableColumn("Categoria");
        TableColumn responsable = new TableColumn("Responsable");
        TableColumn ubicacion = new TableColumn("Ubicación");
        TableColumn descipcion = new TableColumn("Descripción");
        nombre.setPrefWidth(139);
        categoria.setPrefWidth(139);
        responsable.setPrefWidth(139);
        ubicacion.setPrefWidth(139);
        descipcion.setPrefWidth(139);
        fxTableView.getColumns().addAll(nombre, categoria, responsable, ubicacion, descipcion);
        nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        categoria.setCellValueFactory(new PropertyValueFactory("id_categoria"));
        responsable.setCellValueFactory(new PropertyValueFactory("responsable"));
        ubicacion.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        descipcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        fxTableView.getItems().add(a);
        cargarImageView(a);
    }

    public void habiliatarBotonesDeLasImagenes() {
        fxBotonAnterior.setVisible(true);
        fxBotonSiguiente.setVisible(true);
    }

    public void deshabiliatarBotonesDeLasImagenes() {
        fxBotonAnterior.setVisible(false);
        fxBotonSiguiente.setVisible(false);
    }

    public void cargarImageView(Articulo a) {
        if (null == a.getImagenes()) {
            deshabiliatarBotonesDeLasImagenes();
            Image image = new Image(this.getClass().getResource("/images/nohay.jpg").toString());
            fxImageView.setImage((image));
        } else {
            imagenesDeArticulo = a.getImagenes();
            imagenesSeparadas = imagenesDeArticulo.split(";");
            File file = new File("./images/");
            //this.getClass().getResource("/images/"
            Image image = new Image("images/" + imagenesSeparadas[0]);
            setImagenActual(imagenesSeparadas[0]);
            fxImageView.setImage((image));
            habiliatarBotonesDeLasImagenes();
            //ACTUALIZAR IMAGENES
        }

    }

    public int devuelvemeLaPosicionDeLaImagenActual() {
        int num = 0;
        for (int i = 0; i < imagenesSeparadas.length; i++) {
            if (imagenesSeparadas[i].equals(getImagenActual())) {
                num = i;
            }
        }
        return num;
    }

    //Cuando sea la ultima imagen de la lista y el usuario pulsa "Siguiente Imagen"
    public void mostrarLaPrimeraImagen() {
        Image image = new Image(this.getClass().getResource("/images/" + imagenesSeparadas[0]).toString());
        setImagenActual(imagenesSeparadas[0]);
        fxImageView.setImage((image));
    }
    //Cuando sea la primera imagen de la lista y el usuario pulsa "Anterior Imagen"

    public void mostrarLaUltimaImagen() {
        Image image = new Image(this.getClass().getResource("/images/" + imagenesSeparadas[imagenesSeparadas.length - 1]).toString());
        setImagenActual(imagenesSeparadas[imagenesSeparadas.length - 1]);
        fxImageView.setImage((image));
    }

    @FXML
    public void mostrarImagenSiguiente() {

        String cual = getImagenActual();
        if (imagenesSeparadas[imagenesSeparadas.length - 1].equals(cual)) {
            mostrarLaPrimeraImagen();
        } else {
            int num = devuelvemeLaPosicionDeLaImagenActual();
            Image image = new Image(this.getClass().getResource("/images/" + imagenesSeparadas[num + 1]).toString());
            setImagenActual(imagenesSeparadas[num + 1]);
            fxImageView.setImage((image));
        }
    }

    @FXML
    public void mostrarImagenAnterior() {
        String cual = getImagenActual();
        if (imagenesSeparadas[0].equals(cual)) {
            mostrarLaUltimaImagen();
        } else {
            int num = devuelvemeLaPosicionDeLaImagenActual();
            Image image = new Image(this.getClass().getResource("/images/" + imagenesSeparadas[num - 1]).toString());
            setImagenActual(imagenesSeparadas[num - 1]);
            fxImageView.setImage((image));
        }
    }

    public String[] getImagenesSeparadas() {
        return imagenesSeparadas;
    }

    public void setImagenesSeparadas(String[] imagenesSeparadas) {
        this.imagenesSeparadas = imagenesSeparadas;
    }

    public String getImagenesDeArticulo() {
        return imagenesDeArticulo;
    }

    public void setImagenesDeArticulo(String imagenesDeArticulo) {
        this.imagenesDeArticulo = imagenesDeArticulo;
    }

    public String getImagenActual() {
        return imagenActual;
    }

    public void setImagenActual(String imagenActual) {
        this.imagenActual = imagenActual;
    }

    public Articulo getArticuloSeleccionadoEnelCombo() {
        return articuloSeleccionadoEnelCombo;
    }

    public void setArticuloSeleccionadoEnelCombo(Articulo articuloSeleccionadoEnelCombo) {
        this.articuloSeleccionadoEnelCombo = articuloSeleccionadoEnelCombo;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deshabiliatarBotonesDeLasImagenes();
    }

}
