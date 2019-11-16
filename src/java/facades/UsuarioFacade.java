/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SIupuiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public Usuario login (Usuario usuario) {
        Usuario usuarioLogin = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.documento =?1  AND u.pass =?2");
            query.setParameter(1, usuario.getDocumento());
            query.setParameter(2, usuario.getPass());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuarioLogin = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return usuarioLogin;
        
    }
    
}
