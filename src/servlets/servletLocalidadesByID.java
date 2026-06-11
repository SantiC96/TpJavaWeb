package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import entidades.Localidad;

/**
 * Servlet implementation class servletLocalidadesByID
 */
@WebServlet("/servletLocalidadesByID")
public class servletLocalidadesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLocalidadesByID() {
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
		
		Localidad l = new Localidad();
		DataLocalidad dLoc = new DataLocalidad();
		
		l.setIdLocalidad(Integer.parseInt(request.getParameter("IdLocIn")));
		l=dLoc.getById(l);
		
		if (l!=null) {
			request.setAttribute("localidad", l);
			request.getRequestDispatcher("WEB-INF/muestreoLocalidadesByID.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaLocalidadesByID.jsp").forward(request, response);
		}
	}

}
