package persistence.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Voto {
	
	public static final String TABLE = "Voto";

    public static final String ID = "ID";
    
	 @Id
	 @GeneratedValue
	 private Integer id;
	 
	 public static final String PUNTAJE = "puntaje";
	 private Integer puntaje;
	 
	 public static final String NIVELESTUDIOS = "nivelEstudios";
	 private Integer nivelEstudios;
	 
	 public static final String IP = "ip";
	 private String ip;
	 
	 
	 public static final String TEMA = "TEMA_ID";
	    // Relación unidireccional: 1:0..1
	    // relación mapeada aqui
	    // Se aplica cascada
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn
	    private Tema tema;
	 
	 
	 
	public Voto() {
	}
	
	public Voto(Integer puntaje, Integer nivelEstudios, String ip) {
		this.puntaje = puntaje;
		this.nivelEstudios = nivelEstudios;
		this.ip = ip;
		
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
        this.id = id;
    }
	
	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Integer getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(Integer nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	 
}