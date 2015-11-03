package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.utilidades.HibernateUtil;

public class AsClaseDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(AsClase asClase) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asClase);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al guardar AsClase "
					+ e.getMessage());
			return false;
		}
	}

	public boolean borrar(String id) {
		try {
			iniciarTransaccion();
			AsClase asClase = findByIdAsClase(id);
			s.delete(asClase);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al borrar AsClase "
					+ e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(AsClase asClase) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asClase);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al Actualizar AsClase"
					+ e.getMessage());
			return false;
		}
	}

	public List<AsClase> findByAll() {
		try {
			iniciarSesion();
			// Query query = s.getNamedQuery("AsClase.findAll");
			Query query = s.createQuery("Select u From AsClase u");
			List<AsClase> lst = query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error AsClaseDao---findByAll " + e);
		}
		return null;

	}

	public AsClase findByIdAsClase(String id) {

		try {
			iniciarSesion();
			// Query query =
			// s.getNamedQuery("AsClase.findByIdcTipoAtributo");
			Query query = s
					.createQuery("Select u from AsClase u where u.cClase =:id");
			query.setParameter("id", id);
			AsClase asClase = (AsClase) query
					.uniqueResult();
			return asClase;
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
