/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Actividad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonhy
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "SIupuiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }
    
    
    //Creacion de lista tipo array list
    public List<Object[]> reportePermiso(){
     List<Object[]> listaactividadesroles = new ArrayList<>();
     
     //Creacion de objeto de tipo Query
     Query query;
        try {
            query=em.createNativeQuery("SELECT actividades.fechaActividad AS actividades_fechaActividad,actividades descripcion AS actividades_descripcion,actividades.curso AS actividades_curso,cursos.cantidadninos AS cursos cantidadninos,cursos.nombreCurso AS cursos_nombreCurso,cursos.encargado AS cursos_encargado FROM cursos cursos INNER JOIN actividades actividades ON cursos.Id = actividades.curso");
            listaactividadesroles = query.getResultList();
        } catch (Exception e) {
            
            System.out.println("Eres un pendejo =" + e);
        }
        return listaactividadesroles;
    }
}
