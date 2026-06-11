package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Rol;
import conexionSQL.DataRol;

/**
 * Servlet implementation class servletAgregarRoles
 */
@WebServlet("/servletAgregarRoles")
public class servletAgregarRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarRoles() {
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
		
		String descripcion = request.getParameter("descIn");
		
		if (descripcion == null || descripcion.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorAgregarRol.jsp").forward(request, response);
		    return;
		}
		
		r.setDescripcion(request.getParameter("descIn"));
		
		dr.add(r);
		LinkedList<Rol> roles = dr.getAll();
		request.setAttribute("listaRoles", roles);
		request.getRequestDispatcher("WEB-INF/muestreoRoles.jsp").forward(request, response);
	}

}
