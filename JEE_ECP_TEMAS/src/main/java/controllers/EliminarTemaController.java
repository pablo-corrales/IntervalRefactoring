package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface EliminarTemaController {
	
	List<Tema> listarTemas();
	
	void eliminarTema(Tema tema);
	

}
