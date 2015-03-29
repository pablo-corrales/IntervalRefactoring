package controllers.ejb;

import java.util.List;

import controllers.VotarController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotarControllerEJB implements VotarController{
	
	@Override
    public List<Tema> listarTemas() {
        DAOFactory.setFactory(new DAOJPAFactory());
        TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
        return temaDAO.findAll();
    }

	@Override
	public void votar(Tema tema, Voto voto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
