package controllers;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public interface VotarController {
	
	void votar(Tema tema, Voto voto);

}
