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
import conexionSQL.*;
import entidades.*;


/**
 * Servlet implementation class servletAgregarPersonas
 */
@WebServlet("/servletAgregarPersonas")
public class servletAgregarPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarPersonas() {
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
		DataRol dr = new DataRol();
		Rol r = new Rol();
		Direccion dir = new Direccion();
		String menuPersona=new String();
		DataTrabajo dt=new DataTrabajo();
		
		String dni = request.getParameter("dniIn");
		String nombre = request.getParameter("nomIn");
		String apellido = request.getParameter("apeIn");
		String telefono = request.getParameter("telIn");
		String rol = request.getParameter("IdRolIn");
		String valuacionPromedio = request.getParameter("valIn");
		
		if (dni == null || dni.trim().isEmpty()
		        || nombre == null || nombre.trim().isEmpty()
		        || apellido == null || apellido.trim().isEmpty()
		        || telefono == null || telefono.trim().isEmpty()
		        || rol == null || rol.trim().isEmpty()
		        || valuacionPromedio == null || valuacionPromedio.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorAgregarPersona.jsp").forward(request, response);
		    return;
		}
		
		try {
			per.setDni(Integer.parseInt(request.getParameter("dniIn")));
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/errorAgregarPersona.jsp").forward(request, response);
			return;
		}
		
		try {
			per.setValuacionPromedio(Double.parseDouble(request.getParameter("valIn")));
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/errorAgregarPersona.jsp").forward(request, response);
			return;
		}
		
		menuPersona=request.getParameter("menuIn");
		
		
		per.setDni(Integer.parseInt(request.getParameter("dniIn")));
		per.setNombre(request.getParameter("nomIn"));
		per.setApellido(request.getParameter("apeIn"));
		per.setTelefono(request.getParameter("telIn"));
		per.setContrasenia(request.getParameter("contraIn"));
		
		try {
			r.setIdRol(Integer.parseInt(request.getParameter("IdRolIn")));
		} catch (Exception e) {
			r.setIdRol(2);
		}
		per.setRol(dr.getById(r));
		

		
		try {
			per.setValuacionPromedio(Double.parseDouble(request.getParameter("valIn")));
		} catch (Exception e) {
			per.setValuacionPromedio(0.0);
		}
		
		dp.add(per);
		if("persona".equals(menuPersona)) {
			LinkedList<Trabajo> trab = dt.getAllActivos();
			request.setAttribute("listaTrabajos", trab);
			request.setAttribute("persona", per);
			request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);		
			}
		else {	
		
			LinkedList<Persona> pers = dp.getAll();
			request.setAttribute("listaPersonas", pers);
			request.getRequestDispatcher("WEB-INF/muestreoPersonas.jsp").forward(request, response);
		}
	}
}