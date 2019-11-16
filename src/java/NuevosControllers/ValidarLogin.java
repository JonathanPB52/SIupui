/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevosControllers;

import entidades.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jonhy
 */

@Named
@ViewScoped

public class ValidarLogin implements Serializable{
    public void verificarSession(){
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionLogin");
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
