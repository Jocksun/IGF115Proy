package sv.edu.ues.igf115.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ues.igf115.dao.AsParametroPKDao;
import sv.edu.ues.igf115.model.AsParametro;
import sv.edu.ues.igf115.model.AsParametroPK;


@Transactional
@Service
public class AsParametroPKController {
	@Autowired
	private AsParametroPKDao asParametroPKDao;

	@Autowired
	public AsParametroPKController(AsParametroPKDao asParametroPKDao) {
		this.asParametroPKDao = asParametroPKDao;
	}
	
	public AsParametroPK daAsParametroPK(Integer id) {
		return asParametroPKDao.findByIdAsParametroPK(id);
	}
	public boolean crear(AsParametroPK asParametroPK) {
		try {
			if (asParametroPKDao.findByIdAsParametroPK(asParametroPK.getCParametro()) == null) {							
				asParametroPKDao.guardar(asParametroPK);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error crear AsParametroPKController "+e );
		}
		return false;
	}
}
