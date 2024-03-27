
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Secratario;
import persistencia.exceptions.NonexistentEntityException;

public class SecratarioJpaController implements Serializable {

    public SecratarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SecratarioJpaController(){
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologicoPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Secratario secratario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(secratario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Secratario secratario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            secratario = em.merge(secratario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = secratario.getId();
                if (findSecratario(id) == null) {
                    throw new NonexistentEntityException("The secratario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secratario secratario;
            try {
                secratario = em.getReference(Secratario.class, id);
                secratario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The secratario with id " + id + " no longer exists.", enfe);
            }
            em.remove(secratario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Secratario> findSecratarioEntities() {
        return findSecratarioEntities(true, -1, -1);
    }

    public List<Secratario> findSecratarioEntities(int maxResults, int firstResult) {
        return findSecratarioEntities(false, maxResults, firstResult);
    }

    private List<Secratario> findSecratarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Secratario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Secratario findSecratario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secratario.class, id);
        } finally {
            em.close();
        }
    }

    public int getSecratarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Secratario> rt = cq.from(Secratario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
