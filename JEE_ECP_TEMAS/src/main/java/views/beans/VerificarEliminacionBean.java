package views.beans;

import java.io.Serializable;

public class VerificarEliminacionBean  extends ViewBean implements Serializable{{
	
}
	private static final long serialVersionUID = 1L;
	private static String identificadorAutorizado = "666";
	private String mensajeBorrado;
	private String identificador;
	
	public VerificarEliminacionBean() {
		super();
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
	}
	
	public String process(){
		if(this.identificador.equals(VerificarEliminacionBean.identificadorAutorizado)){
			return "eliminarTema";
		}
		else{
			this.mensajeBorrado = "No se encuentra autorizado a borrar";
			return "verificarEliminacion";
		}
	}

}
