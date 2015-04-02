package views.beans;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import persistence.models.daos.jpa.GenericDAOJPA;
import persistence.models.entities.Tema;
import controllers.ControllerFactory;
import controllers.ejb.ControllerFactoryEJB;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private ControllerFactory controllerFactory = new ControllerFactoryEJB();;

    private static String PATH_ROOT_VIEW = "/views/jsp/";
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String action = request.getPathInfo().substring(1);

        String view;
                
        switch (action) {
        case "addTema":
        	AddTemaBean addTemaBean = new AddTemaBean();      	
            request.setAttribute(action, addTemaBean);
            view = action;
            break;
        case "votar":
        	VotarBean votarBean = new VotarBean();
			request.setAttribute(action, votarBean);
			votarBean.update(request.getRemoteAddr());
			view = action;
      
			break;
        case "eliminarTema":
			EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
			request.setAttribute(action, eliminarTemaBean);
			eliminarTemaBean.update();
			view = action;
			break;
        default:
            view = "home";
        }
                            
         this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp").forward(request, response);
       
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getPathInfo().substring(1);
        Tema tema;
        String view="home";
        String id;
        int idTema;
        LogManager.getLogger(GenericDAOJPA.class).debug(">>>Dispatcher ACTION >>> "+view);
        switch (action) {
        case "addTema":
            tema = new Tema(request.getParameter("nombre"), request.getParameter("pregunta"));
            AddTemaBean addTemaBean = new AddTemaBean(tema);      
            addTemaBean.setControllerFactory(controllerFactory);
            addTemaBean.process();
            request.setAttribute(action, addTemaBean);
            break;
        case "votar":
        	LogManager.getLogger(GenericDAOJPA.class).debug(">>>Dispatcher action votar ");
        	VotarBean votarBean = new VotarBean();
        	votarBean.update(request.getRemoteAddr());
        	id = request.getParameter("idTema");
        	idTema = Integer.valueOf(id);	      	
        	votarBean.setIdTema(idTema);       	
        	votarBean.setEstudio(request.getParameter("estudio"));
        	String puntaje = request.getParameter("puntaje");
        	votarBean.setPuntaje(Integer.valueOf(puntaje));
        	votarBean.process();
        	break;
        case "eliminarTema":
        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
        	String idTemaEliminar = request.getParameter("idTema");
        	eliminarTemaBean.setIdTema(Integer.valueOf(idTemaEliminar));
        	eliminarTemaBean.process();
        	break;
        
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }



}