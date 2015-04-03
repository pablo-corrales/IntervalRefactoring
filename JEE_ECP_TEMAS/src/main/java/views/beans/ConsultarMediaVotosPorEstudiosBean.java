package views.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;
import controllers.ConsultarMediaVotosPorEstudiosController;

@ManagedBean
@ViewScoped
public class ConsultarMediaVotosPorEstudiosBean extends ViewBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Voto> votos;
	private Map<String, Double> votoEstudios = new HashMap<String, Double>();
	
	
	public List<Voto> getVotos() {
		return votos;
	}


	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}


	
	public Map<String, Double> getVotoEstudios() {
		return votoEstudios;
	}


	public void setVotoEstudios(Map<String, Double> votoEstudios) {
		this.votoEstudios = votoEstudios;
	}


	public Map<String, Double> update(){
		Integer totalPuntaje;
		double promedio;
				
		ConsultarMediaVotosPorEstudiosController consultarMediaVotosPorEstudiosController = this.getControllerFactory().getConsultarMediaVotosPorEstudiosController();
		this.votos = consultarMediaVotosPorEstudiosController.listarVotos();
				
		for (NivelEstudios estudio : NivelEstudios.values()) {
			this.votos = consultarMediaVotosPorEstudiosController.ConsultarVotosPorEstudios(estudio.ordinal());
			totalPuntaje = 0;
			for (Voto voto: votos){
				totalPuntaje += voto.getPuntaje();			
			}
			promedio = totalPuntaje / votos.size();
			votoEstudios.put(estudio.name(), promedio);
			//votoEstudios.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
		}
		
		return votoEstudios;    
		

	}
	
}
