package presentation;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Peliculas;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.ServicePelicula;

import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet("/RechazarPeticionPelicula")
public class ServletRechazarPeticionPelicula extends HttpServlet{


	public ServicePelicula servicePelicula = null;
	
	@Override
	public void init(ServletConfig config) {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		this.servicePelicula = (ServicePelicula) context.getBean(ServicePelicula.class);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String json = new Gson().toJson("");
		Integer id = Integer.parseInt(request.getParameter("idSeleccionado"));

		Peliculas pelicula = new Peliculas();
		pelicula.setId_pelicula(id);
		
		servicePelicula.delete(pelicula);

		json = new Gson().toJson("ok");
		response.setContentType("application/json"); 
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(json);

		
	}
	
	
}
