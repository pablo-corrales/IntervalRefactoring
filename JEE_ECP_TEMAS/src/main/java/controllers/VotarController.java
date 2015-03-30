package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface VotarController {
	
	List<Tema> listarTemas();
	
	void votar(Integer idTema, Integer estudios, Integer puntuacion, String ip);

}
