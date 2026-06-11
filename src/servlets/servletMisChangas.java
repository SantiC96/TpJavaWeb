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
 * Servlet implementation class servletMisChangas
 */
@WebServlet("/servletMisChangas")
public class servletMisChangas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMisChangas() {
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
		
		DataTrabajo dt = new DataTrabajo();
		Persona per = new Persona();
		DataPersona dP=new DataPersona();
		per.setDni(Integer.parseInt(request.getParameter("userIn")));
		per=dP.getByDocumento(per);
		LinkedList<Trabajo> trab = dt.getAllPorPersona(per);
		request.setAttribute("listaTrabajos", trab);
		request.setAttribute("persona", per);
		request.getRequestDispatcher("WEB-INF/misChangas.jsp").forward(request, response);
	}

}
