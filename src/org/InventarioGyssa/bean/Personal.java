/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.InventarioGyssa.bean;

/**
 *
 * @author PracticanteIT
 */
public class Personal {
    private int idPersonal; 
    private String Nombre; 
    private String Apellido;
    private String UnidadDeNegocio; 
    private String Puesto;

    public Personal(int idPersonal, String Nombre, String Apellido, String UnidadDeNegocio, String Puesto) {
        this.idPersonal = idPersonal;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.UnidadDeNegocio = UnidadDeNegocio;
        this.Puesto = Puesto;
    }

    public Personal() {
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUnidadDeNegocio() {
        return UnidadDeNegocio;
    }

    public void setUnidadDeNegocio(String UnidadDeNegocio) {
        this.UnidadDeNegocio = UnidadDeNegocio;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    
    @Override
    public String toString() {
        return ""+ idPersonal + "_" + Nombre;
    }
    
    
}
