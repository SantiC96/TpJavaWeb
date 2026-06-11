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
 * Servlet implementation class servletModificarDirecciones
 */
@WebServlet("/servletModificarDirecciones")
public class servletModificarDirecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarDirecciones() {
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
		d.setCalle(request.getParameter("Calle"));
		d.setAltura(request.getParameter("Altura"));

		Localidad loc = new Localidad();
		DataLocalidad dLoc= new DataLocalidad();
		loc.setDescripcion(request.getParameter("DescLoc"));
		loc=dLoc.getLocByDesc(loc);
		d.setLocalidad(loc);
		
		dDir.update(d.getIdDireccion(),d);
		
		
		LinkedList<Direccion> direcciones = dDir.getAll();
		request.setAttribute("listaDirecciones", direcciones);
		request.getRequestDispatcher("WEB-INF/muestreoDirecciones.jsp").forward(request, response);
	}

}
