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
@Table(name = "acudiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acudiente.findAll", query = "SELECT a FROM Acudiente a")
    , @NamedQuery(name = "Acudiente.findById", query = "SELECT a FROM Acudiente a WHERE a.id = :id")
    , @NamedQuery(name = "Acudiente.findByNombreAcudiente", query = "SELECT a FROM Acudiente a WHERE a.nombreAcudiente = :nombreAcudiente")
    , @NamedQuery(name = "Acudiente.findBySegundoNombre", query = "SELECT a FROM Acudiente a WHERE a.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Acudiente.findByApellidoAcudiente", query = "SELECT a FROM Acudiente a WHERE a.apellidoAcudiente = :apellidoAcudiente")
    , @NamedQuery(name = "Acudiente.findBySegundoApellido", query = "SELECT a FROM Acudiente a WHERE a.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Acudiente.findByTelAcudiente", query = "SELECT a FROM Acudiente a WHERE a.telAcudiente = :telAcudiente")
    , @NamedQuery(name = "Acudiente.findByDocumento", query = "SELECT a FROM Acudiente a WHERE a.documento = :documento")
    , @NamedQuery(name = "Acudiente.findByCorreoAcudiente", query = "SELECT a FROM Acudiente a WHERE a.correoAcudiente = :correoAcudiente")})
public class Acudiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreAcudiente")
    private String nombreAcudiente;
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "apellidoAcudiente")
    private String apellidoAcudiente;
    @Basic(optional = false)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "telAcudiente")
    private String telAcudiente;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Column(name = "correoAcudiente")
    private String correoAcudiente;
    @JoinColumn(name = "tipoDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "tipoTelefono", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipotelefono tipoTelefono;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acudienteNino")
    private List<Nino> ninoList;

    public Acudiente() {
    }

    public Acudiente(Integer id) {
        this.id = id;
    }

    public Acudiente(Integer id, String nombreAcudiente, String apellidoAcudiente, String segundoApellido, String telAcudiente, String documento) {
        this.id = id;
        this.nombreAcudiente = nombreAcudiente;
        this.apellidoAcudiente = apellidoAcudiente;
        this.segundoApellido = segundoApellido;
        this.telAcudiente = telAcudiente;
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelAcudiente() {
        return telAcudiente;
    }

    public void setTelAcudiente(String telAcudiente) {
        this.telAcudiente = telAcudiente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreoAcudiente() {
        return correoAcudiente;
    }

    public void setCorreoAcudiente(String correoAcudiente) {
        this.correoAcudiente = correoAcudiente;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Tipotelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(Tipotelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public Usuario getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Usuario empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
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
        if (!(object instanceof Acudiente)) {
            return false;
        }
        Acudiente other = (Acudiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Acudiente[ id=" + id + " ]";
    }
    
}
