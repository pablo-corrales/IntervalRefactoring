package controllers.ejb;

import java.util.List;

import controllers.VotarController;
import persistence.models.daos.DAOFactory;
import persistence.models.daos.TemaDAO;
import persistence.models.daos.VotoDAO;
import persistence.models.daos.jpa.DAOJPAFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotarControllerEJB implements VotarController{
	
	
	public void votar(Integer idTema, Integer estudios, Integer puntuacion, String ip){
		DAOFactory.setFactory(new DAOJPAFactory());
        TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
		Tema tema = temaDAO.read(idTema);
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		Voto voto = new Voto(puntuacion, estudios, ip, tema);
		votoDAO.create(voto);
	}
	
	
	@Override
    public List<Tema> listarTemas() {
        DAOFactory.setFactory(new DAOJPAFactory());
        TemaDAO temaDAO = DAOFactory.getFactory().getTemaDAO();
        return temaDAO.findAll();
    }
	
}
