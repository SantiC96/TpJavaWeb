package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataProvincia;
import entidades.Provincia;

/**
 * Servlet implementation class servletModificarProvincias
 */
@WebServlet("/servletModificarProvincias")
public class servletModificarProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarProvincias() {
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
		
		Provincia prov = new Provincia();
		DataProvincia dProv = new DataProvincia();
		prov.setIdProvincia(Integer.parseInt(request.getParameter("IdProvIn")));
		prov.setDescripcion(request.getParameter("descIn"));

		
		dProv.update(prov.getIdProvincia(),prov);
		
		
		LinkedList<Provincia> provincias = dProv.getAll();
		request.setAttribute("listaProvincias", provincias);
		request.getRequestDispatcher("WEB-INF/muestreoProvincias.jsp").forward(request, response);
		
	}

}
