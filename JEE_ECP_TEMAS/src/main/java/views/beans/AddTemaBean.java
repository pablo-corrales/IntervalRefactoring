package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import persistence.models.entities.Tema;
import controllers.AddTemaController;


@ManagedBean
public class AddTemaBean extends ViewBean {

    private static final long serialVersionUID = 1L;
    private String nombre;
	private String pregunta;
	private Tema tema;
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    

    @PostConstruct
    public void init() {
        this.tema = new Tema();
    }

    public AddTemaBean() {
    }

    public AddTemaBean(Tema tema) {
        this.tema = tema;
        this.nombre = tema.getNombre();
        this.pregunta=tema.getPregunta();
    }

    public AddTemaBean(String nombre, String pregunta) {
        this.nombre=nombre;
        this.pregunta=pregunta;
    }
    
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String process() {
    	this.setTema(new Tema(this.getNombre(), this.getPregunta()));
        AddTemaController addTemaController = this.getControllerFactory().getAddTemaController();
        addTemaController.addTema(this.getTema());
       
        return null;
    }
}