/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "donacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donacion.findAll", query = "SELECT d FROM Donacion d")
    , @NamedQuery(name = "Donacion.findById", query = "SELECT d FROM Donacion d WHERE d.id = :id")
    , @NamedQuery(name = "Donacion.findByFechaDeEntrada", query = "SELECT d FROM Donacion d WHERE d.fechaDeEntrada = :fechaDeEntrada")
    , @NamedQuery(name = "Donacion.findByCantidadDonada", query = "SELECT d FROM Donacion d WHERE d.cantidadDonada = :cantidadDonada")
    , @NamedQuery(name = "Donacion.findByBienDonado", query = "SELECT d FROM Donacion d WHERE d.bienDonado = :bienDonado")})
public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fechaDeEntrada")
    @Temporal(TemporalType.DATE)
    private Date fechaDeEntrada;
    @Basic(optional = false)
    @Column(name = "cantidadDonada")
    private int cantidadDonada;
    @Basic(optional = false)
    @Column(name = "bienDonado")
    private String bienDonado;
    @Basic(optional = false)
    @Lob
    @Column(name = "evidenciaDonacion")
    private String evidenciaDonacion;
    @JoinColumn(name = "tipoDonacion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDonacion tipoDonacion;
    @JoinColumn(name = "donante", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Donante donante;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;

    public Donacion() {
    }

    public Donacion(Integer id) {
        this.id = id;
    }

    public Donacion(Integer id, Date fechaDeEntrada, int cantidadDonada, String bienDonado, String evidenciaDonacion) {
        this.id = id;
        this.fechaDeEntrada = fechaDeEntrada;
        this.cantidadDonada = cantidadDonada;
        this.bienDonado = bienDonado;
        this.evidenciaDonacion = evidenciaDonacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(Date fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public int getCantidadDonada() {
        return cantidadDonada;
    }

    public void setCantidadDonada(int cantidadDonada) {
        this.cantidadDonada = cantidadDonada;
    }

    public String getBienDonado() {
        return bienDonado;
    }

    public void setBienDonado(String bienDonado) {
        this.bienDonado = bienDonado;
    }

    public String getEvidenciaDonacion() {
        return evidenciaDonacion;
    }

    public void setEvidenciaDonacion(String evidenciaDonacion) {
        this.evidenciaDonacion = evidenciaDonacion;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public Usuario getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Usuario empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donacion)) {
            return false;
        }
        Donacion other = (Donacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Donacion[ id=" + id + " ]";
    }
    
}
