package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataTrabajo;
import entidades.Trabajo;

/**
 * Servlet implementation class servletTrabajosByID
 */
@WebServlet("/servletTrabajosByID")
public class servletTrabajosByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletTrabajosByID() {
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
		
		Trabajo trab = new Trabajo();
		DataTrabajo dt = new DataTrabajo();
		
		trab.setIdTrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
		trab = dt.getById(trab);
		
		if (trab!=null) {
			request.setAttribute("trabajo", trab);
			request.getRequestDispatcher("WEB-INF/muestreoTrabajosByID.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaTrabajosByID.jsp").forward(request, response);
		}
	}

}