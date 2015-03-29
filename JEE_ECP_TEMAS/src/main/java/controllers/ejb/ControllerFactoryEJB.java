package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.AddTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;


@ManagedBean(name = "controllerFactoryEJB")
@ApplicationScoped
public class ControllerFactoryEJB extends ControllerFactory {

    private AddTemaController addTemaController;
    private VotarController votarController;

    @Override
    public AddTemaController getAddTemaController() {
        if (this.addTemaController == null) {
            this.addTemaController = new AddTemaControllerEJB();
        }
        return addTemaController;
    }
    
    @Override
	public VotarController getVotarController() {
		if (this.votarController == null) {
            this.votarController = new VotarControllerEJB();
        }
        return votarController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
