package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataCategoriaTrabajos;
import conexionSQL.DataPersona;
import entidades.CategoriaTrabajo;
import entidades.Persona;

/**
 * Servlet implementation class servletModificarPersonas
 */
@WebServlet("/servletModificarPersonas")
public class servletModificarPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarPersonas() {
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
		
		Persona per = new Persona();
		DataPersona dp = new DataPersona();
		CategoriaTrabajo ct = new CategoriaTrabajo();
		DataCategoriaTrabajos dct = new DataCategoriaTrabajos();

		per.setDni(Integer.parseInt(request.getParameter("dni")));
		per.setNombre(request.getParameter("nombre"));
		per.setApellido(request.getParameter("apellido"));
		per.setTelefono(request.getParameter("telefono"));
		ct.setIdCategoria(Integer.parseInt(request.getParameter("idCategoriaTrabajo")));
		per.setCategoriasTrabajo(dct.getById(ct));
		per.setAreaTrabajo(request.getParameter("area"));
		per.setValuacionPromedio(Double.parseDouble(request.getParameter("valuacion")));
		
		dp.update(per.getDni(), per);
		request.setAttribute("dni", per);
		
		LinkedList<Persona> pers = dp.getAll();
		request.setAttribute("listaPersonas", pers);
		request.getRequestDispatcher("WEB-INF/muestreoPersonas.jsp").forward(request, response);
	}

}
