package controllers.ejb;

import java.util.List;

import persistence.models.daos.DAOFactory;

import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Voto;
import controllers.ConsultarMediaVotosPorEstudiosController;

public class ConsultarMediaVotosPorEstudiosControllerEJB implements ConsultarMediaVotosPorEstudiosController{
		
		@Override
		public List<Voto> ConsultarVotosPorEstudios(Integer nivelEstudios) {
			DAOFactory.setFactory(new DAOJPAFactory());
			VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
			return votoDAO.findVotoByNivelEstudios(nivelEstudios);
		}
		
		@Override
	    public List<Voto> listarVotos() {
	        DAOFactory.setFactory(new DAOJPAFactory());
	        VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
	        return votoDAO.findAll();
	    }
		
}
