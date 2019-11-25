/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.InventarioGyssa.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.InventarioGyssa.bean.Personal;
import org.InventarioGyssa.db.Conexion;
import org.InventarioGyssa.sistema.Principal;

/**
 *
 * @author PracticanteIT
 */
public class PersonalController implements Initializable{
    private enum operaciones{Nuevo,Guardar,Editar,Actualizar,Eliminar,Cancelar,Ninguno} 
    private operaciones tipoDeOperaciones = operaciones.Ninguno;
    private ObservableList <Personal> listaPersonal;
    
    private Principal EscanarioPrincipalPersonal;
    
    @FXML private ComboBox cmbIDPersonal;
    @FXML private TextField txtNombre; 
    @FXML private TextField txtApellido; 
    @FXML private TextField txtPuesto;
    @FXML private TextField txtUnidadDeNegocio; 
    @FXML private TableView tablaPersonal; 
    @FXML private TableColumn idPersonal; 
    @FXML private TableColumn nombre;         
    @FXML private TableColumn apellido;
    @FXML private TableColumn unidaDeNegocio; 
    @FXML private TableColumn Puesto; 
    @FXML private Button btnAgregar;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;
    @FXML private Button btnReporte;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarDatos();
        cmbIDPersonal.setItems(getPersonal());
        
    }
    
    public void cargarDatos(){
        tablaPersonal.setItems(getPersonal());
        idPersonal.setCellValueFactory(new PropertyValueFactory <Personal , Integer> ("idPersonal"));
        nombre.setCellValueFactory(new PropertyValueFactory <Personal , String> ("Nombre"));
        apellido.setCellValueFactory(new PropertyValueFactory <Personal , String> ("Apellido"));
        unidaDeNegocio.setCellValueFactory(new PropertyValueFactory <Personal , String> ("UnidadDeNegocio"));
        Puesto.setCellValueFactory(new PropertyValueFactory <Personal , String> ("Puesto"));
        
    }
    
    public ObservableList <Personal> getPersonal(){
        ArrayList <Personal> lista = new ArrayList<Personal>();
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_listarPersonal}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Personal(resultado.getInt("idPersonal"), 
                        resultado.getString("Nombre"),
                        resultado.getString("Apellido"), 
                        resultado.getString("UnidadDeNegocio"),
                        resultado.getString("Puesto")));
            }
        }catch(SQLException e) {
            e.printStackTrace();  
        }
        return listaPersonal = FXCollections.observableList (lista)  ;
    }
    
    public void seleccionar(){
        Personal PersonalSeleccionado = (Personal)tablaPersonal.getSelectionModel().getSelectedItem();
        cmbIDPersonal.getSelectionModel().select(PersonalSeleccionado.toString());
        txtNombre.setText(PersonalSeleccionado.getNombre());
        txtApellido.setText(PersonalSeleccionado.getApellido());
        txtUnidadDeNegocio.setText(PersonalSeleccionado.getUnidadDeNegocio());
        txtPuesto.setText(PersonalSeleccionado.getPuesto());
        
    }
    
    public Personal buscarPersonal (int idPersonal){
       Personal resultado = null; 
       try{
           PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_BuscarPersonal(?)}");
           procedimiento.setInt(1, idPersonal);
           ResultSet registro = procedimiento.executeQuery();
           while (registro.next()){
                resultado = new Personal (registro.getInt("idPersonal"),
                registro.getString("Nombre"),
                registro.getString("Apellido"),
                registro.getString("UnidadDeNegocio"),
                registro.getString("Puesto"));
           }
           
        }catch(SQLException e) {
            e.printStackTrace();  
        } 
            return resultado;
    }
    
    public void nuevo(){
        switch (tipoDeOperaciones){
            case Ninguno:
                activar();
                limpiar();
                btnAgregar.setText("Guardar");
                btnEliminar.setText("Cancelar");
                btnModificar.setDisable(true);
                btnReporte.setDisable(true);
                tipoDeOperaciones = operaciones.Guardar;
            break; 
            
            case Guardar:
                ingresar1();
                desactivar();
                //cancelar();   
                btnAgregar.setText("Nuevo");
                btnEliminar.setText("Eliminar");
                btnModificar.setDisable(false);
                btnReporte.setDisable(false);
                tipoDeOperaciones = operaciones.Ninguno;
            break;
        }
    }
    
    public void activar(){
        cmbIDPersonal.setDisable(false);
        txtNombre.setDisable(false);
        txtApellido.setDisable(false);
        txtUnidadDeNegocio.setDisable(false);
        txtPuesto.setDisable(false);
        
        cmbIDPersonal.setEditable(true);
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtUnidadDeNegocio.setEditable(true);
        txtPuesto.setEditable(true);
    }
    
    public void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtUnidadDeNegocio.setText("");
        txtPuesto.setText("");
        
    }
    
    public void cancelar(){
        btnAgregar.setText("Nuevo");
        btnEliminar.setText("Eliminar");
        btnModificar.setDisable(false);
        btnReporte.setDisable(false);
        
    }
    
    public void ingresar1(){
        Personal registro = new Personal(); 
        registro.setNombre(txtNombre.getText());
        registro.setApellido(txtApellido.getText());
        registro.setUnidadDeNegocio(txtUnidadDeNegocio.getText());
        registro.setPuesto(txtPuesto.getText());
        
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_AgregarPersonal (?,?,?,?)} ");
                procedimiento.setString(1,registro.getNombre());
                procedimiento.setString(2, registro.getApellido());
                procedimiento.setString(3, registro.getUnidadDeNegocio());
                procedimiento.setString(4, registro.getPuesto());
                procedimiento.execute();
                listaPersonal.add(registro);
                limpiar();
                cargarDatos();        
        }catch(SQLException e){
                    e.printStackTrace();  
        } 
    }
    
    
    public void desactivar(){
        cmbIDPersonal.setDisable(true);
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtUnidadDeNegocio.setDisable(true);
        txtPuesto.setDisable(true);
        
        cmbIDPersonal.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtUnidadDeNegocio.setEditable(false);
        txtPuesto.setEditable(false);
        
    }
    
    
    
    
    
   
    
  
    
       
        
    
    
    
    

    public PersonalController() {
    }
    

    public Principal getEscanarioPrincipalPersonal() {
        return EscanarioPrincipalPersonal;
    }

    public void setEscanarioPrincipalPersonal(Principal EscanarioPrincipalPersonal) {
        this.EscanarioPrincipalPersonal = EscanarioPrincipalPersonal;
    }
    
    public void menuPrincipal (){
        EscanarioPrincipalPersonal.menuPrincipal();
    }
    
    

    
    
    
    
    
    
    
    
    
}
