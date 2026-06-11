package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import conexionSQL.DataProvincia;
import entidades.Localidad;
import entidades.Provincia;

/**
 * Servlet implementation class servletAgregarProvincias
 */
@WebServlet("/servletAgregarProvincias")
public class servletAgregarProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarProvincias() {
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
		
		Provincia prov = new Provincia();
		DataProvincia dProv = new DataProvincia();
		
		String descripcion = request.getParameter("descIn");
		
		if (descripcion == null || descripcion.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorAgregarProvincia.jsp").forward(request, response);
		    return;
		}
		
		prov.setDescripcion(request.getParameter("descIn"));
		
		dProv.add(prov);
		
		
		LinkedList<Provincia> provincias = dProv.getAll();
		request.setAttribute("listaProvincias", provincias);
		request.getRequestDispatcher("WEB-INF/muestreoProvincias.jsp").forward(request, response);
		
	}

}
