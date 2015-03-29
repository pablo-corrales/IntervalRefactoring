package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface AddTemaController {

	void addTema(Tema tema);
	
	List<Tema> mostrarTemas();

}
