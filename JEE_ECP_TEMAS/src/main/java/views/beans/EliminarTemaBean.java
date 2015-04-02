package views.beans;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import controllers.EliminarTemaController;
import persistence.models.entities.Tema;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean {

	private static final long serialVersionUID = 1L;
	private static String identificadorAutorizado = "666";
	private EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
	private List<Tema> temas;
	private int idTema;
	private String mensajeBorrado;
	private String identificador;
	private boolean temaDesabilitado;
	private boolean borradoDesabilitado;
	
	public EliminarTemaBean() {
		super();
	}
		
	public boolean isBorradoDesabilitado() {
		return borradoDesabilitado;
	}

	public void setBorradoDesabilitado(boolean borradoDesabilitado) {
		this.borradoDesabilitado = borradoDesabilitado;
	}

	
	public boolean isTemaDesabilitado() {
		return temaDesabilitado;
	}


	public void setTemaDesabilitado(boolean temaDesabilitado) {
		this.temaDesabilitado = temaDesabilitado;
	}
	public String getMensajeBorrado() {
		return mensajeBorrado;
	}


	public void setMensajeBorrado(String mensajeBorrado) {
		this.mensajeBorrado = mensajeBorrado;
	}


	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
		this.mensajeBorrado="";
		this.temaDesabilitado = false;
		this.borradoDesabilitado = false;
		
		if (!identificadorAutorizado.equals(identificador)){
			this.mensajeBorrado = "No está autorizado a esta operación";
			this.temaDesabilitado = true;
			this.borradoDesabilitado = true;
		}
	}

	public List<Tema> getTemas() {
		return temas;
	}
	
	
	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
		
	}

	
	@PostConstruct
    public void update() {
		this.temas = eliminarTemaController.listarTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
        this.idTema = -1;
    }
	
	public String process(){
		eliminarTemaController.eliminarTema(idTema);
		return "home";
	}
}
