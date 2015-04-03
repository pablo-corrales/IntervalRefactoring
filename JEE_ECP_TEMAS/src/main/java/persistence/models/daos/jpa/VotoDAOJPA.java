package persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.VotoDAO;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotoDAOJPA extends GenericDAOJPA<Voto,Integer> implements VotoDAO {
	
    public VotoDAOJPA() {
        super(Voto.class);
    }
    
  

    public List<Voto> findVotoByTema(Tema tema) {
    	
    	EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Voto> criteriaQuery = criteriaBuilder.createQuery(Voto.class);

        // Se establece la clausula FROM
        Root<Voto> root = criteriaQuery.from(Voto.class);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
        Predicate p1 = criteriaBuilder.equal(root.get("tema"),tema);
        
        criteriaQuery.where(p1);

        // Se realiza la query
        TypedQuery<Voto> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<Voto> result = typedQuery.getResultList();
        entityManager.close();
        return result;
   
    }
    
    public List<Voto> findVotoByNivelEstudios(Integer nivelEstudios) {
    	
   	 
        EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Voto> criteriaQuery = criteriaBuilder.createQuery(Voto.class);

        // Se establece la clausula FROM
        Root<Voto> root = criteriaQuery.from(Voto.class);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
        Predicate p1 = criteriaBuilder.equal(root.get("nivelEstudios").as(Integer.class),nivelEstudios);
        
        criteriaQuery.where(p1);

        // Se realiza la query
        TypedQuery<Voto> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<Voto> result = typedQuery.getResultList();
        entityManager.close();
        return result;
    }
    
    
    public void deleteVotoByTemaID(Tema tema) {
    	EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
   	  
    	  // create delete
    	  CriteriaDelete<Voto> delete = criteriaBuilder.createCriteriaDelete(Voto.class);
    	  
    	  // set the root class
    	  Root<Voto> e = delete.from(Voto.class);
    	  
    	  // set where clause
    	  delete.where(criteriaBuilder.equal(e.get("tema"), tema));
    	  
    	 
    	  try {
              entityManager.getTransaction().begin();
              // perform update
        	  entityManager.createQuery(delete).executeUpdate();
              entityManager.getTransaction().commit();
            
          } catch (Exception ex) {
              LogManager.getLogger(GenericDAOJPA.class).error("delete: " + ex);
              if (entityManager.getTransaction().isActive())
                  entityManager.getTransaction().rollback();
          } finally {
              entityManager.close();
         }   
    }
    
 }