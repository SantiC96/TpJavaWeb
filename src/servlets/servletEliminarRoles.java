package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataRol;
import entidades.Rol;

/**
 * Servlet implementation class servletEliminarRoles
 */
@WebServlet("/servletEliminarRoles")
public class servletEliminarRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarRoles() {
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
		
		Rol r = new Rol();
		DataRol dr = new DataRol();
		r.setIdRol(Integer.parseInt(request.getParameter("IdRolIn")));
		dr.drop(r);
		LinkedList<Rol> cat = dr.getAll();
		request.setAttribute("listaRoles", cat);
		request.getRequestDispatcher("WEB-INF/muestreoRoles.jsp").forward(request, response);
	}
}