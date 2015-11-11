package sv.edu.ues.igf115.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ues.igf115.dao.AsAtributoDao;
import sv.edu.ues.igf115.dao.AsClaseDao;
import sv.edu.ues.igf115.dao.TbTipoAtributoDao;
import sv.edu.ues.igf115.dao.AsMetodoDao;
import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.model.TbTipoAtributo;

@Transactional
@Service
public class AsAtributoController  {

	@Autowired
	private AsAtributoDao dao;
	@Autowired
	private AsClaseDao asClaseDao;
	
	@Autowired
	private TbTipoAtributoDao tbTipoAtributoDao;
	
	@Autowired
	private AsMetodoDao asMetodoDao;
	
	@Autowired
	public AsAtributoController(AsAtributoDao dao, AsClaseDao asc, TbTipoAtributoDao tbTipoAtributoDao,AsMetodoDao asMetodoDao ) {
		this.dao = dao;
		this.asClaseDao = asc;
		this.tbTipoAtributoDao=tbTipoAtributoDao;
		this.asMetodoDao=asMetodoDao;
	}
	
	public List<AsAtributo> daAsAtributo() {
		return dao.findByAll();
	}

	public List<AsClase> daAsClase() {
		return asClaseDao.findByAll();
	}

	public List<AsMetodo> daAsMetodo() {
		return  asMetodoDao.findByAll();
	}
	
	public List<TbTipoAtributo> daTipoAtributo() {
		return  tbTipoAtributoDao.findByAll(); 
	}
	
	public boolean crear(AsAtributo asAtributo) {
		try {
			if (dao.findByIdAsAtributo(asAtributo.getCClase()) == null) {				
				asAtributo.setFIngreso(new Date());				
				dao.guardar(asAtributo);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear AsAtributoController "+e );
		}
		return false;
	}
	
	
	public AsAtributo daAsAtributoById(int id){
		return dao.findByIdAsAtributo(id);
	}
	
	public boolean update(AsAtributo asAtributo) {
		try {
			dao.guardar(asAtributo);
			return true;
		} catch (Exception e) {
			System.out.println("Error  AsAtributoController Update");
		}
		return false;
	}	
	
	
	public boolean eliminar(AsAtributo asAtributo) {

		try {
			dao.borrar(asAtributo);
			return true;
		} catch (Exception e) {
			System.out.println("error crear AsAtributoController " + e);
			return false;
		}

	}
	
}
