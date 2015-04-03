package views.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import controllers.ConsultarVotosPorTemaController;

@ManagedBean
@ViewScoped
public class ConsultarVotosPorTemaBean extends ViewBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Tema> temas;
	private List<Voto> votos;
	private static final Integer NUMERO_MAXIMO_TEMAS = 5;
	Integer[] DatosVotos = new Integer[NUMERO_MAXIMO_TEMAS];
	
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public void upate(){
		ConsultarVotosPorTemaController consultarVotosPorTemaController = this.getControllerFactory().getConsultarVotosPorTemaController();
		this.temas = consultarVotosPorTemaController.listarTemas();	
		
		Integer contadorVotos = 0;
		for(Tema tema: temas){			
			this.votos = consultarVotosPorTemaController.ConsultarVotosPorTema(tema.getId());
			DatosVotos[contadorVotos] = votos.size();
			contadorVotos++;
		}
		
		
	}

}
