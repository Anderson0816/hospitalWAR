/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.pojo;

import java.io.Serializable;

/**
 *
 * @author ander
 */
public class ErrorDto implements Serializable {
    
    private String mensaje;
    
    private String fecha;

    public ErrorDto(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }        
    
}

