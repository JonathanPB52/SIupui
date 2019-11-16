/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;


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
@Named(value = "reporteVentaControlador")
@SessionScoped
public class ReporteVentaControlador implements Serializable{

    public ReporteVentaControlador() {
    }
    
    private String TipoDeMaterial;

    public String getTipoDeMaterial() {
        return TipoDeMaterial;
    }

    public void setTipoDeMaterial(String TipoDeMaterial) {
        this.TipoDeMaterial = TipoDeMaterial;
    }

    

    
    public void descargarVentas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            VentaEntidadReporte reporteVenta = new VentaEntidadReporte();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            String ruta = servletContext.getRealPath("//Reportes//VentaReporte.jasper");
            reporteVenta.DescargarVenta(ruta, this.TipoDeMaterial);
            FacesContext.getCurrentInstance().getResponseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El reporte a sido generado exitosamente","exito"));

        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El reporte no a sido generado","Error"));
        }

    }
    
}
