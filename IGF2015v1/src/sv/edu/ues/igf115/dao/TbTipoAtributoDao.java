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
			System.err.println(this + "Ocurrio un error al guardar TbTipoAtributo " + e.getMessage());
			return false;
		}
	}
	
	

	public boolean borrar(String cTipoAtributo) {
		try {
			iniciarTransaccion();
			TbTipoAtributo tbTipoAtributo = findByIdTbTipoAtributo(cTipoAtributo);
			s.delete(tbTipoAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error al borrar TbTipoAtributo " + e.getMessage());
			return false;
		}
	}

	public boolean Actualizar(TbTipoAtributo tbTipoAtributo) {
		try {
			iniciarTransaccion();
			s.saveOrUpdate(tbTipoAtributo);
			finTransaccion();
			return true;
		} catch (Exception e) {
			System.err.println(this + "Ocurrio un error al Actualizar TbTipoAtributo" + e.getMessage());
			return false;
		}
	}


	public List<TbTipoAtributo> findByAll() {
		try {
			iniciarSesion();
			//Query query = s.getNamedQuery("TbTipoAtributo.findAll");
			Query query = s.createQuery("Select u From TbTipoAtributo u");
			List<TbTipoAtributo> lst =query.list();
			finSesion();
			return lst;
		} catch (Exception e) {
			System.out.println("Error TbTipoAtributoDao---findByAll "+e);
		}
		return null;
		
	}

	public TbTipoAtributo findByIdTbTipoAtributo(String idTipo) {
		Query query = s.getNamedQuery("TbTipoAtributo.findByIdcTipoAtributo");
		query.setParameter("tipoAtributo", idTipo);
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
