package sv.edu.ues.igf115.controller;

import java.io.Serializable;
import java.util.List;

import sv.edu.ues.igf115.dao.TbTipoAtributoDao;
import sv.edu.ues.igf115.model.TbTipoAtributo;


public class TbTipoAtributoController implements Serializable {
	
	private TbTipoAtributoDao dao= new TbTipoAtributoDao();
	
	
	public boolean guardar(TbTipoAtributo tbTipoAtributo) {
		return dao.guardar(tbTipoAtributo);
	}

	public boolean borrar(int idCliente) {
		return dao.borrar(idCliente);
	}

	public TbTipoAtributo findById(int idCliente) {
		TbTipoAtributo tbTipoAtributo = dao.findById(idCliente);
		return tbTipoAtributo;
	}

	public List findByAll() {
		List lst = dao.findByAll();
		return lst;
	}
}


