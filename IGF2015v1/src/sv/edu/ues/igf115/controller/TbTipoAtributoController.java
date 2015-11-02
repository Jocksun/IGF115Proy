package sv.edu.ues.igf115.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sv.edu.ues.igf115.dao.TbTipoAtributoDao;

import sv.edu.ues.igf115.model.TbTipoAtributo;

public class TbTipoAtributoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/tipoatributo/new.jsp";
	private static String LIST_USER = "/tipoatributo/atributos.jsp";

	private TbTipoAtributoDao dao;

	public TbTipoAtributoController() {
		super();
		dao = new TbTipoAtributoDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			dao.borrar(userId);
			forward = LIST_USER;
			request.setAttribute("tbTipoAtributo", dao.findByAll());
		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId");
				TbTipoAtributo tbTipoAtributo = dao
						.findByIdTbTipoAtributo(userId);
				request.setAttribute("tbTipoAtributo", tbTipoAtributo);
			} catch (Exception e) {
				System.out.println("error "+e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;

			List<TbTipoAtributo> lst = dao.findByAll();
			request.setAttribute("lst", lst);
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TbTipoAtributo tbTipoAtributo = new TbTipoAtributo();
		tbTipoAtributo.setCTipoAtributo(request.getParameter("codigo"));
		tbTipoAtributo.setDTipoAtributo(request.getParameter("descripcion"));
		tbTipoAtributo.setFIngreso(new Date());

		// String userid = request.getParameter("cTipoAtributo");
		// if(userid == null || userid.isEmpty())
		// {
		// dao.guardar(tbTipoAtributo);
		// }
		// // else
		// // {
		// user.setUname(userid);
		dao.guardar(tbTipoAtributo);
		// }
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		view.forward(request, response);
	}

	public boolean guardar(TbTipoAtributo tbTipoAtributo) {
		return dao.guardar(tbTipoAtributo);
	}

	public boolean borrar(String idCliente) {
		return dao.borrar(idCliente);
	}

	public boolean actualizar(TbTipoAtributo tbTipoAtributo) {
		return dao.Actualizar(tbTipoAtributo);
	}

	public List<TbTipoAtributo> findByAll() {
		List<TbTipoAtributo> lst = dao.findByAll();
		return lst;
	}
}
