package sv.edu.ues.igf115.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.ues.igf115.dao.AsClaseInterfaceDao;

@Transactional
@Service
public class AsClaseInterfaceController {

	@Autowired
	private AsClaseInterfaceDao asClaseInterfaceDao;

	public AsClaseInterfaceController(AsClaseInterfaceDao asClaseInterfaceDao) {
		this.asClaseInterfaceDao = asClaseInterfaceDao;
	}
	
	
}
