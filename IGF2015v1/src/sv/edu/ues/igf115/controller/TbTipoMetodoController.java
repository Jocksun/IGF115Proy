package sv.edu.ues.igf115.controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sv.edu.ues.igf115.dao.TbTipoMetodoDao;
import sv.edu.ues.igf115.model.TbTipoMetodo;

public class TbTipoMetodoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/tbtipometodo/new.jsp";
	private static String LIST_USER = "/tbtipometodo/tbtipometodo.jsp";

	private TbTipoMetodoDao dao;

	public TbTipoMetodoController() {
		super();
		dao = new TbTipoMetodoDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			TbTipoMetodo tbTipoMetodo= dao.findByIdTbTipoMetodo(userId);
			dao.eliminar(tbTipoMetodo);
			forward = LIST_USER;
			request.setAttribute("lst", dao.findByAll());
		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId");
				TbTipoMetodo tbTipoMetodo = dao
						.findByIdTbTipoMetodo(userId);
				request.setAttribute("TbTipoMetodo", tbTipoMetodo);
			} catch (Exception e) {
				System.out.println("error "+e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;

			List<TbTipoMetodo> lst = dao.findByAll();
			request.setAttribute("lst", lst);
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TbTipoMetodo tbTipoMetodo = new TbTipoMetodo();
		tbTipoMetodo.setCTipoMetodo(request.getParameter("ctipometodo"));
		tbTipoMetodo.setDTipoMetodo(request.getParameter("dtipometodo"));
		tbTipoMetodo.setFIngreso(new Date());
		dao.guardar(tbTipoMetodo);
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		view.forward(request, response);
	}

	
}
