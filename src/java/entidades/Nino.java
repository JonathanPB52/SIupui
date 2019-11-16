/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "ninos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nino.findAll", query = "SELECT n FROM Nino n")
    , @NamedQuery(name = "Nino.findById", query = "SELECT n FROM Nino n WHERE n.id = :id")
    , @NamedQuery(name = "Nino.findByNombreNino", query = "SELECT n FROM Nino n WHERE n.nombreNino = :nombreNino")
    , @NamedQuery(name = "Nino.findBySegundoNombre", query = "SELECT n FROM Nino n WHERE n.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Nino.findByApellidoNino", query = "SELECT n FROM Nino n WHERE n.apellidoNino = :apellidoNino")
    , @NamedQuery(name = "Nino.findBySegundoApellido", query = "SELECT n FROM Nino n WHERE n.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Nino.findByDocumento", query = "SELECT n FROM Nino n WHERE n.documento = :documento")})
public class Nino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombreNino")
    private String nombreNino;
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "apellidoNino")
    private String apellidoNino;
    @Basic(optional = false)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Column(name = "documento")
    private String documento;
    @JoinColumn(name = "acudienteNino", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Acudiente acudienteNino;
    @JoinColumn(name = "afiliacionMedicaNino", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private AfiliacionMedica afiliacionMedicaNino;
    @JoinColumn(name = "edadNino", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private EdadNino edadNino;
    @JoinColumn(name = "idCurso", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Curso idCurso;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "Id")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    @JoinColumn(name = "empleadoEncargado", referencedColumnName = "Id")
    @ManyToOne
    private Usuario empleadoEncargado;

    public Nino() {
    }

    public Nino(Integer id) {
        this.id = id;
    }

    public Nino(Integer id, String nombreNino, String apellidoNino, String segundoApellido) {
        this.id = id;
        this.nombreNino = nombreNino;
        this.apellidoNino = apellidoNino;
        this.segundoApellido = segundoApellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreNino() {
        return nombreNino;
    }

    public void setNombreNino(String nombreNino) {
        this.nombreNino = nombreNino;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoNino() {
        return apellidoNino;
    }

    public void setApellidoNino(String apellidoNino) {
        this.apellidoNino = apellidoNino;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Acudiente getAcudienteNino() {
        return acudienteNino;
    }

    public void setAcudienteNino(Acudiente acudienteNino) {
        this.acudienteNino = acudienteNino;
    }

    public AfiliacionMedica getAfiliacionMedicaNino() {
        return afiliacionMedicaNino;
    }

    public void setAfiliacionMedicaNino(AfiliacionMedica afiliacionMedicaNino) {
        this.afiliacionMedicaNino = afiliacionMedicaNino;
    }

    public EdadNino getEdadNino() {
        return edadNino;
    }

    public void setEdadNino(EdadNino edadNino) {
        this.edadNino = edadNino;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        if (!(object instanceof Nino)) {
            return false;
        }
        Nino other = (Nino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Nino[ id=" + id + " ]";
    }
    
}
