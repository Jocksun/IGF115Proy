package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.TbTipoAtributo;
import sv.edu.ues.igf115.utilidades.HibernateUtil;




public class TbTipoAtributoDao {
	private HibernateUtil hu = new HibernateUtil();
	private SessionFactory sf;
	private Session s;
	private Transaction tx;

	public boolean guardar(TbTipoAtributo tbTipoAtributo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(tbTipoAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
			return false;
		}
	}

	public boolean borrar(int idCliente) {
		try {
			iniciarTransaccion();
			TbTipoAtributo tbTipoAtributo = findByIdCliente(idCliente);
			s.delete(tbTipoAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error " + e.getMessage());
			return false;
		}
	}

	public TbTipoAtributo findById(int idCliente) {
		iniciarSesion();
		TbTipoAtributo tbTipoAtributo = findByIdCliente(idCliente);
		finSesion();
		return tbTipoAtributo;
	}

	public List findByAll() {
		iniciarSesion();
		Query query = s.getNamedQuery("TbTipoAtributo.findByAll");
		List lst = query.list();
		finSesion();
		return lst;
	}

	private TbTipoAtributo findByIdCliente(int idCliente) {
		Query query = s.getNamedQuery("Cliente.findByIdCliente");
		query.setParameter("id", idCliente);
		TbTipoAtributo tbTipoAtributo = (TbTipoAtributo) query.uniqueResult();
		return tbTipoAtributo;
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
