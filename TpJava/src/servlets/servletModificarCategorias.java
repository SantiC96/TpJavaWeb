package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataCategoriaTrabajos;
import entidades.CategoriaTrabajo;

/**
 * Servlet implementation class servletModificarCategorias
 */
@WebServlet("/servletModificarCategorias")
public class servletModificarCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarCategorias() {
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
		
		CategoriaTrabajo ct = new CategoriaTrabajo();
		DataCategoriaTrabajos dct = new DataCategoriaTrabajos();

		ct.setIdCategoria(Integer.parseInt(request.getParameter("IdCatIn")));
		ct.setDescripcion(request.getParameter("descIn"));
		
		dct.update(ct.getIdCategoria(), ct);
		request.setAttribute("IdCatIn", ct);
		
		LinkedList<CategoriaTrabajo> cat = dct.getAll();
		request.setAttribute("listaCategoriaTrabajos", cat);
		request.getRequestDispatcher("WEB-INF/muestreoCategorias.jsp").forward(request, response);
	}
}