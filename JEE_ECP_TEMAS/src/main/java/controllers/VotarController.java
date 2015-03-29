package controllers;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public interface VotarController {
	
	List<Tema> listarTemas();
	
	void votar(Tema tema, Voto voto);

}
