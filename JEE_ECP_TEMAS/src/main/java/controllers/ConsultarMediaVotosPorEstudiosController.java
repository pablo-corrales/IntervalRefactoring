package controllers;

import java.util.List;

import persistence.models.entities.Voto;

public interface ConsultarMediaVotosPorEstudiosController {

	List<Voto> ConsultarVotosPorEstudios(Integer nivelEstudios);
	List<Voto> listarVotos();

}


