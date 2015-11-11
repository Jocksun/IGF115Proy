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
public class TbTipoClaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "./users/new.jsp";
	private static String LIST_USER = "./users/lista.jsp";
	private static String LIST_INDEX = "./users/inicio.jsp";
	
	private TbTipoClaseDao daoDepto;
	private TbTipoClase departamento;
	
	@Autowired
	public TbTipoClaseController(TbTipoClaseDao daoDepto) {
		this.daoDepto = daoDepto;
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
				TbTipoClase tb_tipo_clase = daoDepto.daDepartamentoById(Short.parseShort(userId));
				request.setAttribute("tb_tipo_clase", tb_tipo_clase);

			} catch (Exception e) {
				System.out.println("error " + e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;

			List<TbTipoClase> lst = daoDepto.daDepartamentos();
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
		departamento.setC_tipo_clase(request.getParameter("c_tipo_clase"));
		departamento.setD_tipo_clase(request.getParameter("d_tipo_clase"));

		daoDepto.guardar(departamento);
		// RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", daoDepto.daDepartamentos());
		// view.forward(request, response);
		response.sendRedirect(LIST_INDEX);
	}
	
	public boolean crearDepartamento(String ctipoclase, String dtipoclase, Date fecha) {
		try {

			if (daoDepto.daDepartamentoByNombre(dtipoclase) == null) {
				TbTipoClase departamento = new TbTipoClase(ctipoclase,dtipoclase,fecha);
				daoDepto.guardaActualiza(departamento);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error "+e);
		}
		return false;
	}
	
	public boolean eliminarDepartamento(TbTipoClase tbTipoClase) {

		try {
			daoDepto.eliminar(tbTipoClase);
			return true;
		} catch (Exception e) {
			System.out.println("error crear TbTipoAtributoController " + e);
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

	public boolean modificarDepartamento(TbTipoClase tbtipoclase) {
		try {
			daoDepto.guardaActualiza(tbtipoclase);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbTipoAtributoController Update");
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
	
	
	public TbTipoClase daDepartamentoEntidad(Short id) {
		try {
			TbTipoClase departamento = daoDepto.daDepartamentoById(id);
			return departamento;
		} catch (Exception e) {
			return null;
		}
		
	}

	public List<TbTipoClase> daDepartamentos() {
		return daoDepto.daDepartamentos();
	}
	
	public TbTipoClase daDepartamentoByID(String id) {
		return daoDepto.daDepartamentoByID(id);
	}

	public TbTipoClase daDepartamentoById(short id) {
		return daoDepto.daDepartamentoById(id);
	}

	public TbTipoClase daDepartamentoByNombre(String nombre) {
		return daoDepto.daDepartamentoByNombre(nombre);
	}
}

