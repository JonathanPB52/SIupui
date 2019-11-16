/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresGraficos;

import entidades.Donacion;
import facades.DonacionFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Jonathan
 */
@Named(value = "donacionBena")
@ViewScoped
public class DonacionBena implements Serializable{

    @EJB
    private DonacionFacade donaFacade;
    
    private List<Donacion> listado;
    
    private BarChartModel barra;
    
    public DonacionBena() {
    }
    
    public void listar(){
        listado=donaFacade.listar();
        graficar();
    }
    
    public void graficar(){
        barra=new BarChartModel();
        
        for(int i=0; i< donaFacade.listar().size(); i++) {
            ChartSeries series = new BarChartSeries();
            
            series.setLabel(donaFacade.listar().get(i).getTipoDonacion().getTipoDonacion());
            series.set(donaFacade.listar().get(i).getTipoDonacion().getTipoDonacion(), donaFacade.listar().get(i).getCantidadDonada());
            barra.addSeries(series);
        }
        
        barra.setTitle("Donaciones");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        
        Axis xAxis=barra.getAxis(AxisType.X);
        xAxis.setLabel("Tipo donacion");
        
        Axis yAxix=barra.getAxis(AxisType.Y);
        yAxix.setLabel("Cantidad recaudada");
        yAxix.setMin(5);
        yAxix.setMax(9000000);
    }

    public List<Donacion> getListado() {
        return listado;
    }

    public void setListado(List<Donacion> listado) {
        this.listado = listado;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }
    
    
    
}
