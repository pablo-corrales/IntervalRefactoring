package controllers;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public interface ConsultarVotosPorTemaController {

	List<Tema> listarTemas();
	
	List<Voto> ConsultarVotosPorTema(Integer temaID);

}
