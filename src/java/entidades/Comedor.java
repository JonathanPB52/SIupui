/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "comedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comedor.findAll", query = "SELECT c FROM Comedor c")
    , @NamedQuery(name = "Comedor.findById", query = "SELECT c FROM Comedor c WHERE c.id = :id")
    , @NamedQuery(name = "Comedor.findByCapacidad", query = "SELECT c FROM Comedor c WHERE c.capacidad = :capacidad")})
public class Comedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private String capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomedor")
    private List<Novedad> novedadList;
    @JoinColumn(name = "encargado", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuario encargado;
    @JoinColumn(name = "localidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Localidad localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomedor")
    private List<Beneficiado> beneficiadoList;

    public Comedor() {
    }

    public Comedor(Integer id) {
        this.id = id;
    }

    public Comedor(Integer id, String capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    @JsonIgnore
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Usuario encargado) {
        this.encargado = encargado;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @XmlTransient
    @JsonIgnore
    public List<Beneficiado> getBeneficiadoList() {
        return beneficiadoList;
    }

    public void setBeneficiadoList(List<Beneficiado> beneficiadoList) {
        this.beneficiadoList = beneficiadoList;
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
        if (!(object instanceof Comedor)) {
            return false;
        }
        Comedor other = (Comedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comedor[ id=" + id + " ]";
    }
    
}
