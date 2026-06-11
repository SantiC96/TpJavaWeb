package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataRol;
import entidades.Rol;

/**
 * Servlet implementation class servletRolesByID
 */
@WebServlet("/servletRolesByID")
public class servletRolesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRolesByID() {
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
		
		try {
			r.setIdRol(Integer.parseInt(request.getParameter("idRol")));
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/errorBusquedaRolesByID.jsp").forward(request, response);
			return;
		}
		
		r.setIdRol(Integer.parseInt(request.getParameter("idRol")));
		r = dr.getById(r);
		
		if (r!=null) {
			request.setAttribute("rol", r);
			request.getRequestDispatcher("WEB-INF/muestreoRolesByID.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaRolesByID.jsp").forward(request, response);
		}
	}
}