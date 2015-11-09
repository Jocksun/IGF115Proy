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
import sv.edu.ues.igf115.dao.TbTipoAtributoDao;

import sv.edu.ues.igf115.model.TbTipoAtributo;

@Transactional
@Service
public class TbTipoAtributoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "./tipoatributo/new.jsp";
	private static String LIST_USER = "./tipoatributo/atributos.jsp";
	private static String LIST_INDEX = "./tipoatributo/index.jsp";
	

	private TbTipoAtributoDao dao;

	@Autowired
	public TbTipoAtributoController(TbTipoAtributoDao dao) {
		this.dao = dao;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			
			String userId = request.getParameter("userId");	
			TbTipoAtributo tbTipoAtributo=dao.findByIdTbTipoAtributo(userId);
			dao.eliminar(tbTipoAtributo);
			forward = LIST_INDEX;			
			request.setAttribute("lst", dao.findByAll());
		
		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				String userId = request.getParameter("userId"); 
				TbTipoAtributo tbTipoAtributo=dao.findByIdTbTipoAtributo(userId);			
				request.setAttribute("TbTipoAtributo", tbTipoAtributo);
				
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
		dao.guardar(tbTipoAtributo);
		//RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("lst", dao.findByAll());
		//view.forward(request, response);
		response.sendRedirect(LIST_INDEX);
	}

	
	public boolean crear(TbTipoAtributo tbTipoAtributo) {
		try {

			if (dao.findByIdTbTipoAtributo(tbTipoAtributo.getCTipoAtributo()) == null) {				
				tbTipoAtributo.setFIngreso(new Date());
				dao.guardar(tbTipoAtributo);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear TbTipoAtributoController "+e );
		}
		return false;
	}
	
	
	public boolean eliminar(TbTipoAtributo tbTipoAtributo) {
		
		try {
			dao.eliminar(tbTipoAtributo);
			return true;
		} catch (Exception e) {
			System.out.println("error crear TbTipoAtributoController "+e );
			return false;
		}
		
}
	
	
	public List<TbTipoAtributo> daTbTipoAtributos() {
		return dao.findByAll();
	}
	
	public TbTipoAtributo daTipoAtributoById(String id) {
		return dao.findByIdTbTipoAtributo(id);
	}
	
	public boolean update(TbTipoAtributo tbTipoAtributo) {
		try {
			dao.guardar(tbTipoAtributo);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbTipoAtributoController Update");
		}
		return false;
	}
	
}
