package controllers.ejb;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.daos.jpa.GenericDAOJPA;
import persistence.models.entities.Tema;


public class EliminarTemaControllerEJB implements EliminarTemaController{
	
	public void eliminarTema(Tema tema){
		LogManager.getLogger(GenericDAOJPA.class).debug(">>>borrar tema ");
		DAOFactory.setFactory(new DAOJPAFactory());
		TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
		temaDAO.delete(tema);
		
	}

	@Override
	public List<Tema> listarTemas() {
		DAOFactory.setFactory(new DAOJPAFactory());
		TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
		return temaDAO.findAll();
	}

	@Override
	public boolean verificarAutorizacion(String autorizacion) {
		return false;
	}

	}
