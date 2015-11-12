package sv.edu.ues.igf115.controller;

import java.util.List;
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
public class AsMetodoController {

	@Autowired
	private AsMetodoDao dao;
	@Autowired
	private AsClaseDao asClaseDao;
	@Autowired
	private TbTipoMetodoDao tbTipoMetodoDao;
	@Autowired
	private AsMetodoPKDao asMetodoPKDao;
	

	@Autowired
	public AsMetodoController(AsMetodoDao dao, AsClaseDao asClaseDao,
			TbTipoMetodoDao tbTipoMetodoDao, AsMetodoPKDao asMetodoPKDao) {
		this.dao = dao;
		this.asClaseDao = asClaseDao;
		this.tbTipoMetodoDao = tbTipoMetodoDao;
		this.asMetodoPKDao = asMetodoPKDao;
	}

	
	
	public List<AsMetodo> daAsMetodo() {
		return dao.findByAll();
	}
	
	
	public List<AsClase> daAsClase() {
		return asClaseDao.findByAll();
	}
	
	
	public AsClase daAsClaseEntidad(Integer id) {
		return asClaseDao.findByIdAsClase(id);
	}
	
	
	public TbTipoMetodo daTbTipoMetodoEntidad(Integer id) {
		return tbTipoMetodoDao.findByIdTbTipoMetodo(id);
	}
	
	public List<TbTipoMetodo> daTipoMetodo() {
		return tbTipoMetodoDao.findByAll();
	}
	
	
	public AsMetodoPK daAsMetodoPK(Integer clase,Integer metodo){
		
		AsMetodoPK asMetodoPK= new AsMetodoPK();
		asMetodoPK.setCClase(clase);
		asMetodoPK.setCMetodo(metodo);
		
		AsMetodoPK asMe=asMetodoPKDao.daAsMetodoPK(asMetodoPK);
		return asMe;		
	}
	
	
	
	public boolean crear(AsMetodo asMetodo) {
		try {
			if (dao.findByIdAsMetodo(asMetodo.getAsMetodoPK().getCMetodo()) == null) {							
				dao.guardar(asMetodo);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear AsMetodoController "+e );
		}
		return false;
	}
	
	
}
