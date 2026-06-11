package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataDireccion;
import conexionSQL.DataLocalidad;
import entidades.Direccion;
import entidades.Localidad;


/**
 * Servlet implementation class servletAgregarDirecciones
 */
@WebServlet("/servletAgregarDirecciones")
public class servletAgregarDirecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarDirecciones() {
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
		Localidad loc = new Localidad();
		DataLocalidad dLoc= new DataLocalidad();
		
		String calle = request.getParameter("CalleIn");
		String altura = request.getParameter("AlturaIn");
		String localidad = request.getParameter("DescLocIn");
		
		if (calle == null || calle.trim().isEmpty()
		        || altura == null || altura.trim().isEmpty()
		        || localidad == null || localidad.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorAgregarDireccion.jsp").forward(request, response);
		    return;
		}
		
		d.setCalle(request.getParameter("CalleIn"));
		d.setAltura(request.getParameter("AlturaIn"));

		loc.setDescripcion(request.getParameter("DescLocIn"));
		loc=dLoc.getLocByDesc(loc);
		d.setLocalidad(loc);
		
		dDir.add(d);
		
		
		LinkedList<Direccion> direcciones = dDir.getAll();
		request.setAttribute("listaDirecciones", direcciones);
		request.getRequestDispatcher("WEB-INF/muestreoDirecciones.jsp").forward(request, response);
	}

}
