package org.InventarioGyssa.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.InventarioGyssa.sistema.Principal;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PracticanteIT
 */
public class MenuPrincipalController implements Initializable{
    private Principal escenarioPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public MenuPrincipalController(){
        
    }
    public MenuPrincipalController(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    public void menuPrincipal(){
        escenarioPrincipal.menuPrincipal();
    }
    
    public void ventanaPersonal123(){
        escenarioPrincipal.ventanaPersonal();
    }
    
    public void ventanaLaptop2(){
        escenarioPrincipal.ventanaLaptos();
    }
    
    public void ventanaDepartamentoIT2(){
        escenarioPrincipal.ventanaDepartamentoIT();
    }
    
   
    
}
