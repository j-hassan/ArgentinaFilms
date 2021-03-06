package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.*;
import model.*;

@SuppressWarnings("serial")
@WebServlet("/BuscarPeliculas")
public class ServletBuscarPeliculas extends HttpServlet {

	public ServicePelicula peliculaService = null;

	@Override
	public void init(ServletConfig config) {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		this.peliculaService = (ServicePelicula) context.getBean(ServicePelicula.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texto = request.getParameter("buscar");
		if (!texto.equals(null)){
			if (texto.length()>2){
				List<Peliculas> peliculas = this.peliculaService.getByTextoEnNombre(texto);
				request.getSession().setAttribute("PeliculasEncontradas", peliculas);
			}
		}
		System.out.println(request.getParameter("buscar"));
		
		response.sendRedirect("Resultados.jsp");

	}



}
