package sv.edu.ues.igf115.controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sv.edu.ues.igf115.dao.*;
import sv.edu.ues.igf115.model.*;


@Transactional
@Service
public class TbAplicativoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "./users/new.jsp";
	private static String LIST_USER = "./users/lista.jsp";
	private static String LIST_INDEX = "./users/inicio.jsp";
	
	private TbAplicativoDao daoApli;
	private TbAplicativo departamento;
	
	@Autowired
	public TbAplicativoController(TbAplicativoDao daoApli) {
		this.daoApli = daoApli;
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {

			String userId = request.getParameter("userId");
			// Departamento
			// departamento=daoDepto.findByIdTbTipoAtributo(userId);
			// daoDepto.eliminar(departamento);
			//eliminarDepartamento(userId);
			forward = LIST_USER;
			// request.setAttribute("lst", dao.findByAll());

		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId");
				TbAplicativo tb_aplicativo = daoApli.daDepartamentoById(Short.parseShort(userId));
				request.setAttribute("tb_tipo_clase", tb_aplicativo);

			} catch (Exception e) {
				System.out.println("error " + e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;

			List<TbAplicativo> lst = daoApli.daDepartamentos();
			request.setAttribute("lst", lst);
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Departamento departamento = new Departamento();
		//departamento.setFecha(request.getParameter("descripcionMetodo"));
		departamento.setC_aplicativo(request.getParameter("c_aplicativo"));
		departamento.setD_aplicativo(request.getParameter("d_aplicativo"));

		daoApli.guardar(departamento);
		// RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", daoApli.daDepartamentos());
		// view.forward(request, response);
		response.sendRedirect(LIST_INDEX);
	}
	
	public boolean crearDepartamento(String ctipoclase, String dtipoclase, Date fecha) {
		try {

			if (daoApli.daDepartamentoByNombre(dtipoclase) == null) {
				TbAplicativo departamento = new TbAplicativo(ctipoclase,dtipoclase,fecha);
				daoApli.guardaActualiza(departamento);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error "+e);
		}
		return false;
	}
	
	public boolean eliminarDepartamento(TbAplicativo tbAplicativo) {

		try {
			daoApli.eliminar(tbAplicativo);
			return true;
		} catch (Exception e) {
			System.out.println("error crear TbAplicativoController " + e);
			return false;
		}

	}
/*
	public boolean eliminarDepartamento(String ctipoclase) {
		if (daoDepto.daDepartamentoByID(ctipoclase) != null) {
			TbTipoClase tbtipoclase = daoDepto.daDepartamentoByID(ctipoclase);
			daoDepto.eliminar(tbtipoclase);
			return true;
		} else
			return false;
	}*/

	public boolean modificarDepartamento(TbAplicativo tbAplicativo) {
		try {
			daoApli.guardaActualiza(tbAplicativo);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbAplicativoController Update");
		}
		return false;
	}
	/*
	public boolean modificarDepartamento(String ctipoclaseantiguo, String dtipoclase, Date fecha) {
		if (daoDepto.daDepartamentoByID(ctipoclaseantiguo) != null) {
			TbTipoClase tbtipoclase = daoDepto.daDepartamentoByID(ctipoclaseantiguo);
			//tbtipoclase.setD_tipo_clase(ctipoclase);
			tbtipoclase.setD_tipo_clase(dtipoclase);
			tbtipoclase.setF_ingreso(fecha);
			daoDepto.guardaActualiza(tbtipoclase);
			return true;
		} else
			return false;
	}*/
	
	
	public TbAplicativo daDepartamentoEntidad(Short id) {
		try {
			TbAplicativo departamento = daoApli.daDepartamentoById(id);
			return departamento;
		} catch (Exception e) {
			return null;
		}
		
	}

	public List<TbAplicativo> daDepartamentos() {
		return daoApli.daDepartamentos();
	}
	
	public TbAplicativo daDepartamentoByID(String id) {
		return daoApli.daDepartamentoByID(id);
	}

	public TbAplicativo daDepartamentoById(short id) {
		return daoApli.daDepartamentoById(id);
	}

	public TbAplicativo daDepartamentoByNombre(String nombre) {
		return daoApli.daDepartamentoByNombre(nombre);
	}
}
