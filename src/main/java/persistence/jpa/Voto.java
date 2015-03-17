package persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voto {
	 @Id
	 @GeneratedValue
	 private Integer id;
	 
	 private Integer totalPuntos;
	 private Integer nivelEstudios;
	 private String ip;
	 @ManyToOne
	 @JoinColumn
	 private Tema tema;
	 
	public Voto() {
	}
	
	public Voto(Integer totalPuntos, Integer nivelEstudios, String ip, Tema tema) {
		this.totalPuntos = totalPuntos;
		this.nivelEstudios = nivelEstudios;
		this.ip = ip;
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(Integer totalPuntos) {
		this.totalPuntos = totalPuntos;
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
