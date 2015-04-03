package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.jpa.GenericDAOJPA;
import controllers.AddTemaController;
import controllers.ConsultarVotosPorTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;



@ManagedBean(name = "controllerFactoryEJB")
@ApplicationScoped
public class ControllerFactoryEJB extends ControllerFactory {

    private AddTemaController addTemaController;
    private VotarController votarController;
    private EliminarTemaController eliminarTemaController;
    private ConsultarVotosPorTemaController consultarVotosPorTemaController;


    @Override
    public AddTemaController getAddTemaController() {
        if (this.addTemaController == null) {
            this.addTemaController = new AddTemaControllerEJB();
        }
        return addTemaController;
    }
    
    @Override
	public VotarController getVotarController() {
   	 LogManager.getLogger(GenericDAOJPA.class).debug(">>>getvotarcontroller ");
		if (this.votarController == null) {
            this.votarController = new VotarControllerEJB();
        }
        return votarController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if( eliminarTemaController == null)
			eliminarTemaController = new EliminarTemaControllerEJB();
		return eliminarTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ConsultarVotosPorTemaController getConsultarVotosPorTemaController() {
		if( consultarVotosPorTemaController == null)
			consultarVotosPorTemaController = new ConsultarVotosPorTemaControllerEJB();
		return consultarVotosPorTemaController;
	}
	

}
