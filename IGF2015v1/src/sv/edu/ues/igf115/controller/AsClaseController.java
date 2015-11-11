package sv.edu.ues.igf115.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ues.igf115.dao.AsClaseDao;
import sv.edu.ues.igf115.model.AsClase;

@Transactional
@Service
public class AsClaseController {

	@Autowired
	private AsClaseDao asClaseDao;

	@Autowired
	public AsClaseController(AsClaseDao asClaseDao) {
		this.asClaseDao = asClaseDao;
	}
	
	public List<AsClase> daAsClase() {
		return asClaseDao.findByAll();
	}
	
}
