package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataRol;
import conexionSQL.DataPersona;
import entidades.Rol;
import entidades.Direccion;
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
		
		Persona per = new Persona();
		DataPersona dp = new DataPersona();
		Rol r = new Rol();
		DataRol dr = new DataRol();
		Direccion dir = new Direccion();
		

		per.setDni(Integer.parseInt(request.getParameter("DNIin")));
		per.setNombre(request.getParameter("nomIn"));
		per.setApellido(request.getParameter("apeIn"));
		per.setTelefono(request.getParameter("telIn"));
		per.setContrasenia(request.getParameter("passIn"));
		per.setValuacionPromedio(Double.parseDouble(request.getParameter("valIn")));
		r.setIdRol(Integer.parseInt(request.getParameter("IdRolIn")));
		per.setRol(dr.getById(r));
		
		
		dp.update(per.getDni(), per);
		request.setAttribute("DNIin", per);
		
		LinkedList<Persona> pers = dp.getAll();
		request.setAttribute("listaPersonas", pers);
		request.getRequestDispatcher("WEB-INF/muestreoPersonas.jsp").forward(request, response);
	}

}