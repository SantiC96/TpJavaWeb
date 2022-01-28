package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataCotizacion;
import entidades.Cotizacion;

/**
 * Servlet implementation class servletCotizacionesByID
 */
@WebServlet("/servletCotizacionesByID")
public class servletCotizacionesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCotizacionesByID() {
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
		
		Cotizacion cot = new Cotizacion();
		DataCotizacion dc = new DataCotizacion();
		
		cot.setIdCotizacion(Integer.parseInt(request.getParameter("IdCot")));
		cot = dc.getById(cot);
		
		if (cot!=null) {
			request.setAttribute("cotizacion", cot);
			request.getRequestDispatcher("WEB-INF/muestreoCotizacionesByID.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaCotizacionesByID.jsp").forward(request, response);
	}
	}
}

