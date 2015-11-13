package sv.edu.ues.igf115.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//import sv.edu.ues.igf115.dao.AsClaseDao;
import sv.edu.ues.igf115.dao.AsParametroDao;
import sv.edu.ues.igf115.dao.AsParametroPKDao;
import sv.edu.ues.igf115.model.AsObservacion;
//import sv.edu.ues.igf115.dao.TbTipoMetodoDao;
//import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.model.AsParametro;
import sv.edu.ues.igf115.model.AsParametroPK;
//import sv.edu.ues.igf115.model.TbTipoMetodo;
@Transactional
@Service
public class AsParametroController {

	@Autowired
	private AsParametroDao dao;
	//@Autowired
	//private AsClaseDao asClaseDao;
	//@Autowired
	//private TbTipoMetodoDao tbTipoMetodoDao;
	@Autowired
	private AsParametroPKDao asParametroPKDao;
	

	@Autowired
	public AsParametroController(AsParametroDao dao,
			AsParametroPKDao asParametroPKDao) {
		this.dao = dao;
		//this.asClaseDao = asClaseDao;
		//this.tbTipoMetodoDao = tbTipoMetodoDao;
		this.asParametroPKDao = asParametroPKDao;
	}

	
	
	public List<AsParametro> daAsParametro() {
		return dao.findByAll();
	}
	
	
	/*public List<AsClase> daAsClase() {
		return asClaseDao.findByAll();
	}*/
	
	
	public AsParametro daAsParametro(Integer id) {
		return dao.findByIdAsParametro(id);
	}
	
	/*
	public TbTipoMetodo daTbTipoMetodoEntidad(String id) {
		return tbTipoMetodoDao.findByIdTbTipoMetodo(id);
	}*/
	
	/*public List<TbTipoMetodo> daTipoMetodo() {
		return tbTipoMetodoDao.findByAll();
	}*/
	
	
	public AsParametroPK daAsParametroPK(Integer clase,Integer metodo, Integer parametro){
		
		AsParametroPK asParametroPK= new AsParametroPK();
		asParametroPK.setCClase(clase);
		asParametroPK.setCMetodo(metodo);
		asParametroPK.setCParametro(parametro);
		
		AsParametroPK asPe=asParametroPKDao.daAsParametroPK(asParametroPK);
		return asPe;		
	}
	
	
	
	public boolean crear(AsParametro asParametro) {
		try {
			if (dao.findByIdAsParametro(asParametro.getAsParametroPK().getCParametro()) == null) {
				asParametro.setFIngreso(new Date());
				dao.guardar(asParametro);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear AsParametroController "+e );
		}
		return false;
	}
	public boolean eliminar(AsParametro asParametro) {

		try {
			dao.eliminar(asParametro);
			return true;
		} catch (Exception e) {
			System.out.println("error al crear el controlador: " + e);
			return false;
		}

	}
	public boolean update(AsParametro asParametro) {
		try {
			dao.guardar(asParametro);
			return true;
		} catch (Exception e) {
			System.out.println("Error al Actualizar");
		}
		return false;
	}
	
}
