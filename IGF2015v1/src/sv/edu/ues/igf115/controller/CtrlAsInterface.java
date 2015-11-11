package sv.edu.ues.igf115.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import sv.edu.ues.igf115.dao.AsInterfaceDao;
import sv.edu.ues.igf115.model.AsInterface;

public class CtrlAsInterface extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "./users/new.jsp";
	private static String LIST_USER = "./users/listAsInterface.jsp";
	private static String LIST_INDEX = "./users/inicio.jsp";

	private AsInterfaceDao daoAsInter;
	private AsInterface asInterface;
	
	@Autowired
	public CtrlAsInterface(AsInterfaceDao daoAsInter) {
		this.daoAsInter = daoAsInter;
	}
	
	public boolean crearAsInterface(String d_interface, String c_usuario, Date f_ingreso) {
		try {

			if (daoAsInter.daAsInterfaceByNombre(d_interface) == null) {
				AsInterface asInterface = new AsInterface(d_interface, c_usuario, f_ingreso);
				daoAsInter.guardaActualiza(asInterface);
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
			daoAsInter.eliminar(asInterface);
			return true;
		} catch (Exception e) {
			System.out.println("error crear AsInterfaceController " + e);
			return false;
		}

	}
	
	public boolean update(AsInterface asInterface) {
		try {
			daoAsInter.guardaActualiza(asInterface);
			return true;
		} catch (Exception e) {
			System.out.println("Error  TbTipoAtributoController Update");
		}
		return false;
	}
	
	
	public List<AsInterface> daAsInterfaces() {
		return daoAsInter.daAsInterface();
	}

	public AsInterface daAsInterfaceById(short c_interface) {
		return daoAsInter.daAsInterfaceByID(c_interface);
	}

	public AsInterface daAsInterfaceByNombre(String d_interface) {
		return daoAsInter.daAsInterfaceByNombre(d_interface);
	}
}
