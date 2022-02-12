package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.DataLocalidad;
import conexionSQL.DataPersona;
import conexionSQL.DataTrabajo;
import entidades.Localidad;
import entidades.Persona;
import entidades.Trabajo;

/**
 * Servlet implementation class servletModificarPersonas
 */
@WebServlet("/servletModificarTrabajos")
public class servletModificarTrabajos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarTrabajos() {
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
		Persona trabajador = new Persona();
		Persona cli = new Persona();
		Localidad l = new Localidad();
		DataLocalidad dl = new DataLocalidad();
		DataTrabajo dt = new DataTrabajo();
		DataPersona dp = new DataPersona();

		tra.setIdTrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
		trabajador.setDni(Integer.parseInt(request.getParameter("dniTrabIn")));
		tra.setTrabajador(dp.getByDocumento(trabajador));
		cli.setDni(Integer.parseInt(request.getParameter("dniCliIn")));
		tra.setCliente(dp.getByDocumento(cli));
		tra.setEstado(request.getParameter("estadoIn"));
		tra.setFechaIni(request.getParameter("fechaIniIn"));
		tra.setFechaFin(request.getParameter("fechaFinIn"));
		tra.setUbicacionAprox(request.getParameter("ubiAproxIn"));
		tra.setFechaEstimadaIni(request.getParameter("fechaEstIniIn"));
		tra.setFechaEstimadaFin(request.getParameter("fechaEstFinIn"));
		tra.setValuacionTrabajo(Double.parseDouble(request.getParameter("valIn")));
		tra.setPrecioFinal(Double.parseDouble(request.getParameter("precioFin")));
		tra.setObservaciones(request.getParameter("obsIn"));
		l.setIdLocalidad(Integer.parseInt(request.getParameter("idLocIn")));
		tra.setLocalidad(dl.getById(l));
		
		dt.update(tra.getIdTrabajo(), tra);
		request.setAttribute("IdTrabIn", tra);
		
		LinkedList<Trabajo> trab = dt.getAll();
		request.setAttribute("listaTrabajos", trab);
		request.getRequestDispatcher("WEB-INF/muestreoTrabajos.jsp").forward(request, response);
	}
}