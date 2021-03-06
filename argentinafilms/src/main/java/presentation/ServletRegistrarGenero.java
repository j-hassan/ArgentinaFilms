package presentation;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.*;
import model.*;


/**
 * Servlet implementation class ServletRegistrarGeneros
 */
@WebServlet("/ServletRegistrarGeneros")
public class ServletRegistrarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DAOGeneros generosService = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarGenero() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		//TODO: Validar datos como la gente

		try{
			String genero_string = request.getParameter("genero");
			Generos genero = new Generos(genero_string);
			this.generosService.save(genero);
			
			System.out.println("Datos guardados");
		}		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public void init(ServletConfig config) {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		this.generosService = (DAOGeneros) context.getBean(DAOGeneros.class);
	
	}
}
