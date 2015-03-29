package persistence.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

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
        return entityManagerFactory;
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
