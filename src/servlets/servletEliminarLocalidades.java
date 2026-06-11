package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import entidades.Localidad;
import entidades.Provincia;

/**
 * Servlet implementation class servletEliminarLocalidades
 */
@WebServlet("/servletEliminarLocalidades")
public class servletEliminarLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarLocalidades() {
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
		
		Localidad l = new Localidad();
		DataLocalidad dLoc = new DataLocalidad();
		
		l.setIdLocalidad(Integer.parseInt(request.getParameter("IdLocIn")));

		
		dLoc.drop(l);
		
		
		LinkedList<Localidad> localidades = dLoc.getAll();
		request.setAttribute("listaLocalidades", localidades);
		request.getRequestDispatcher("WEB-INF/muestreoLocalidades.jsp").forward(request, response);
	}

}

