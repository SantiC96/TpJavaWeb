package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataProvincia;
import entidades.Provincia;

/**
 * Servlet implementation class servletProvinciasByNombre
 */
@WebServlet("/servletProvinciasByNombre")
public class servletProvinciasByNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProvinciasByNombre() {
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
		
		String nombre = request.getParameter("nomIn");

		if (nombre == null || nombre.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorBusquedaProvinciasByNombre.jsp").forward(request, response);
		    return;
		}
		
		prov.setDescripcion(request.getParameter("nomIn"));
		prov=dProv.getProvByDesc(prov);
		if (prov!=null) {
			request.setAttribute("provincia", prov);
			request.getRequestDispatcher("WEB-INF/muestreoProvinciasByNombre.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaProvinciasByNombre.jsp").forward(request, response);
		}
	}

}
