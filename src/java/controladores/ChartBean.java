/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import entidades.Donacion;
import facades.DonacionFacade;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Jonathan
 */
@Named(value = "chartBean")
@ViewScoped
public class ChartBean implements Serializable {

    @EJB
    private DonacionFacade donacionFacade;
    private List<Donacion> listaDonacion;
    private BarChartModel barra;
    private PieChartModel pastel;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
    }

    public void listar() {

        listaDonacion = donacionFacade.findAll();
        graficar();

    }

    public void graficar() {

        barra = new BarChartModel();

        for (int i = 0; i < donacionFacade.listar().size();) {
            ChartSeries serie = new BarChartSeries();
            if (donacionFacade.listar().get(i).getCantidadDonada() != 0)   {
                serie.setLabel(donacionFacade.listar().get(i).getBienDonado());
                serie.set(donacionFacade.listar().get(i).getDonante(),donacionFacade.listar().get(i).getCantidadDonada());
                barra.addSeries(serie);
            }

        }
        
        barra.setTitle("Cantidad de donaciones");
        barra.setLegendPosition("ne");
        barra.setShowPointLabels(false);
        barra.setAnimate(true);
        
        
        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("Tipo de donaciòn");
                
        Axis yAxis = barra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de la donacion");
        yAxis.setMin(0);
        yAxis.setMax(100000);
        

    }

    public DonacionFacade getDonacionFacade() {
        return donacionFacade;
    }

    public void setDonacionFacade(DonacionFacade donacionFacade) {
        this.donacionFacade = donacionFacade;
    }

    public List<Donacion> getListaDonacion() {
        return listaDonacion;
    }

    public void setListaDonacion(List<Donacion> listaDonacion) {
        this.listaDonacion = listaDonacion;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

    public PieChartModel getPastel() {
        return pastel;
    }

    public void setPastel(PieChartModel pastel) {
        this.pastel = pastel;
    }



}
