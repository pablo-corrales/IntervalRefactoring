package controllers.ejb;

import controllers.VerVotacionesController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Tema;

public class VerVotacionesControllerEJB extends ControllerEJB implements VerVotacionesController {
	
	@Override
    public Integer numeroVotosporTema(Tema tema) {
        DAOFactory.setFactory(new DAOJPAFactory());
        VotoDAO dao = DAOFactory.getFactory().getVotoDAO();
        return (dao.findVotoByTema(tema.getId()).size());
        
    }
	

}
