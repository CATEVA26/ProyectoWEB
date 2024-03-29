package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos Iñiguez
 */
@WebServlet("/ConfiguracionController")
public class ConfiguracionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request,response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request,response);
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ruta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "ver";

		switch (ruta) {
		case "configuracion": {
			request.getRequestDispatcher("/jsp/configuracion.jsp").forward(request,response);
			break;
		}

		}
	}

	

	

}