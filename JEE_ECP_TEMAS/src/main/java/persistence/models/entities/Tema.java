package persistence.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tema")
public class Tema {
	
	public static final String TABLE = "Tema";

    public static final String ID = "ID";
    
    @Id
    @GeneratedValue
    private Integer id;
    
    public static final String NOMBRE = "NOMBRE";
    private String nombre;
    
    public static final String PREGUNTA = "PREGUNTA";
    private String pregunta;
    
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Voto> votos;
    
    
	public Tema() {
	}

	public Tema(String nombre, String pregunta) {
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	
	public Tema(Integer id, String nombre, String pregunta) {
		this.id = id;
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
	
	
	 public List<Voto> getVotos() {
	        return votos;
	 }

	   public void setVotos(List<Voto> votos) {
	        this.votos = votos;
	   }

	    public void addVoto(Voto voto) {
	        if (this.votos == null) {
	            this.votos = new ArrayList<Voto>();
	        }
	        this.votos.add(voto);
	    }
}