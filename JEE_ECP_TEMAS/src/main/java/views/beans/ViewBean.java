package views.beans;

import java.io.Serializable;

import controllers.ControllerFactory;
import controllers.ejb.ControllerFactoryEJB;

import javax.faces.bean.ManagedProperty;

public class ViewBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{controllerFactoryEJB}")
    private ControllerFactory controllerFactory;
    
    public ViewBean() {
   }
    
    protected ControllerFactory getControllerFactory() {
    	if(controllerFactory == null)
    		controllerFactory = new ControllerFactoryEJB();
        return controllerFactory;
    }

    
    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    
}