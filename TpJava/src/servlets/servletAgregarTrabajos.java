package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataTrabajo;
import entidades.Trabajo;

/**
 * Servlet implementation class servletAgregarTrabajos
 */
@WebServlet("/servletAgregarTrabajos")
public class servletAgregarTrabajos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarTrabajos() {
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
		Trabajo tra = new Trabajo();
		DataTrabajo dt = new DataTrabajo();
		
		tra.setIdtrabajo(Integer.parseInt(request.getParameter("idTrabIn")));
		tra.setEstado(request.getParameter("estadoIn"));
		tra.setDniTrabajador(Integer.parseInt(request.getParameter("dniTrabIn")));
		tra.setDniCliente(Integer.parseInt(request.getParameter("dniCliIn")));
		tra.setUbicacionAprox(request.getParameter("ubiAproxIn"));
		tra.setFechaEstimadaIni(request.getParameter("fechaEstIniIn"));
		tra.setFechaEstimadaFin(request.getParameter("fechaEstFinIn"));
		tra.setFechaIni(request.getParameter("fechaIniIn"));
		tra.setFechaFin(request.getParameter("fechaFinIn"));
		tra.setValuacionTrabajo(Double.parseDouble(request.getParameter("valIn")));
		tra.setObservaciones(request.getParameter("obsIn"));
		tra.setIdCotizacion(Integer.parseInt(request.getParameter("idCotIn")));
		tra.setIdLocalidad(Integer.parseInt(request.getParameter("idLocIn")));
		
		dt.add(tra);
		LinkedList<Trabajo> trab = dt.getAll();
		request.setAttribute("listaTrabajos", trab);
		request.getRequestDispatcher("WEB-INF/muestreoTrabajos.jsp").forward(request, response);
	}

}
