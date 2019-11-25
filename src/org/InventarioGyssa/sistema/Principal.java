/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.InventarioGyssa.sistema;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.InventarioGyssa.controller.DepartamentoITController;
import org.InventarioGyssa.controller.LaptopsController;
import org.InventarioGyssa.controller.MenuPrincipalController;
import org.InventarioGyssa.controller.PersonalController;

/**
 *
 * @author PracticanteIT
 */
public class Principal extends Application {
    private String PAQUETE_VISTA = "/org/InventarioGyssa/view/"; 
    private Stage escenarioPrincipal;
    private Scene escena;
    
    @Override
    public void start(Stage escenarioPrincipal)   {   
        this.escenarioPrincipal = escenarioPrincipal ;
        escenarioPrincipal.setTitle("APP Invenatrio Gyssa");
        menuPrincipal();
        escenarioPrincipal.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void menuPrincipal(){
        try{
            MenuPrincipalController menuPrincipal = (MenuPrincipalController)cambiarEscena("MenuPrincipalView.fxml",1250,650);
            menuPrincipal.setEscenarioPrincipal(this);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaPersonal(){
        try{
            PersonalController ventanaPersonal = (PersonalController) cambiarEscena("Personal123View.fxml",1250,650 );
            ventanaPersonal.setEscanarioPrincipalPersonal(this);
        }catch (Exception e){
          e.printStackTrace();
        }
    }
    
    public void ventanaLaptos(){
        try{
            LaptopsController ventanaLaptos = (LaptopsController) cambiarEscena("LaptopsView.fxml",1250,650 );
            ventanaLaptos.setEscenarioPrincipalLaptops(this);
        }catch (Exception e){
          e.printStackTrace();
        }
    }
    
    public void ventanaDepartamentoIT(){
        try{
            DepartamentoITController ventanaDepartamentoIT = (DepartamentoITController) cambiarEscena("DepartamentoITView.fxml",900,650 );
            ventanaDepartamentoIT.setEscenarioPrincipalDepartamentoIT(this);
        }catch (Exception e){
          e.printStackTrace();
        }
    }
    
  
    
    
    
    
    
    
    
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws Exception{
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)cargadorFXML.getController();
        
        return resultado;
    }
    
    
}
