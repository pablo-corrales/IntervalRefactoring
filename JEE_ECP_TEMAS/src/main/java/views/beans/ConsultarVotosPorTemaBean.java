package views.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import controllers.ConsultarVotosPorTemaController;

@ManagedBean
@ViewScoped
public class ConsultarVotosPorTemaBean extends ViewBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Tema> temas;
	private List<Voto> votos;
	private Map<String, Integer> votoTema = new HashMap<String, Integer>();
	
	
	public Map<String, Integer> getVotoTema() {
		return votoTema;
	}

	public void setVotoTema(Map<String, Integer> votoTema) {
		this.votoTema = votoTema;
	}

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
	
	

	public Map<String, Integer> update(HttpServletRequest request){
		ConsultarVotosPorTemaController consultarVotosPorTemaController = this.getControllerFactory().getConsultarVotosPorTemaController();
		this.temas = consultarVotosPorTemaController.listarTemas();	
				
		for(Tema tema: temas){		
			
			this.votos = consultarVotosPorTemaController.ConsultarVotosPorTema(tema);
			
			votoTema.put(tema.getNombre(), votos.size());
			
		}
		
		return votoTema;    
		

	}
	
	

}
