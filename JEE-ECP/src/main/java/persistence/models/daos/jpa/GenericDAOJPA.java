package persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.GenericDAO;

public class GenericDAOJPA<T, ID> implements GenericDAO<T, ID> {
    private Class<T> persistentClass;

    public GenericDAOJPA(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void create(T entity) {
        EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDAOJPA.class).debug("create: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDAOJPA.class).error("create: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T read(ID id) {
        EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        entityManager.close();
        return entity;
    }

    // Cuando en una relación de colección se elimina un miembro de la
    // colección, se debe borrar de la tabla explicitamente
    @Override
    public void update(T entity) {
        EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDAOJPA.class).debug("update: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDAOJPA.class).error("update: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }


    @Override
    public List<T> findAll() {
        EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // No existen predicados

        // Se realiza la query
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<T> result = typedQuery.getResultList();
        entityManager.close();
        return result;
    }

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(ID id) {
		EntityManager entityManager = DAOJPAFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        if (entity != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(GenericDAOJPA.class).debug("delete: " + entity);
            } catch (Exception e) {
                LogManager.getLogger(GenericDAOJPA.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
		
	}


}
