package persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Tema {
	 public static final String TABLE = "Tema";
	 public static final String ID = "ID";
	
	
    @Id
    @GeneratedValue
    private Integer id;
    
    public static final String NOMBRE = "nombre";    
    private String nombre;
    
    public static final String PREGUNTA = "pregunta";    
    private String pregunta;
    
        
	public Tema() {
	}

	public Tema(String nombre, String pregunta) {
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	
	public Integer getId() {
		return id;
	}
		
	public void setId(Integer id) {
        this.id = id;
    }
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
}
