package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataPersona;
import conexionSQL.DataTrabajo;
import entidades.Persona;
import entidades.Trabajo;

/**
 * Servlet implementation class servletEliminarTrabajos
 */
@WebServlet("/servletEliminarTrabajos")
public class servletEliminarTrabajos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarTrabajos() {
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
		
		Trabajo tra = new Trabajo();
		DataTrabajo dt = new DataTrabajo();
		tra.setIdTrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
		dt.drop(tra);
		
		if("usuario".equals(request.getParameter("userRol"))){
			DataPersona dp=new DataPersona();
			Persona per=new Persona();
			per.setDni(Integer.parseInt(request.getParameter("userDni")));
			per=dp.getByDocumento(per);
			LinkedList<Trabajo> trab = dt.getAllActivos();
			request.setAttribute("listaTrabajos", trab);
			request.setAttribute("persona", per);
			request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);
		}else {		
			LinkedList<Trabajo> trab = dt.getAll();
			request.setAttribute("listaTrabajos", trab);
			request.getRequestDispatcher("WEB-INF/muestreoTrabajoV2jsp.jsp").forward(request, response);
		}
	}

}

