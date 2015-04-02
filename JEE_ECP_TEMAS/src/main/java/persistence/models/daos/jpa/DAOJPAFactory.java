package persistence.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;

public class DAOJPAFactory extends DAOFactory {
	
    private static final String PERSISTENCE_UNIT = "JEE_ECP_TEMAS";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DAOJPAFactory() {
        LogManager.getLogger(DAOJPAFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
    	if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return entityManagerFactory;
    }
    
    public static void dropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    }

    @Override
    public TemaDAO getTemaDAO() {
        return new TemaDAOJPA();
    }

    @Override
    public VotoDAO getVotoDAO() {
        return new VotoDAOJPA();
    }

}
