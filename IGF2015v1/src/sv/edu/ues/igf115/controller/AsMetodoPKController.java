package sv.edu.ues.igf115.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ues.igf115.dao.AsMetodoPKDao;


@Transactional
@Service
public class AsMetodoPKController {
	@Autowired
	private AsMetodoPKDao asMetodoPKDao;

	@Autowired
	public AsMetodoPKController(AsMetodoPKDao asMetodoPKDao) {
		this.asMetodoPKDao = asMetodoPKDao;
	}
	
	
	
}
