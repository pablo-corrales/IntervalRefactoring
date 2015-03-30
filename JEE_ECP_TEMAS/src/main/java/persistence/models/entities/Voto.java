package persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import persistence.models.utils.NivelEstudios;

@Entity
@Table(name = "Voto")
public class Voto {

	public static final String TABLE = "Voto";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer id;

	public static final String PUNTAJE = "puntaje";
	@Column(name = "puntaje")
	@Max(value = 10)
	@Min(value = 0)
	private Integer puntaje;

	public static final String NIVELESTUDIOS = "nivelEstudios";

	@Column(name = "nivelEstudios")
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public static final String IP = "ip";
	@Column(name = "ip")
	private String ip;
	
	public static final String TEMA = "TEMA_ID";
	
	@ManyToOne
	@JoinColumn(name = TEMA, nullable = false)
	private Tema tema;
	
	public Voto() {
	}

	
	public Voto(Integer puntaje, NivelEstudios nivelEstudios, String ip) {
		this.puntaje = puntaje;
		this.nivelEstudios = nivelEstudios;
		this.ip = ip;
		
	}
	
	public Voto(Integer puntaje, NivelEstudios nivelEstudios, String ip, Tema tema) {
		this.puntaje = puntaje;
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

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
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