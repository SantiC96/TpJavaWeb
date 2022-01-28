package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataCotizacion;
import entidades.Cotizacion;

/**
 * Servlet implementation class servletAgregarCotizacion
 */
@WebServlet("/servletAgregarCotizacion")
public class servletAgregarCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarCotizacion() {
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
		
		Cotizacion c = new Cotizacion();
		DataCotizacion dc = new DataCotizacion();
		
		c.setIdCotizacion(Integer.parseInt(request.getParameter("idCotIn")));
		c.setPrecioHora(Double.parseDouble(request.getParameter("precioHoraIn")));
		c.setPrecioFinal(Double.parseDouble(request.getParameter("precioFinalIn")));
		c.setFechaCotizacion(request.getParameter("fechaCotIn"));
		c.setDescripcion(request.getParameter("descIn"));
		c.setMaterialesRequeridos(request.getParameter("materialesReqIn"));
		
		dc.add(c);
		LinkedList<Cotizacion> cots = dc.getAll();
		request.setAttribute("listaCotizaciones", cots);
		request.getRequestDispatcher("WEB-INF/muestreoCotizaciones.jsp").forward(request, response);
	}

}
