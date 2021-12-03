package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataPersona;
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
		
		per.setDni(Integer.parseInt(request.getParameter("dniIn")));
		per.setNombre(request.getParameter("nomIn"));
		per.setApellido(request.getParameter("apeIn"));
		per.setTelefono(request.getParameter("telIn"));
		per.setOficio(request.getParameter("ofiIn"));
		per.setAreaTrabajo(request.getParameter("areaIn"));
		per.setValuacionPromedio(Double.parseDouble(request.getParameter("valIn")));
		per.setDni(Integer.parseInt(request.getParameter("dniIn")));
		
		dp.update(per.getDni(), per);
		request.setAttribute("persona", per);
		request.getRequestDispatcher("WEB-INF/modificarPersonas.jsp").forward(request, response);
	}

}
