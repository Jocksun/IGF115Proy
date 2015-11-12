package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsClase;
import sv.edu.ues.igf115.model.AsInterface;

import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsInterfaceDao {
	
	@Autowired
	private HibernateUtils hibernateUtil;
	
	
	@Autowired
	public AsInterfaceDao(HibernateUtils hibernateUtil) {
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
	
	public List<AsInterface> daAsInterface() {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select d from  AsInterface d");
		List<AsInterface> asInterface = query.list();
		sesion.close();
		return asInterface;
	}
	
	public void guardaActualiza(AsInterface asInterface) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asInterface);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void eliminar(AsInterface asInterface) {
		try {
			iniciaOperacion();
			sesion.delete(asInterface);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


	public AsInterface daAsInterfaceByNombre(String nombre) {
		try {

			sesion = sessionFactory.openSession();
			//Query query = sesion.getNamedQuery("   Departamentos.findByNombreDep");
			Query query= sesion.createQuery("Select dep from AsInterface dep where dep.d_interface=:d_interface");
			query.setParameter("d_interface", nombre);
			AsInterface asInter = (AsInterface) query.uniqueResult();
			sesion.close();
			return asInter;	
		} catch (Exception e) {
			System.out.println("error DAO daAsInterfaceByNombre"+e);
		}
		return null;
	}
	
	
	public AsInterface daAsInterfaceByID(Short id) {
		try {

			sesion = sessionFactory.openSession();
			Query query= sesion.createQuery("Select asinter from AsInterface asinter where asinter.c_interface=:id");
			query.setParameter("id", id);
			AsInterface asInter = (AsInterface) query.uniqueResult();
			sesion.close();
			return asInter;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByID"+e);
		}
		return null;
	}

	public boolean update(AsInterface asInterface) {
		try {
			iniciaOperacion();
			sesion.update(asInterface);
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

	public List<AsInterface> findByAll() {
		sesion = sessionFactory.openSession();
		Query query = sesion.createQuery("Select u From AsInterface u");
		List<AsInterface> asInterface = query.list();
		sesion.close();
		return asInterface;
	}

}
