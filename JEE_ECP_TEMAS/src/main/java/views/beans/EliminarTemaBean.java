package views.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;
import persistence.models.daos.jpa.GenericDAOJPA;
import persistence.models.entities.Tema;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean  implements Serializable{

	private static final long serialVersionUID = 1L;	
	private EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();	
	private List<Tema> temas;
	private Integer idTema;
	
	public EliminarTemaBean() {
		super();
		
	}
		
	public List<Tema> getTemas() {
		return temas;
	}
	
	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
		
	}
	
	@PostConstruct
    public void update() {
		LogManager.getLogger(GenericDAOJPA.class).debug(">>>update eliminarTemaBean ");
		this.temas = eliminarTemaController.listarTemas();
        this.temas.add(0, new Tema(0, "Temas...", ""));
        this.idTema = 0;
    }
	
	public String process(){
		eliminarTemaController.eliminarTema(idTema);
		return "home";
	}
	
	
	
}
