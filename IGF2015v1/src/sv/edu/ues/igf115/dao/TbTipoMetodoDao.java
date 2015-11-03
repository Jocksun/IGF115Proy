package sv.edu.ues.igf115.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.TbTipoMetodo;
import sv.edu.ues.igf115.utilidades.HibernateUtil;

public class TbTipoMetodoDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(TbTipoMetodo tbTipoMetodo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(tbTipoMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al guardar TbTipoMetodo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean borrar(String cTipoAtributo) {
		try {
			iniciarTransaccion();
			TbTipoMetodo tbTipoMetodo = findByIdTbTipoMetodo(cTipoAtributo);
			s.delete(tbTipoMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al borrar TbTipoMetodo "
					+ e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(TbTipoMetodo tbTipoMetodo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(tbTipoMetodo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this
					+ "Ocurrio un error al Actualizar TbTipoMetodo"
					+ e.getMessage());
			return false;
		}
	}

	public List<TbTipoMetodo> findByAll() {
		try {
			iniciarSesion();
			// Query query = s.getNamedQuery("TbTipoMetodo.findAll");
			Query query = s.createQuery("Select u From TbTipoMetodo u");
			List<TbTipoMetodo> lst = query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error TbTipoMetodoDao---findByAll " + e);
		}
		return null;

	}

	public TbTipoMetodo findByIdTbTipoMetodo(String id) {

		try {
			iniciarSesion();
			// Query query =
			// s.getNamedQuery("TbTipoMetodo.findByIdcTipoAtributo");
			Query query = s
					.createQuery("Select u from TbTipoMetodo u where u.cTipoMetodo =:id");
			query.setParameter("idTipo", id);
			TbTipoMetodo tbTipoMetodo = (TbTipoMetodo) query
					.uniqueResult();
			return tbTipoMetodo;
		} catch (Exception e) {
			System.out.println("Error TbTipoMetodoDao---findByIdTbTipoMetodo" + e);
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
