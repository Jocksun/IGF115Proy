package sv.edu.ues.igf115.controller;


import java.util.Date;
import java.util.List;

//ASObservacion

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.ues.igf115.dao.AsObservacionDao;

import sv.edu.ues.igf115.model.AsObservacion;;

@Transactional
@Service
public class AsObservacionController {


	private AsObservacionDao dao;

	@Autowired
	public AsObservacionController(AsObservacionDao dao) {
		this.dao = dao;
	}
		
	public boolean crear(AsObservacion asObservacion) {
		try {
			if (dao.findByDObservacionAsObservacion(asObservacion.getDObservacion()) == null) {				
				asObservacion.setFIngreso(new Date());
				
				//System.out.println("prueba"+tbTipoAtributo.getCTipoAtributo()+"asss");
				
				
				dao.guardar(asObservacion);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error al Crear "+e );
		}
		return false;
	}
	
	
	public boolean eliminar(AsObservacion asObservacion) {

		try {
			dao.eliminar(asObservacion);
			return true;
		} catch (Exception e) {
			System.out.println("error al crear el controlador: " + e);
			return false;
		}

	}
	
	
	public List<AsObservacion> daAsObservaciones() {
		return dao.findByAll();
	}
	
	public AsObservacion daObservacionById(int id) {
		return dao.findByIdAsObservacion(id);
	}
	
	public boolean update(AsObservacion asObservacion) {
		try {
			dao.guardar(asObservacion);
			return true;
		} catch (Exception e) {
			System.out.println("Error al Actualizar");
		}
		return false;
	}	
}
