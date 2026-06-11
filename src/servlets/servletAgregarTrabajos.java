package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionSQL.*;
import entidades.*;

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
		Trabajo tra = new Trabajo();
		Persona trabajador = new Persona();
		Persona cli = new Persona();
		Localidad l = new Localidad();
		DataLocalidad dl = new DataLocalidad();
		DataTrabajo dt = new DataTrabajo();
		DataPersona dp = new DataPersona();
		String menuPersona = request.getParameter("menuIn");
		
		String titulo = request.getParameter("tituloIn");
		String descripcion = request.getParameter("descripcionIn");
		String estado = request.getParameter("estadoIn");
		String dniTrabajador = request.getParameter("dniTrabIn");
		String dniCliente = request.getParameter("dniCliIn");
		String ubicacionAprox = request.getParameter("ubiIn");
		String fechaEstimadaIni = request.getParameter("fechaEstIniIn");
		String fechaEstimadaFin = request.getParameter("fechaEstFinIn");
		String fechaIni = request.getParameter("fechaIniIn");
		String fechaFin = request.getParameter("fechaFinIn");
		String valuacionTrabajo = request.getParameter("valIn");
		String precioFinal = request.getParameter("precioFin");
		String observaciones = request.getParameter("obsIn");
		String idLocalidad = request.getParameter("idLocIn");
		
		if (!"persona".equals(menuPersona)) {
		
			if (titulo == null || titulo.trim().isEmpty()
			        || descripcion == null || descripcion.trim().isEmpty()
			        || estado == null || estado.trim().isEmpty()
			        || dniTrabajador == null || dniTrabajador.trim().isEmpty()
			        || dniCliente == null || dniCliente.trim().isEmpty()
			        || ubicacionAprox == null || ubicacionAprox.trim().isEmpty()
			        || fechaEstimadaIni == null || fechaEstimadaIni.trim().isEmpty()
			        || fechaEstimadaFin == null || fechaEstimadaFin.trim().isEmpty()
			        || fechaIni == null || fechaIni.trim().isEmpty()
			        || fechaFin == null || fechaFin.trim().isEmpty()
			        || valuacionTrabajo == null || valuacionTrabajo.trim().isEmpty()
			        || precioFinal == null || precioFinal.trim().isEmpty()
			        || observaciones == null || observaciones.trim().isEmpty()
			        || idLocalidad == null || idLocalidad.trim().isEmpty()) {
			    request.getRequestDispatcher("WEB-INF/errorAgregarTrabajo.jsp").forward(request, response);
			    return;
			}
		
			try {
				trabajador.setDni(Integer.parseInt(request.getParameter("dniTrabIn")));
			    tra.setTrabajador(dp.getByDocumento(trabajador));
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/errorAgregarTrabajo.jsp").forward(request, response);
				return;
			}
			
			try {
				cli.setDni(Integer.parseInt(request.getParameter("dniCliIn")));
				tra.setCliente(dp.getByDocumento(cli));
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/errorAgregarTrabajo.jsp").forward(request, response);
				return;
			}
			
			try {
				l.setIdLocalidad(Integer.parseInt(request.getParameter("idLocIn")));
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/errorAgregarTrabajo.jsp").forward(request, response);
				return;
			}
		}
		menuPersona=request.getParameter("menuIn");
		tra.setTitulo(request.getParameter("tituloIn"));
		tra.setDescripcion(request.getParameter("descripcionIn"));
		tra.setEstado(request.getParameter("estadoIn"));
		try {
		    trabajador.setDni(Integer.parseInt(request.getParameter("dniTrabIn")));
		    tra.setTrabajador(dp.getByDocumento(trabajador));
		} catch (Exception e) {
		    tra.setTrabajador(null);
		}
		
		
		cli.setDni(Integer.parseInt(request.getParameter("dniCliIn")));
		tra.setCliente(dp.getByDocumento(cli));
		
		tra.setUbicacionAprox(request.getParameter("ubiAproxIn"));
		tra.setFechaEstimadaIni(request.getParameter("fechaEstIniIn"));
		tra.setFechaEstimadaFin(request.getParameter("fechaEstFinIn"));
		tra.setFechaIni(request.getParameter("fechaIniIn"));
		tra.setFechaFin(request.getParameter("fechaFinIn"));
		try {
			tra.setValuacionTrabajo(Double.parseDouble(request.getParameter("valIn")));			
		} catch (Exception e) {
			tra.setValuacionTrabajo(0.0);
		}
		
		try {
			tra.setPrecioFinal(Double.parseDouble(request.getParameter("precioFin")));
			
		} catch (Exception e) {
			tra.setPrecioFinal(0.0);
		}
		tra.setObservaciones(request.getParameter("obsIn"));
		try {
			l.setIdLocalidad(Integer.parseInt(request.getParameter("idLocIn")));
			
		} catch (Exception e) {
			DataLocalidad dL=new DataLocalidad();
			l.setDescripcion(request.getParameter("idLocIn"));
			l=dl.getLocByDesc(l);
		}
		tra.setLocalidad(dl.getById(l));
		
		dt.add(tra);
		
		request.setAttribute("persona", cli);
		
		if("persona".equals(menuPersona)) {
			LinkedList<Trabajo> trab = dt.getAllActivos();
			request.setAttribute("listaTrabajos", trab);
			request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);		
			}else {			
			LinkedList<Trabajo> trab = dt.getAll();
			request.setAttribute("listaTrabajos", trab);
			request.getRequestDispatcher("WEB-INF/muestreoTrabajos.jsp").forward(request, response);
		}
	}
}