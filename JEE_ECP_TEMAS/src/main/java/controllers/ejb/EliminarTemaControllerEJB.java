package controllers.ejb;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.daos.jpa.GenericDAOJPA;
import persistence.models.entities.Tema;


public class EliminarTemaControllerEJB implements EliminarTemaController{
	
	public void eliminarTema(Integer temaID){
		LogManager.getLogger(GenericDAOJPA.class).debug(">>>borrar tema ");
		DAOFactory.setFactory(new DAOJPAFactory());		
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
		Tema tema = temaDAO.read(temaID);
		votoDAO.deleteVotoByTemaID(tema);		
		temaDAO.deleteByID(temaID);
		
		
	}

	@Override
	public List<Tema> listarTemas() {
		DAOFactory.setFactory(new DAOJPAFactory());
		TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
		return temaDAO.findAll();
	}

	
}
