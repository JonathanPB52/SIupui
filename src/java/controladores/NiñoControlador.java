/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Acudiente;
import entidades.AfiliacionMedica;
import entidades.Curso;
import entidades.EdadNino;
import entidades.Nino;
import entidades.TipoDocumento;
import facades.AcudienteFacade;
import facades.AfiliacionMedicaFacade;
import facades.CursoFacade;
import facades.EdadNinoFacade;
import facades.NinoFacade;
import facades.TipoDocumentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.websocket.SendHandler;

/**
 *
 * @author Jonhy
 */
@Named(value = "NiñoControlador")
@SessionScoped
@ManagedBean

public class NiñoControlador implements Serializable {

    public NiñoControlador() {
    }

    @EJB
    private NinoFacade ninoFacade;
    Nino nino;

    @EJB
    private CursoFacade cursoFacade;
    Curso curso;

    @EJB
    private AfiliacionMedicaFacade afiliacionMedicaFacade;
    AfiliacionMedica afiliacionMedica;

    @EJB
    private EdadNinoFacade edadNinoFacade;
    EdadNino edadNino;

    @EJB
    private AcudienteFacade acudienteFacade;
    Acudiente acudiente;

    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    TipoDocumento tipoDocumento;

    @PostConstruct

    public void init() {

        nino = new Nino();
        curso = new Curso();
        afiliacionMedica = new AfiliacionMedica();
        edadNino = new EdadNino();
        acudiente = new Acudiente();
        tipoDocumento = new TipoDocumento();

    }

    int IDtipoDocumento;

    public NinoFacade getNinoFacade() {
        return ninoFacade;
    }

    public void setNinoFacade(NinoFacade ninoFacade) {
        this.ninoFacade = ninoFacade;
    }

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
    }

    public CursoFacade getCursoFacade() {
        return cursoFacade;
    }

    public void setCursoFacade(CursoFacade cursoFacade) {
        this.cursoFacade = cursoFacade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public AfiliacionMedicaFacade getAfiliacionMedicaFacade() {
        return afiliacionMedicaFacade;
    }

    public void setAfiliacionMedicaFacade(AfiliacionMedicaFacade afiliacionMedicaFacade) {
        this.afiliacionMedicaFacade = afiliacionMedicaFacade;
    }

    public AfiliacionMedica getAfiliacionMedica() {
        return afiliacionMedica;
    }

    public void setAfiliacionMedica(AfiliacionMedica afiliacionMedica) {
        this.afiliacionMedica = afiliacionMedica;
    }

    public EdadNinoFacade getEdadNinoFacade() {
        return edadNinoFacade;
    }

    public void setEdadNinoFacade(EdadNinoFacade edadNinoFacade) {
        this.edadNinoFacade = edadNinoFacade;
    }

    public EdadNino getEdadNino() {
        return edadNino;
    }

    public void setEdadNino(EdadNino edadNino) {
        this.edadNino = edadNino;
    }

    public AcudienteFacade getAcudienteFacade() {
        return acudienteFacade;
    }

    public void setAcudienteFacade(AcudienteFacade acudienteFacade) {
        this.acudienteFacade = acudienteFacade;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }

    public void setTipoDocumentoFacade(TipoDocumentoFacade tipoDocumentoFacade) {
        this.tipoDocumentoFacade = tipoDocumentoFacade;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    //tipo documento
    public int getIDtipoDocumento() {
        return IDtipoDocumento;
    }

    public void setIDtipoDocumento(int IDtipoDocumento) {
        this.IDtipoDocumento = IDtipoDocumento;
    }

    //Metodos
    public String Registrar() {
        
        String mensaje;

        try {

            IDtipoDocumento = 4;

            nino.setAcudienteNino(acudienteFacade.find(acudiente.getId()));
            nino.setIdCurso(cursoFacade.find(curso.getId()));
            nino.setAfiliacionMedicaNino(afiliacionMedicaFacade.find(afiliacionMedica.getId()));
            nino.setEdadNino(edadNinoFacade.find(edadNino.getId()));
            nino.setTipoDocumento(tipoDocumentoFacade.find(IDtipoDocumento));
            ninoFacade.create(nino);
            nino = new Nino();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro, fue todo un exito", "exito"));
            
            mensaje = "NinoConfirmacion";

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error verifica que los datos sean correctos", "error"));
            
            mensaje = "RegistroError";
        }
        
        return mensaje;
    }

    public String Eliminar(Nino nino) {

        ninoFacade.remove(nino);
        this.nino = new Nino();
        return "listarYeditarNino";

    }

    public String PreActualizar(Nino nino) {

        this.nino = nino;
        return "editarNino";
    }

    public String Actualizar() {

        IDtipoDocumento = 4;

        nino.setAcudienteNino(acudienteFacade.find(acudiente.getId()));
        nino.setIdCurso(cursoFacade.find(curso.getId()));
        nino.setAfiliacionMedicaNino(afiliacionMedicaFacade.find(afiliacionMedica.getId()));
        nino.setEdadNino(edadNinoFacade.find(edadNino.getId()));
        nino.setTipoDocumento(tipoDocumentoFacade.find(IDtipoDocumento));
        ninoFacade.edit(nino);
        nino = new Nino();
        return "listarYeditarNino";

    }

    public List<Nino> ConsultarTodos() {

        return ninoFacade.findAll();
    }
    public String ConsultarUNO(Nino nino) {

        this.nino = nino;
        return "ConsultarNiñoUNO";
    }
    public String ConsultarDOS(Nino nino) {

        this.nino = nino;
        return "ConsultarNiñoDOS";
    }

}
