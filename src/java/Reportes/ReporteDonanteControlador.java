/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import EntidadesReportes.ActividadEntidadReporte;
import EntidadesReportes.BeneficiadoEntidadReporte;
import EntidadesReportes.DonanteEntidadReporte;
import EntidadesReportes.UsuarioEntidadReporte;
import EntidadesReportes.VentaEntidadReporte;
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
@Named(value = "reporteDonanteControlador")
@SessionScoped
public class ReporteDonanteControlador implements Serializable{

    public ReporteDonanteControlador() {
    }
    
    private String TipoDeTelefono;

    public String getTipoDeTelefono() {
        return TipoDeTelefono;
    }

    public void setTipoDeTelefono(String TipoDeTelefono) {
        this.TipoDeTelefono = TipoDeTelefono;
    }
    
    public void descargarDonante() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            DonanteEntidadReporte reporteDonante = new DonanteEntidadReporte();
            

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//DonanteReporte.jasper");
            reporteDonante.DescargarDonante(ruta, this.TipoDeTelefono);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
