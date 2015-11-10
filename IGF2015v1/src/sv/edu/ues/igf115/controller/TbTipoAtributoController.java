package sv.edu.ues.igf115.controller;


import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.ues.igf115.dao.TbTipoAtributoDao;

import sv.edu.ues.igf115.model.TbTipoAtributo;

@Transactional
@Service
public class TbTipoAtributoController {


	private TbTipoAtributoDao dao;

	@Autowired
	public TbTipoAtributoController(TbTipoAtributoDao dao) {
		this.dao = dao;
	}
		
	public boolean crear(TbTipoAtributo tbTipoAtributo) {
		try {
			if (dao.findByIdTbTipoAtributo(tbTipoAtributo.getCTipoAtributo()) == null) {				
				tbTipoAtributo.setFIngreso(new Date());
				
				System.out.println("prueba"+tbTipoAtributo.getCTipoAtributo()+"asss");
				
				
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
			System.out.println("error crear TbTipoAtributoController " + e);
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
