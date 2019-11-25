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
public class DepartamentoITController implements Initializable {
    
    
    private Principal EscenarioPrincipalDepartamentoIT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public DepartamentoITController() {
    }

    public Principal getEscenarioPrincipalDepartamentoIT() {
        return EscenarioPrincipalDepartamentoIT;
    }

    public void setEscenarioPrincipalDepartamentoIT(Principal EscenarioPrincipalDepartamentoIT) {
        this.EscenarioPrincipalDepartamentoIT = EscenarioPrincipalDepartamentoIT;
    }
    
    public void menuPrincipal(){
        EscenarioPrincipalDepartamentoIT.menuPrincipal();
    }
  
    public void VentanaPersonal6(){
        EscenarioPrincipalDepartamentoIT.ventanaPersonal();
    }
    public void VentanaLaptops6(){
        EscenarioPrincipalDepartamentoIT.ventanaLaptos();
    }
    
    
    
}
