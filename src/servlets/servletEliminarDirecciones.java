package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataDireccion;
import entidades.Direccion;
import entidades.Localidad;

/**
 * Servlet implementation class servletEliminarDirecciones
 */
@WebServlet("/servletEliminarDirecciones")
public class servletEliminarDirecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarDirecciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Direccion d = new Direccion();
		DataDireccion dDir = new DataDireccion();
		d.setIdDireccion(Integer.parseInt(request.getParameter("IdDirIn")));

		
		dDir.drop(d);
		
		
		LinkedList<Direccion> direcciones = dDir.getAll();
		request.setAttribute("listaDirecciones", direcciones);
		request.getRequestDispatcher("WEB-INF/muestreoDirecciones.jsp").forward(request, response);
	}

}
