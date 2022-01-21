package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataTrabajo;
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
		doGet(request, response);
		
		Trabajo tra = new Trabajo();
		DataTrabajo dt = new DataTrabajo();
		tra.setIdtrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
		dt.drop(tra);
		LinkedList<Trabajo> trab = dt.getAll();
		request.setAttribute("listaTrabajos", trab);
		request.getRequestDispatcher("WEB-INF/muestreoTrabajos.jsp").forward(request, response);
	}

}
