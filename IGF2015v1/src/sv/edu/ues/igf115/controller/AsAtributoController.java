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

import sv.edu.ues.igf115.dao.AsAtributoDao;
import sv.edu.ues.igf115.dao.AsClaseDao;
import sv.edu.ues.igf115.dao.AsMetodoDao;
import sv.edu.ues.igf115.dao.TbTipoAtributoDao;
import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.model.TbTipoAtributo;

@Transactional
@Service
public class AsAtributoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/asatributo/new.jsp";
	private static String LIST_USER = "/asatributo/asatributo.jsp";

	private AsAtributoDao dao;
	private TbTipoAtributoDao tbTipoAtributoDao;
	private AsMetodoDao asMetodoDao;
	private AsClaseDao asClaseDao;

	@Autowired
	public AsAtributoController(AsAtributoDao dao ) {

		this.dao = dao;
//		tbTipoAtributoDao= new TbTipoAtributoDao();
//		asMetodoDao = new AsMetodoDao();
//		asClaseDao = new AsClaseDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			AsAtributo asAtributo=dao.findByIdAsAtributo(userId);
			dao.borrar(asAtributo);
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
				
				List<AsClase> lstAsClase=asClaseDao.findByAll();
				request.setAttribute("lstAsClase", lstAsClase);
				
				
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
			
			List<AsClase> lstAsClase=asClaseDao.findByAll();
			request.setAttribute("lstAsClase", lstAsClase);
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AsAtributo asAtributo = new AsAtributo();
	
		asAtributo.setCClase(Integer.parseInt(request.getParameter("clase")));
		asAtributo.setCAtributo(Integer.parseInt(request.getParameter("codigoAtributo")));
		asAtributo.setCMetodo(Integer.parseInt(request.getParameter("metodoid")));
		asAtributo.setDAtributo(request.getParameter("descripcioAtrib"));
		asAtributo.setDTipoDatoAtributo(request.getParameter("descripcionTipoDatoAtr"));
		asAtributo.setCUsuario(request.getParameter("usuario"));
		asAtributo.setFIngreso(new Date());
		asAtributo.setCTipoAtributo(request.getParameter("codTipoAtrib"));
		
		dao.guardar(asAtributo);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		view.forward(request, response);
	}

	
}
