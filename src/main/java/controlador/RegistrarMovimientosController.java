package controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Cuenta;
import entities.Movimiento;
import entities.TipoMovimiento;

/**
 * @author Grupo 7
 */
@WebServlet("/RegistrarMovimientosController")
public class RegistrarMovimientosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request,response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "ver"; //dashboardController tiene la ruta de ver

		switch (ruta) {
		case "nuevoingreso":
			nuevoIngreso(request, response);
			break;
		case "guardarIngreso":
			guardarIngreso(request,response);
			break;
		case "ver":
			response.sendRedirect(ruta);
		}
		
	}

	private void nuevoIngreso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.- Obtengo datos
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		//2.- LLamo al Modelo
		List<Categoria> categoria = Categoria.getAllOfIngresoType();
		Cuenta cuenta = Cuenta.getById(idCuenta);
		//3.- LLamo a la vista
		request.setAttribute("categorias", categoria); 
		request.setAttribute("cuenta", cuenta);
		request.getRequestDispatcher("/jsp/ingreso.jsp").forward(request,response);
	}
	
	private void guardarIngreso(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// 1.- Obtengo los datos
		String concepto = request.getParameter("concepto");
		Date fecha = Date.valueOf(request.getParameter("fecha"));
		double valor = Double.parseDouble(request.getParameter("valor")); 
		Cuenta cuenta = Cuenta.getById(Integer.parseInt(request.getParameter("idCuenta")));
		Categoria categoria = Categoria.getById(Integer.parseInt(request.getParameter("idCategoria")));
		// 2.- Llamo al Modelo
		Movimiento movimiento = new Movimiento(concepto, fecha, valor, cuenta, categoria, TipoMovimiento.INGRESO);
		// 3.- LLamo a la vista
		boolean creacionExitosa = Movimiento.createIngreso(movimiento);
		
		if (creacionExitosa) {
			request.setAttribute("notificacion", "Insercion exitoso");
		} else {
			request.setAttribute("notificacion", "Error al ingresar");
		}
		ruteador(request, response);

	}
	
	private void nuevaTransferencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void nuevoGasto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void eliminarGasto(HttpServletRequest request, HttpServletResponse response) {

	}

	private void eliminarIngreso(HttpServletRequest request, HttpServletResponse response) {

	}

	private void guardarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void guardarEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}



	

	/**
	 * Default constructor
	 */
	public RegistrarMovimientosController() {
	}

}