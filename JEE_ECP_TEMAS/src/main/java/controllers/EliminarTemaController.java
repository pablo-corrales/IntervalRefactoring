package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface EliminarTemaController {
	
	List<Tema> listarTemas();
	
	void eliminarTema(Integer temaID);

	boolean verificarAutorizacion(String autorizacion);
	

}
