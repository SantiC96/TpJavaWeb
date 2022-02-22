package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataCategoriaTrabajos;
import entidades.CategoriaTrabajo;

/**
 * Servlet implementation class servletCategoriasByID
 */
@WebServlet("/servletCategoriasByID")
public class servletCategoriasByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCategoriasByID() {
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
		
		CategoriaTrabajo cat = new CategoriaTrabajo();
		DataCategoriaTrabajos dct = new DataCategoriaTrabajos();
		
		cat.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		cat = dct.getById(cat);
		
		if (cat!=null) {
			request.setAttribute("categoria", cat);
			request.getRequestDispatcher("WEB-INF/muestreoCategoriasByID.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/errorBusquedaCategoriasByID.jsp").forward(request, response);
		}
	}
}