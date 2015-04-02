package views.beans;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                
        switch (action) {
        case "addTema":
            tema = new Tema(request.getParameter("nombre"), request.getParameter("pregunta"));
            AddTemaBean addTemaBean = new AddTemaBean(tema);      
            addTemaBean.setControllerFactory(controllerFactory);
            addTemaBean.process();
            request.setAttribute(action, addTemaBean);
            view = action;
            break;
        case "votar":
        	VotarBean votarBean = new VotarBean();
			votarBean.update(request.getRemoteAddr());
			request.setAttribute(action, votarBean);
			view = action;
        	break;
        
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }



}