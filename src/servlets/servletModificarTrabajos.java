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
		
		Trabajo tra = new Trabajo();
		Persona trabajador = new Persona();
		Persona cli = new Persona();
		Localidad l = new Localidad();
		DataLocalidad dl = new DataLocalidad();
		DataTrabajo dt = new DataTrabajo();
		DataPersona dp = new DataPersona();
		String menuPersona= new String();
		
		menuPersona=request.getParameter("menuIn");
		tra.setIdTrabajo(Integer.parseInt(request.getParameter("IdTrabIn")));
		tra.setTitulo(request.getParameter("tituloIn"));
		tra.setDescripcion(request.getParameter("descripcionIn"));
		trabajador.setDni(Integer.parseInt(request.getParameter("dniTrabIn")));
		tra.setTrabajador(dp.getByDocumento(trabajador));
		cli.setDni(Integer.parseInt(request.getParameter("dniCliIn")));
		tra.setCliente(dp.getByDocumento(cli));
		tra.setEstado(request.getParameter("estadoIn"));

		try {
			tra.setFechaFin(request.getParameter("fechaIniIn"));
			if (tra.getFechaIni().equals("")) {
				tra.setFechaIni("1990-01-01");
			}
		} catch (Exception e) {
			System.out.println("Sin fecha de inicial");
			tra.setFechaIni("1990-01-01");
		}
		
		try {
			tra.setFechaFin(request.getParameter("fechaFinIn"));
			if (tra.getFechaFin().equals("")) {
				tra.setFechaFin("1990-01-01");
			}
		} catch (Exception e) {
			System.out.println("Sin fecha de fin");
			tra.setFechaFin("1990-01-01");
		}
		
		tra.setUbicacionAprox(request.getParameter("ubiAproxIn"));
		tra.setFechaEstimadaIni(request.getParameter("fechaEstIniIn"));
		tra.setFechaEstimadaFin(request.getParameter("fechaEstFinIn"));
		try {
			tra.setValuacionTrabajo(Double.parseDouble(request.getParameter("valIn")));
		} catch (Exception e) {
			System.out.println("Sin valuacion");
			tra.setValuacionTrabajo(0.0);
		}

		tra.setPrecioFinal(Double.parseDouble(request.getParameter("precioFin")));
		tra.setObservaciones(request.getParameter("obsIn"));
		l.setIdLocalidad(Integer.parseInt(request.getParameter("idLocIn")));
		tra.setLocalidad(dl.getById(l));
		
		dt.update(tra.getIdTrabajo(), tra);
		request.setAttribute("IdTrabIn", tra);
		
		Persona usuario = new Persona();
		String userIn = request.getParameter("userIn");

		if (userIn != null && !userIn.trim().isEmpty()) {
		    usuario.setDni(Integer.parseInt(userIn));
		} else {
		    usuario.setDni(trabajador.getDni());
		}

		usuario = dp.getByDocumento(usuario);

		if ("persona".equals(menuPersona)) {
		    request.setAttribute("persona", usuario);

		    if ("cotizadoPendienteConfirmacion".equals(tra.getEstado())) {
		        LinkedList<Trabajo> trab = dt.getAllActivos();
		        request.setAttribute("listaTrabajos", trab);
		        request.getRequestDispatcher("WEB-INF/menuPersonas.jsp").forward(request, response);
		    } else {
		        LinkedList<Trabajo> trab = dt.getAllPorPersona(usuario);
		        request.setAttribute("listaTrabajos", trab);
		        request.getRequestDispatcher("WEB-INF/misChangas.jsp").forward(request, response);
		    }
		} else {
		    LinkedList<Trabajo> trab = dt.getAll();
		    request.setAttribute("listaTrabajos", trab);
		    request.getRequestDispatcher("WEB-INF/muestreoTrabajos.jsp").forward(request, response);
		}
	}
}

