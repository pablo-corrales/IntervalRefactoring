package persistence.models.daos;

import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
    	
    	if (factory == null) {
            factory = new DAOJPAFactory();
        }
        
        return factory;
    }
    
    public abstract TemaDAO getTemaDAO();
    
    public abstract VotoDAO getVotoDAO();

}
