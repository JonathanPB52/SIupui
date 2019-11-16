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
@Table(name = "edad_nino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EdadNino.findAll", query = "SELECT e FROM EdadNino e")
    , @NamedQuery(name = "EdadNino.findById", query = "SELECT e FROM EdadNino e WHERE e.id = :id")
    , @NamedQuery(name = "EdadNino.findByEdad", query = "SELECT e FROM EdadNino e WHERE e.edad = :edad")})
public class EdadNino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "edad")
    private String edad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edadNino")
    private List<Nino> ninoList;

    public EdadNino() {
    }

    public EdadNino(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @XmlTransient
    @JsonIgnore
    public List<Nino> getNinoList() {
        return ninoList;
    }

    public void setNinoList(List<Nino> ninoList) {
        this.ninoList = ninoList;
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
        if (!(object instanceof EdadNino)) {
            return false;
        }
        EdadNino other = (EdadNino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EdadNino[ id=" + id + " ]";
    }
    
}
