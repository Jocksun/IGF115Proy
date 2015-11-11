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


import sv.edu.ues.igf115.dao.AsClaseDao;
import sv.edu.ues.igf115.dao.AsMetodoDao;
import sv.edu.ues.igf115.dao.AsMetodoPKDao;
import sv.edu.ues.igf115.dao.TbTipoMetodoDao;
import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.model.AsMetodoPK;
import sv.edu.ues.igf115.model.TbTipoMetodo;
@Transactional
@Service
public class AsMetodoController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/asmetodo/new.jsp";
	private static String LIST_USER = "/asmetodo/asmetodo.jsp";
	
	private AsMetodoDao dao;
	private AsClaseDao asClaseDao;
	private TbTipoMetodoDao tbTipoMetodoDao;
	private AsMetodoPKDao asMetodoPKDao;
	
//	public AsMetodoController() {
//		this.dao = dao;
//		asClaseDao = new AsClaseDao();
//		tbTipoMetodoDao= new TbTipoMetodoDao();
//		asMetodoPKDao = new AsMetodoPKDao();
//		
//	}
	@Autowired
	public AsMetodoController(AsMetodoDao dao) {
		this.dao = dao;
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			
			String userId = request.getParameter("userId");
			AsMetodo asMetodo= dao.findByIdAsMetodo(userId);
			dao.eliminar(asMetodo);
			forward = LIST_USER;
			request.setAttribute("lst", dao.findByAll());
			
		} else if (action.equalsIgnoreCase("edit")) {
			
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId");
				
				AsMetodo asMetodo=dao.findByIdAsMetodo(userId);
				request.setAttribute("AsMetodo", asMetodo);		
				
				List<AsClase> lstAsClase = asClaseDao.findByAll();
				request.setAttribute("lstAsClase", lstAsClase);				
				List<TbTipoMetodo> lstTbTipoMetodo= tbTipoMetodoDao.findByAll();
				request.setAttribute("lstTbTipoMetodo", lstTbTipoMetodo);

				
			} catch (Exception e) {
				System.out.println("error "+e);
			}

		} else if (action.equalsIgnoreCase("listUser")) {
			
			forward = LIST_USER;
			List<AsMetodo> lst = dao.findByAll();
			request.setAttribute("lst", lst);
		
		} else {
			forward = INSERT_OR_EDIT;			
			List<AsClase> lstAsClase = asClaseDao.findByAll();
			request.setAttribute("lstAsClase", lstAsClase);			
			List<TbTipoMetodo> lstTbTipoMetodo= tbTipoMetodoDao.findByAll();
			request.setAttribute("lstTbTipoMetodo", lstTbTipoMetodo);		
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		AsMetodo asMetodo = new AsMetodo();
		AsClase asClase= asClaseDao.findByIdAsClase(request.getParameter("clase"));
		TbTipoMetodo tbTipoMetodo = tbTipoMetodoDao.findByIdTbTipoMetodo(request.getParameter("tipoMetodo"));
		AsMetodoPK asMetodoPK =asMetodoPKDao.findByIdAsMetodoPK(request.getParameter("codigoMetodo"));
		
		asMetodo.setAsClase(asClase);
		asMetodo.setAsMetodoPK(asMetodoPK);
		asMetodo.setDMetodo(request.getParameter("descripcionMetodo"));
		asMetodo.setDTipoRetorno(request.getParameter("descripcionTRetorno"));
		asMetodo.setCUsuario(request.getParameter("usuario"));
		asMetodo.setFIngreso(new Date());
		asMetodo.setBActivo(Integer.parseInt(request.getParameter("estado")));
		asMetodo.setNParametros(Integer.parseInt(request.getParameter("parametro")));
		asMetodo.setCTipoMetodo(tbTipoMetodo);
		dao.guardar(asMetodo);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		view.forward(request, response);
	}
	
	
	public List<AsMetodo> daAsMetodo() {
		return dao.findByAll();
	}
}
