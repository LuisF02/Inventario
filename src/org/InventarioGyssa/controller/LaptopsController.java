/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.InventarioGyssa.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.InventarioGyssa.sistema.Principal;

/**
 *
 * @author PracticanteIT
 */
public class LaptopsController implements Initializable{
    private Principal EscenarioPrincipalLaptops;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public LaptopsController() {
    }
    

    public Principal getEscenarioPrincipalLaptops() {
        return EscenarioPrincipalLaptops;
    }

    public void setEscenarioPrincipalLaptops(Principal EscenarioPrincipalLaptops) {
        this.EscenarioPrincipalLaptops = EscenarioPrincipalLaptops;
    }
    
    
    public void MenuPrincipal(){
        EscenarioPrincipalLaptops.menuPrincipal();
    }
    
    
    
    
    
    
}
