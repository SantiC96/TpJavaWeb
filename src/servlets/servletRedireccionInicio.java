package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import conexionSQL.DataPersona;
import conexionSQL.DataTrabajo;
import entidades.Localidad;
import entidades.Persona;
import entidades.Trabajo;

/**
 * Servlet implementation class servletRedireccionInicio
 */
@WebServlet("/servletRedireccionInicio")
public class servletRedireccionInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRedireccionInicio() {
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

		Persona per = new Persona();
		Localidad l = new Localidad();
		DataTrabajo dt = new DataTrabajo();
		DataPersona dp = new DataPersona();
		
		per.setDni(Integer.parseInt(request.getParameter("userIn")));
		per=dp.getByDocumento(per);
		LinkedList<Trabajo> trab = dt.getAllActivos();
		request.setAttribute("listaTrabajos", trab);
		request.setAttribute("persona", per);
		
		
		request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);
	}

}
