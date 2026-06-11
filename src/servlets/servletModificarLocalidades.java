package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import conexionSQL.DataProvincia;
import entidades.Localidad;
import entidades.Provincia;

/**
 * Servlet implementation class servletModificarLocalidades
 */
@WebServlet("/servletModificarLocalidades")
public class servletModificarLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarLocalidades() {
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
		l.setCodPostal(request.getParameter("CodPostal"));
		l.setDescripcion(request.getParameter("Descripcion"));
		
		Provincia prov = new Provincia();
		DataProvincia dProv= new DataProvincia();
		prov.setDescripcion(request.getParameter("DescProv"));
		prov=dProv.getProvByDesc(prov);
		l.setProvincia(prov);
		
		System.out.println(l);
		
		dLoc.update(l.getIdLocalidad(),l);
		
		
		LinkedList<Localidad> localidades = dLoc.getAll();
		request.setAttribute("listaLocalidades", localidades);
		request.getRequestDispatcher("WEB-INF/muestreoLocalidades.jsp").forward(request, response);
	}

}
