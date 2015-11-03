package sv.edu.ues.igf115.controller;

import java.util.Date;
import java.util.List;

import sv.edu.ues.igf115.dao.AsInterfaceDao;
import sv.edu.ues.igf115.model.AsInterface;


public class AsInterfaceController {
	private AsInterfaceDao daoDepto = new AsInterfaceDao();

	public boolean crearDepartamento( Integer cInterface, String dInterface, String cUsuario, Date fIngreso) {
		if (daoDepto.daDepartamentoByNombre(cInterface) == null) {
			AsInterface departamento = new AsInterface(cInterface, dInterface, cUsuario, fIngreso);
			daoDepto.guardaActualiza(departamento);
			return true;
		} else
			return false;
	}

}
