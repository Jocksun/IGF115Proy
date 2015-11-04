package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsMetodoPK;
import sv.edu.ues.igf115.utilidades.HibernateUtil;

public class AsMetodoPKDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(AsMetodoPK asMetodoPK) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asMetodoPK);
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
			AsMetodoPK asMetodoPK = findByIdAsMetodoPK(id);
			s.delete(asMetodoPK);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al borrar AsMetodo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(AsMetodoPK asMetodoPK) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asMetodoPK);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al Actualizar AsMetodoPK"
					+ e.getMessage());
			return false;
		}
	}

	public List<AsMetodoPK> findByAll() {
		try {
			iniciarSesion();
			// Query query = s.getNamedQuery("AsMetodoPK.findAll");
			Query query = s.createQuery("Select u From AsMetodoPK u");
			List<AsMetodoPK> lst = query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error AsMetodoPKDao---findByAll " + e);
		}
		return null;

	}

	public AsMetodoPK findByIdAsMetodoPK(String id) {

		try {
			iniciarSesion();
			// Query query =
			// s.getNamedQuery("AsMetodoPK.findByIdcTipoAtributo");
			Query query = s
					.createQuery("Select u from AsMetodoPK u where u.asMetodoPK.cMetodo =:id");
			query.setParameter("id", id);
			AsMetodoPK asMetodoPK = (AsMetodoPK) query
					.uniqueResult();
			return asMetodoPK;
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
