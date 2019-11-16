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
@Table(name = "tipo_donacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDonacion.findAll", query = "SELECT t FROM TipoDonacion t")
    , @NamedQuery(name = "TipoDonacion.findById", query = "SELECT t FROM TipoDonacion t WHERE t.id = :id")
    , @NamedQuery(name = "TipoDonacion.findByTipoDonacion", query = "SELECT t FROM TipoDonacion t WHERE t.tipoDonacion = :tipoDonacion")})
public class TipoDonacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipoDonacion")
    private String tipoDonacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDonacion")
    private List<Donacion> donacionList;

    public TipoDonacion() {
    }

    public TipoDonacion(Integer id) {
        this.id = id;
    }

    public TipoDonacion(Integer id, String tipoDonacion) {
        this.id = id;
        this.tipoDonacion = tipoDonacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(String tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    @XmlTransient
    @JsonIgnore
    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
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
        if (!(object instanceof TipoDonacion)) {
            return false;
        }
        TipoDonacion other = (TipoDonacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoDonacion[ id=" + id + " ]";
    }
    
}
