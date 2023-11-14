/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modPrimSeg;


public class Persona {
    private final String nombreCompleto, fechaNacimiento, genero, direccion, telefono, correo;

    public Persona(String nombreCompleto, String fechaNacimiento, String genero, String direccion, String telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}

