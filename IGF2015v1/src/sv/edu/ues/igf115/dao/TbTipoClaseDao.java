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
public class TbTipoClaseDao {
private HibernateUtils hibernateUtil;
	
	@Autowired
	public TbTipoClaseDao (HibernateUtils hibernateUtil){
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
	public void guardaActualiza(TbTipoClase tbtipoclase) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tbtipoclase);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void guardar(TbTipoClase tbtipoclase) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tbtipoclase);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void eliminar(TbTipoClase tbtipoclase) {
		try {
			iniciaOperacion();
			sesion.delete(tbtipoclase);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public TbTipoClase daDepartamentoById(short idDep) {
		sesion = sessionFactory.openSession();
		// Retorna la instancia persistente de la clase por medio del atributo
		// identidad
		TbTipoClase id = (TbTipoClase) sesion.get(TbTipoClase.class,	new Short(idDep));
		sesion.close();
		return id;
	}

	public List<TbTipoClase> daDepartamentos() {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select d from  TbTipoClase d");
		List<TbTipoClase> tbtipoclase = query.list();
		sesion.close();
		return tbtipoclase;
	}

	public TbTipoClase daDepartamentoByNombre(String nombre) {
		try {

			sesion = sessionFactory.openSession();
			//Query query = sesion.getNamedQuery("   Departamentos.findByNombreDep");
			Query query= sesion.createQuery("Select dep from TbTipoClase dep where dep.d_tipo_clase=:d_tipo_clase");
			query.setParameter("d_tipo_clase", nombre);
			TbTipoClase depto = (TbTipoClase) query.uniqueResult();
			sesion.close();
			return depto;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByNombre"+e);
		}
		return null;
	}
	
	
	public TbTipoClase daDepartamentoByID(String id) {
		try {

			sesion = sessionFactory.openSession();
			Query query= sesion.createQuery("Select dep from TbTipoClase dep where dep.c_tipo_clase=:c_tipo_clase");
			query.setParameter("c_tipo_clase", id);
			TbTipoClase depto = (TbTipoClase) query.uniqueResult();
			sesion.close();
			return depto;	
		} catch (Exception e) {
			System.out.println("error DAO daDepartamentoByID"+e);
		}
		return null;
	}
}
