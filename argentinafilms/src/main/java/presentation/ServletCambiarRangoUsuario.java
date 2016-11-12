package presentation;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuarios;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.ServiceUsuario;

@SuppressWarnings("serial")
@WebServlet("/CambiarRangoUsuario")
public class ServletCambiarRangoUsuario extends HttpServlet{

	public ServiceUsuario serviceUsuario = null;
	
	@Override
	public void init(ServletConfig config) {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		this.serviceUsuario = (ServiceUsuario) context.getBean(ServiceUsuario.class);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String usuarioIngresado = request.getParameter("userSeleccionado");
		String nuevoRango = request.getParameter("rangoSeleccionado");
		
		Usuarios usuario = this.serviceUsuario.getByUserName(usuarioIngresado);
		
		try{
			usuario.setRango(nuevoRango);

			this.serviceUsuario.update(usuario);;
		}
		catch(NullPointerException e){
			request.setAttribute("tipoMensaje", "alert alert-dismissable alert-danger");
	        request.setAttribute("mensajeResultado", "El nombre de usuario ingresado no existe. Reintente por favor.");
			request.getRequestDispatcher("/CambiarRangoUsuario.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("tipoMensaje", "alert alert-dismissable alert-success");
        request.setAttribute("mensajeResultado", "El usuario " + usuario.getUsuario() + "fue cambiadado a rango " + nuevoRango + ".");
		response.sendRedirect("CambiarRangoUsuario.jsp");
	}
	
	
}
