package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import sv.edu.ues.igf115.model.AsInterfaceImplementa;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

public class AsInterfaceImplementaDao {
private HibernateUtils hibernateUtil;
	
	
	@Autowired
	public AsInterfaceImplementaDao(HibernateUtils hibernateUtil) {
		super();
		this.hibernateUtil = hibernateUtil;
	}

	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}
	
	public List<AsInterfaceImplementa> daAsInterfaceImplementa() {
		sesion = sessionFactory.openSession();
		Query query = sesion.createQuery("Select d from  AsInterfaceImplementa d");
		List<AsInterfaceImplementa> asInterfaceImplementa = query.list();
		sesion.close();
		return asInterfaceImplementa;
	}
	
	public void guardaActualiza(AsInterfaceImplementa asInterfaceImplementa) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asInterfaceImplementa);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void eliminar(AsInterfaceImplementa asInterfaceImplementa) {
		try {
			iniciaOperacion();
			sesion.delete(asInterfaceImplementa);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
}
	public AsInterfaceImplementa daAsInterfaceImplementaByNombre(Integer nombre) {
		try {

			sesion = sessionFactory.openSession();
			Query query= sesion.createQuery("Select dep from AsInterfaceImplementa dep where dep.cInterfaceImplementa=:cInterfaceImplementa");
			query.setParameter("cInterfaceImplementa", nombre);
			AsInterfaceImplementa asInterImplementa = (AsInterfaceImplementa) query.uniqueResult();
			sesion.close();
			return asInterImplementa;	
		} catch (Exception e) {
			System.out.println("error DAO daAsInterfaceByNombre"+e);
		}
		return null;
	}
	
	
	public AsInterfaceImplementa daAsInterfaceImplementaByID(Integer id) {
		try {

			sesion = sessionFactory.openSession();
			Query query= sesion.createQuery("Select asinter from AsInterfaceImplementa asinter where asinter.c_interface=:id");
			query.setParameter("id", id);
			AsInterfaceImplementa asInterImplementa = (AsInterfaceImplementa) query.uniqueResult();
			sesion.close();
			return asInterImplementa;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByID"+e);
		}
		return null;
	}

	public boolean update(AsInterfaceImplementa asInterfaceImplementa) {
		try {
			iniciaOperacion();
			sesion.update(asInterfaceImplementa);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return false;
	}



}

