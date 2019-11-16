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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l")
    , @NamedQuery(name = "Localidad.findById", query = "SELECT l FROM Localidad l WHERE l.id = :id")
    , @NamedQuery(name = "Localidad.findByNombreLocalidad", query = "SELECT l FROM Localidad l WHERE l.nombreLocalidad = :nombreLocalidad")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreLocalidad")
    private String nombreLocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private List<Comedor> comedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private List<Beneficiado> beneficiadoList;

    public Localidad() {
    }

    public Localidad(Integer id) {
        this.id = id;
    }

    public Localidad(Integer id, String nombreLocalidad) {
        this.id = id;
        this.nombreLocalidad = nombreLocalidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    @XmlTransient
    @JsonIgnore
    public List<Comedor> getComedorList() {
        return comedorList;
    }

    public void setComedorList(List<Comedor> comedorList) {
        this.comedorList = comedorList;
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
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Localidad[ id=" + id + " ]";
    }
    
}
