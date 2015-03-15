package persistence.models.daos.jpa;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.TemaDAO;

public class DAOJPAFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private EntityManager em;

    public DAOJPAFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public EntityManager getEm() {
        if (!em.isOpen()) {
            this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
                    .createEntityManager();
        }
        return em;
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
