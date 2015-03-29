package views.beans;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import java.io.IOException;

import controllers.ControllerFactory;
import controllers.ejb.ControllerFactoryEJB;
import persistence.models.entities.Tema;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private ControllerFactory controllerFactory;

    private static String PATH_ROOT_VIEW = "/views/jsp/";

    public void init( ServletConfig conf ) throws ServletException {
		controllerFactory = new ControllerFactoryEJB();
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);
        LogManager.getLogger().debug("action::"+action);
        String view;
        request.setCharacterEncoding("UTF-8");
        switch (action) {
        case "addTema":
        	AddTemaBean addTemaBean = new AddTemaBean();
        	addTemaBean.setTema(new Tema());
        	addTemaBean.setControllerFactory(this.controllerFactory);
            request.setAttribute("addTemaBean", addTemaBean);
            view = "addTema";
            break;
        default:
            view = "home";
        }
        
        LogManager.getLogger().debug("view::"+view);
        //this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        this.getServletContext().getRequestDispatcher("/views/jsp/home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getPathInfo().substring(1);
        Tema tema;
        String view="home";
        switch (action) {
        case "addTema":
            tema = new Tema(request.getParameter("nombre"), request.getParameter("pregunta"));
            tema.setId(Integer.parseInt(request.getParameter("id")));
            AddTemaBean addTemaBean = new AddTemaBean(tema);      
            addTemaBean.setControllerFactory(controllerFactory);
            addTemaBean.process();
            request.setAttribute("addTemaBean", addTemaBean);
            view = action;
            break;
        
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }



}