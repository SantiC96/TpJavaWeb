package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import conexionSQL.DataLocalidad;
import conexionSQL.DataProvincia;
import entidades.Localidad;
import entidades.Provincia;

/**
 * Servlet implementation class servletDireccionesByID
 */
@WebServlet("/servletLocalidadesByDescripcion")
public class servletLocalidadesByDescripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLocalidadesByDescripcion() {
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
		Localidad l = new Localidad();
		DataLocalidad dLoc = new DataLocalidad();
		Provincia prov = new Provincia();
		DataProvincia dProv = new DataProvincia();
		
		String descLoc = request.getParameter("DescripcionIn");

		if (descLoc == null || descLoc.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorBusquedaLocalidadesByDescripcion.jsp").forward(request, response);
		    return;
		}
		
		l.setDescripcion(request.getParameter("DescripcionIn"));
		l=dLoc.getLocByDesc(l);
		if (l!=null) {
			request.setAttribute("localidad", l);
			request.getRequestDispatcher("WEB-INF/muestreoLocalidadesByDescripcion.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaLocalidadesByDescripcion.jsp").forward(request, response);
		}
		
	}

}
