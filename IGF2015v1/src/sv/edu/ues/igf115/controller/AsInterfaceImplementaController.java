package sv.edu.ues.igf115.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;

import sv.edu.ues.igf115.dao.AsInterfaceDao;
import sv.edu.ues.igf115.dao.AsInterfaceImplementaDao;
import sv.edu.ues.igf115.model.AsInterface;
import sv.edu.ues.igf115.model.AsInterfaceImplementa;

public class AsInterfaceImplementaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "./users/new.jsp";
	private static String LIST_USER = "./users/listAsInterface.jsp";
	private static String LIST_INDEX = "./users/inicio.jsp";

	private AsInterfaceImplementaDao daoAsInterImplemCont;
	private AsInterfaceImplementa asInterfaceImplementa;
	
	@Autowired
	public AsInterfaceImplementaController(AsInterfaceImplementaDao daoAsInterImplemCont) {
		this.daoAsInterImplemCont = daoAsInterImplemCont;
	}
	
	public boolean crearAsInterfaceImplementa(Integer cInterfaceImplementa, AsInterface cInterfacePadre, AsInterface cInterfaceHijo) {
		try {

			if (daoAsInterImplemCont.daAsInterfaceImplementaByNombre(cInterfaceImplementa) == null) {
				AsInterfaceImplementa asInterfaceImplementa = new AsInterfaceImplementa(cInterfaceImplementa, cInterfacePadre, cInterfaceHijo);
				daoAsInterImplemCont.guardaActualiza(asInterfaceImplementa);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.out.println("error "+e);
		}
		return false;
	}
	
	public boolean eliminar(AsInterface asInterface) {

		try {
			daoAsInterImplemCont.eliminar(asInterfaceImplementa);
			return true;
		} catch (Exception e) {
			System.out.println("error crear AsInterfaceController " + e);
			return false;
		}

	}
	
	public boolean update(AsInterfaceImplementa asInterfaceImplementa) {
		try {
			daoAsInterImplemCont.guardaActualiza(asInterfaceImplementa);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbTipoAtributoController Update");
		}
		return false;
	}
	
	
	public List<AsInterfaceImplementa> daAsInterfaceImplementa() {
		return daoAsInterImplemCont.daAsInterfaceImplementa();
	}

	public AsInterfaceImplementa daAsInterfaceImplementaById(Integer c_interfaceImplementa) {
		return daoAsInterImplemCont.daAsInterfaceImplementaByID(c_interfaceImplementa);
	}

	public AsInterfaceImplementa daAsInterfaceImplementaByNombre(Integer d_interface) {
		return daoAsInterImplemCont.daAsInterfaceImplementaByNombre(d_interface);
	}

}
