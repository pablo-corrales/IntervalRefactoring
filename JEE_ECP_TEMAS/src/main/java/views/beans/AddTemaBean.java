package views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import persistence.models.entities.Tema;
import controllers.AddTemaController;


@ManagedBean
public class AddTemaBean extends ViewBean {

    private static final long serialVersionUID = 1L;

    private Tema tema;

    @PostConstruct
    public void init() {
        this.tema = new Tema();
    }

    public AddTemaBean() {
    }

    public AddTemaBean(Tema tema) {
        this.tema = tema;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String process() {
        AddTemaController addTemaController = this.getControllerFactory().getAddTemaController();
        addTemaController.addTema(this.getTema());
        this.setTema(new Tema());
        return null;
    }
}