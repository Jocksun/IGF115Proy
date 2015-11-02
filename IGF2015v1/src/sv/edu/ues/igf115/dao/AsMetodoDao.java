package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.utilidades.HibernateUtil;

public class AsMetodoDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(AsMetodo asMetodo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al guardar AsMetodo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean borrar(String id) {
		try {
			iniciarTransaccion();
			AsMetodo asMetodo = findByIdAsMetodo(id);
			s.delete(asMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al borrar AsMetodo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(AsMetodo asMetodo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al Actualizar AsMetodo"
					+ e.getMessage());
			return false;
		}
	}

	public List<AsMetodo> findByAll() {
		try {
			iniciarSesion();
			// Query query = s.getNamedQuery("AsMetodo.findAll");
			Query query = s.createQuery("Select u From AsMetodo u");
			List<AsMetodo> lst = query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error AsMetodoDao---findByAll " + e);
		}
		return null;

	}

	public AsMetodo findByIdAsMetodo(String id) {

		try {
			iniciarSesion();
			// Query query =
			// s.getNamedQuery("AsMetodo.findByIdcTipoAtributo");
			Query query = s
					.createQuery("Select u from AsMetodo u where u.asMetodoPK.cMetodo =:id");
			query.setParameter("id", id);
			AsMetodo asMetodo = (AsMetodo) query
					.uniqueResult();
			return asMetodo;
		} catch (Exception e) {
			System.out.println("eroro  " + e);
		}
		return null;

	}

	private void iniciarTransaccion() {
		sf = hu.getSf();
		s = sf.openSession();
		tx = s.beginTransaction();
	}

	private void finTransaccion() {
		s.flush();
		tx.commit();
		s.close();
	}

	private void iniciarSesion() {
		sf = hu.getSf();
		s = sf.openSession();
	}

	private void finSesion() {
		s.flush();
		s.close();
	}
}
