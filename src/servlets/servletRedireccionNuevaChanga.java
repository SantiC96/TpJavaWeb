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
 * Servlet implementation class servletReedireccionNuevaChanga
 */
@WebServlet("/servletRedireccionNuevaChanga")
public class servletRedireccionNuevaChanga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRedireccionNuevaChanga() {
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
		DataPersona dp= new DataPersona();
		Persona per=new Persona();
		per.setDni(Integer.parseInt(request.getParameter("userIn")));
		per=dp.getByDocumento(per);
		request.setAttribute("persona", per);
		
		request.getRequestDispatcher("/ABMCTrabajos/Agregar/agregarNuevaChanga.jsp").forward(request, response);
	}

}
