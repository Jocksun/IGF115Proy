package sv.edu.ues.igf115.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sv.edu.ues.igf115.dao.AsAtributoDao;
import sv.edu.ues.igf115.dao.AsMetodoDao;
import sv.edu.ues.igf115.dao.TbTipoAtributoDao;
import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.model.TbTipoAtributo;



public class AsAtributoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/asatributo/new.jsp";
	private static String LIST_USER = "/asatributo/asatributo.jsp";

	private AsAtributoDao dao;
	private TbTipoAtributoDao tbTipoAtributoDao;
	private AsMetodoDao asMetodoDao;

	public AsAtributoController() {
		super();
		dao = new AsAtributoDao();
		tbTipoAtributoDao= new TbTipoAtributoDao();
		asMetodoDao = new AsMetodoDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			dao.borrar(userId);
			forward = LIST_USER;
			request.setAttribute("lst", dao.findByAll());
		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId");
				AsAtributo asAtributo = dao.findByIdAsAtributo(userId);
				request.setAttribute("AsAtributo", asAtributo);
				
				List<TbTipoAtributo> lstAtributo = tbTipoAtributoDao.findByAll();
				request.setAttribute("lstAtributo", lstAtributo);
				
				List<AsMetodo> lstMetodo=asMetodoDao.findByAll();
				request.setAttribute("lstMetodo", lstMetodo);
				
			} catch (Exception e) {
				System.out.println("error "+e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			List<AsAtributo> lst = dao.findByAll();
			request.setAttribute("lst", lst);
		} else {
			forward = INSERT_OR_EDIT;
			List<TbTipoAtributo> lstAtributo = tbTipoAtributoDao.findByAll();
			request.setAttribute("lstAtributo", lstAtributo);
			
			List<AsMetodo> lstMetodo=asMetodoDao.findByAll();
			request.setAttribute("lstMetodo", lstMetodo);
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AsAtributo asAtributo = new AsAtributo();
		asAtributo.setCTipoAtributo(request.getParameter("codigo"));
	//	asAtributo.setDTipoAtributo(request.getParameter("descripcion"));
		asAtributo.setFIngreso(new Date());

		// String userid = request.getParameter("cTipoAtributo");
		// if(userid == null || userid.isEmpty())
		// {
		// dao.guardar(asAtributo);
		// }
		// // else
		// // {
		// user.setUname(userid);
		dao.guardar(asAtributo);
		// }
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		view.forward(request, response);
	}

	public boolean guardar(AsAtributo asAtributo) {
		return dao.guardar(asAtributo);
	}

	public boolean borrar(String idCliente) {
		return dao.borrar(idCliente);
	}

	public boolean actualizar(AsAtributo asAtributo) {
		return dao.Actualizar(asAtributo);
	}

	public List<AsAtributo> findByAll() {
		List<AsAtributo> lst = dao.findByAll();
		return lst;
	}
}
