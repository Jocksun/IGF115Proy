package sv.edu.ues.igf115.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ues.igf115.dao.AsInterfaceDao;
import sv.edu.ues.igf115.model.AsInterface;

@Transactional
@Service
public class AsInterfaceController {
	private AsInterfaceDao daoDepto;
	
	
   @Autowired
	public AsInterfaceController(AsInterfaceDao daoDepto) {
		this.daoDepto = daoDepto;
	}



	public boolean crearDepartamento( Integer cInterface, String dInterface, String cUsuario, Date fIngreso) {
		if (daoDepto.daDepartamentoByNombre(cInterface) == null) {
			AsInterface departamento = new AsInterface(cInterface, dInterface, cUsuario, fIngreso);
			daoDepto.guardaActualiza(departamento);
			return true;
		} else
			return false;
	}

}
