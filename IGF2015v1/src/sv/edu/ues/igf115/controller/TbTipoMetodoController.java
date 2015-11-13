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

import sv.edu.ues.igf115.dao.TbTipoMetodoDao;
import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.model.TbTipoAtributo;
import sv.edu.ues.igf115.model.TbTipoMetodo;

@Transactional
@Service
public class TbTipoMetodoController {

	
	private TbTipoMetodoDao dao;

	
   @Autowired
	public TbTipoMetodoController(TbTipoMetodoDao dao) {
		this.dao = dao;
	}

   public List<TbTipoMetodo> daTbTipoMetodo(){
		return dao.findByAll();
	}
	
   
   public boolean crear(TbTipoMetodo tbTipoMetodo) {
		try {
			if (dao.findByIdTbTipoMetodo(tbTipoMetodo.getCTipoMetodo()) == null) {				
				
				tbTipoMetodo.setFIngreso(new Date());				
				dao.guardar(tbTipoMetodo);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear TbTipoMetodoController "+e );
		}
		return false;
	}
   
   
   public boolean update(TbTipoMetodo tbTipoMetodo) {
		try {
			dao.guardar(tbTipoMetodo);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbTipoMetodoController Update");
		}
		return false;
	}	
   
   public TbTipoMetodo daTbTipoMetodoById(String id){
		return dao.findByIdTbTipoMetodo(id);
	}
   
   
   public boolean eliminar(TbTipoMetodo tbTipoMetodo) {

		try {
			dao.eliminar(tbTipoMetodo);
			return true;
		} catch (Exception e) {
			System.out.println("error crear TbTipoMetodoController " + e);
			return false;
		}

	}
}
