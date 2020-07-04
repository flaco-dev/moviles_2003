/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.flaco;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 *
 * @author omar5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Perfil {
    
    @Id
    String id;
    
    private String nombre;
    private String paterno;
    private String email;
    private String celular;
    private int edad;

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", email=" + email + ", celular=" + celular + ", edad=" + edad + '}';
    }
    
    
    
    public Perfil() {
       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String patrerno) {
        this.paterno = patrerno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
