package persistence.models.daos;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        assert factory != null;
        return factory;
    }
    
    public abstract TemaDAO getTemaDAO();
    
    public abstract VotoDAO getVotoDAO();

}
