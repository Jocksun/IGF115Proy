package sv.edu.ues.igf115.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.utilidades.HibernateUtil;

public class AsAtributoDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(AsAtributo asAtributo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al guardar AsAtributo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean borrar(String cTipoAtributo) {
		try {
			iniciarTransaccion();
			AsAtributo asAtributo = findByIdAsAtributo(cTipoAtributo);
			s.delete(asAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al borrar AsAtributo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(AsAtributo asAtributo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(asAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al Actualizar AsAtributo"
					+ e.getMessage());
			return false;
		}
	}

	public List<AsAtributo> findByAll() {
		try {
			iniciarSesion();
			// Query query = s.getNamedQuery("AsAtributo.findAll");
			Query query = s.createQuery("Select u From AsAtributo u");
			List<AsAtributo> lst = query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error AsAtributoDao---findByAll " + e);
		}
		return null;

	}

	public AsAtributo findByIdAsAtributo(String idTipo) {

		try {
			iniciarSesion();
			// Query query =
			// s.getNamedQuery("AsAtributo.findByIdcTipoAtributo");
			Query query = s
					.createQuery("Select u from AsAtributo u where u.cTipoAtributo =:idTipo");
			query.setParameter("idTipo", idTipo);
			AsAtributo asAtributo = (AsAtributo) query
					.uniqueResult();
			return asAtributo;
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
