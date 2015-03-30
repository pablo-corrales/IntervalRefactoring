package controllers;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.utils.NivelEstudios;

public interface VotarController {
	
	List<Tema> listarTemas();
	
	void votar(int idTema, NivelEstudios estudios, int puntuacion, String ip);

}
