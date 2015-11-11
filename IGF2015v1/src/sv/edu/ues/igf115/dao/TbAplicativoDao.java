package sv.edu.ues.igf115.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.*;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class TbAplicativoDao {
	
private HibernateUtils hibernateUtil;
	
	@Autowired
	public TbAplicativoDao (HibernateUtils hibernateUtil){
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
	
	public void guardaActualiza(TbAplicativo tbAplicativo) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tbAplicativo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void guardar(TbAplicativo tbAplicativo) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tbAplicativo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void eliminar(TbAplicativo tbAplicativo) {
		try {
			iniciaOperacion();
			sesion.delete(tbAplicativo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public TbAplicativo daDepartamentoById(short idDep) {
		sesion = sessionFactory.openSession();
		// Retorna la instancia persistente de la clase por medio del atributo
		// identidad
		TbAplicativo id = (TbAplicativo) sesion.get(TbAplicativo.class,	new Short(idDep));
		sesion.close();
		return id;
	}

	public List<TbAplicativo> daDepartamentos() {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select d from  TbAplicativo d");
		List<TbAplicativo> tbtipoclase = query.list();
		sesion.close();
		return tbtipoclase;
	}

	public TbAplicativo daDepartamentoByNombre(String nombre) {
		try {

			sesion = sessionFactory.openSession();
			//Query query = sesion.getNamedQuery("   Departamentos.findByNombreDep");
			Query query= sesion.createQuery("Select dep from TbAplicativo dep where dep.d_aplicativo=:d_aplicativo");
			query.setParameter("d_aplicativo", nombre);
			TbAplicativo depto = (TbAplicativo) query.uniqueResult();
			sesion.close();
			return depto;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByNombre"+e);
		}
		return null;
	}
	
	
	public TbAplicativo daDepartamentoByID(String id) {
		try {

			sesion = sessionFactory.openSession();
			Query query= sesion.createQuery("Select dep from TbAplicativo dep where dep.c_aplicativo=:c_aplicativo");
			query.setParameter("c_aplicativo", id);
			TbAplicativo depto = (TbAplicativo) query.uniqueResult();
			sesion.close();
			return depto;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByID"+e);
		}
		return null;
	}

}
