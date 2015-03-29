package controllers.ejb;

import java.util.List;

import controllers.AddTemaController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Tema;

public class AddTemaControllerEJB implements AddTemaController{
	
	@Override
	public List<Tema> mostrarTemas() {
		List<Tema> listaTemas = DAOJPAFactory.getFactory().getTemaDAO().findAll();		
		return listaTemas;
	}

	@Override
	public void addTema(Tema tema) {
		DAOFactory.setFactory(new DAOJPAFactory());
        TemaDAO dao = DAOFactory.getFactory().getTemaDAO();
        dao.create(tema);
		
	}

}
