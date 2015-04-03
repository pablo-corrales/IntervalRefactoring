package controllers;

public abstract class ControllerFactory {

	public abstract AddTemaController getAddTemaController();
	public abstract VotarController getVotarController();
	public abstract VerVotacionesController getVerVotacionesController();
	public abstract EliminarTemaController getEliminarTemaController();
	public abstract ConsultarVotosPorTemaController getConsultarVotosPorTemaController();
	public abstract ConsultarMediaVotosPorEstudiosController getConsultarMediaVotosPorEstudiosController();

}