package views.beans;

import java.io.Serializable;
import controllers.ControllerFactory;
import javax.faces.bean.ManagedProperty;

public class ViewBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{controllerFactoryEJB}")
    private ControllerFactory controllerFactory;
    
    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    
}