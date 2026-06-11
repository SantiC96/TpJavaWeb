package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataPersona;
import conexionSQL.DataTrabajo;
import entidades.Persona;
import entidades.Trabajo;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLogin() {
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
		
		String dniLogin = request.getParameter("DNIlogin");
		String contrasenia = request.getParameter("ContraseniaLogin");
		
		if (dniLogin == null || dniLogin.trim().isEmpty()
		        || contrasenia == null || contrasenia.trim().isEmpty()) {
		    request.getRequestDispatcher("WEB-INF/errorLogin.jsp").forward(request, response);
		    return;
		}
		
		try {
			per.setDni(Integer.parseInt(dniLogin));
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/errorLogin.jsp").forward(request, response);
			return;
		}
		per.setContrasenia(contrasenia);
		per = dp.getByUsuario(per);
		
		
		if (per!=null) {
			DataTrabajo dt= new DataTrabajo();
			LinkedList<Trabajo> trabs= dt.getAllActivos();
			
			request.setAttribute("listaTrabajos", trabs);
			request.setAttribute("persona", per);
			if (per.getRol().getDescripcion().equals("usuario")) {
				request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);
			}
			if (per.getRol().getDescripcion().equals("admin")) {
				request.getRequestDispatcher("WEB-INF/menuAdmin.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorLogin.jsp").forward(request, response);
		}
	}
}


