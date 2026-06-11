package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataDireccion;
import conexionSQL.DataLocalidad;
import conexionSQL.DataProvincia;
import entidades.Direccion;
import entidades.Localidad;
import entidades.Provincia;

/**
 * Servlet implementation class ServletAgregarLocalidades
 */
@WebServlet("/ServletAgregarLocalidades")
public class ServletAgregarLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarLocalidades() {
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
		Provincia prov = new Provincia();
		DataProvincia dProv= new DataProvincia();
		
		String codPostal = request.getParameter("CodPostalIn");
		String descripcion = request.getParameter("DescripcionIn");
		String provincia = request.getParameter("ProvinciaIn");
		
		if (codPostal == null || codPostal.trim().isEmpty()
		        || descripcion == null || descripcion.trim().isEmpty()
		        || provincia == null || provincia.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorAgregarLocalidad.jsp").forward(request, response);
		    return;
		}
		
		l.setCodPostal(request.getParameter("CodPostalIn"));
		l.setDescripcion(request.getParameter("DescripcionIn"));
		
		prov.setDescripcion(request.getParameter("ProvinciaIn"));
		prov=dProv.getProvByDesc(prov);
		l.setProvincia(prov);
		
		dLoc.add(l);
		
		
		LinkedList<Localidad> localidades = dLoc.getAll();
		request.setAttribute("listaLocalidades", localidades);
		request.getRequestDispatcher("WEB-INF/muestreoLocalidades.jsp").forward(request, response);
	}

}
