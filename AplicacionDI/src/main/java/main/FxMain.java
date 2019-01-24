/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author dam2
 */
public class FxMain extends Application {
    
    @Override
    public void start(Stage primaryStage)throws IOException {

        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/FXMLPantallaPrincipal.fxml"));
        BorderPane root = loaderMenu.load();

        Scene scene = new Scene(root);
//        scene.getStylesheets().add("css/fxmlScene.css");
        primaryStage.setTitle("Aca El titulo");
        primaryStage.setScene(scene);
        primaryStage.show();
        //para no poder maximizar pantalla y
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
