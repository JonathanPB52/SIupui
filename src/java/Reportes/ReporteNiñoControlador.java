/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import EntidadesReportes.NiñoEntidad;
import EntidadesReportes.UsuarioEntidadReporte;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
/**
 *
 * @author Jonathan
 */

@Named(value = "reporteNiñoControlador")
@SessionScoped

public class ReporteNiñoControlador implements Serializable{

    public ReporteNiñoControlador() {
    }
    
    private String NombreCurso;

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }
    
    public void descargarNiños() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            NiñoEntidad reporteNino = new NiñoEntidad();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//NiñoReporte.jasper");
            reporteNino.DescargarNiños(ruta, this.NombreCurso);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
