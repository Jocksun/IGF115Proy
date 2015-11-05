package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsInterface;
import sv.edu.ues.igf115.utilidades.HibernateUtils;


public class AsInterfaceDao {

	private HibernateUtils hibernateUtil = new HibernateUtils();
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

	public void guardaActualiza(AsInterface departamento) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(departamento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(AsInterface departamento) {
		try {
			iniciaOperacion();
			sesion.delete(departamento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public AsInterface daDepartamentoById(short idDep) {
		sesion = sessionFactory.openSession();
		// Retorna la instancia persistente de la clase pormedio del atributo
		// identidad
		AsInterface id = (AsInterface) sesion.get(AsInterface.class,
				new Short(idDep));
		sesion.close();
		return id;
	}

	public List<AsInterface> daDepartamentos() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Departamentos.findAll");
		List<AsInterface> departamentos = query.list();
		sesion.close();
		return departamentos;
	}

	public AsInterface daDepartamentoByNombre(Integer c_Interface) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("As_interface.findByNombreDep");
		query.setParameter("c_interface", c_Interface);
		AsInterface depto = (AsInterface) query.uniqueResult();
		sesion.close();
		return depto;
	}
}
