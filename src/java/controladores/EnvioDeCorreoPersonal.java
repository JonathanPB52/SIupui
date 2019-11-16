/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jonathan
 */

@Named(value = "EnvioPersonalizado")
@SessionScoped

public class EnvioDeCorreoPersonal implements Serializable{

    public EnvioDeCorreoPersonal() {
    }
    
    private String correo;
    private String asunto;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public String EnvioCorreo(){
    
        String mensaje;
        try {
            
            envioCorreo correoE = new envioCorreo();
            correoE.enviarCorreo(correo, asunto);
            
            mensaje="Enviado";
        } catch (Exception e) {
            mensaje="Error";
        }
    
        return mensaje;
    }
    
}
