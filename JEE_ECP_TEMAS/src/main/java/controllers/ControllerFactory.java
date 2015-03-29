package controllers;

public abstract class ControllerFactory {

	public abstract AddTemaController getAddTemaController();

	public abstract EliminarTemaController getEliminarTemaController();

	public abstract VerVotacionesController getVerVotacionesController();

	public abstract VotarController getVotarController();

}