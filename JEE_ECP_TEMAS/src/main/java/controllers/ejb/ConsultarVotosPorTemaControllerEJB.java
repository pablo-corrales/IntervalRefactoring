package controllers.ejb;

import java.util.List;

import controllers.ConsultarVotosPorTemaController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;



public class ConsultarVotosPorTemaControllerEJB implements ConsultarVotosPorTemaController{
	
	@Override
	public List<Voto> ConsultarVotosPorTema(Integer temaID){
		
		DAOFactory.setFactory(new DAOJPAFactory());
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		return votoDAO.findVotoByTema(temaID);
	}
	
	@Override
    public List<Tema> listarTemas() {
        DAOFactory.setFactory(new DAOJPAFactory());
        TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
        return temaDAO.findAll();
    }

	
	
}
