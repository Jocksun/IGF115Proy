package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsClaseInterface;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsClaseInterfaceDao {

	private HibernateUtils hibernateUtil;
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	@Autowired
	public AsClaseInterfaceDao(HibernateUtils hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	
	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession() ;
		tx = sesion.beginTransaction() ;
		}
	
	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la AsClaseInterfaceDao ", he);
	} 
	
	public void guardar(AsClaseInterface asClaseInterface) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asClaseInterface);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void borrar(AsClaseInterface asClaseInterface) {
		try {
			iniciaOperacion();
			sesion.delete(asClaseInterface);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


	public AsClaseInterface daAsClaseInterfaceById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 AsClaseInterface id = (AsClaseInterface) sesion.get(AsClaseInterface.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	
	public List<AsClaseInterface> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsClaseInterface u");
		List<AsClaseInterface> asClaseInterface = query.list();
		sesion.close();
		return asClaseInterface;
	}

	public AsClaseInterface findByIdAsClaseInterface(Integer nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from AsClaseInterface u where u.cClase =:idTipo");
		query.setParameter("idTipo", nombre);
		AsClaseInterface asClaseInterface = (AsClaseInterface) query.uniqueResult();
		sesion.close();
		return asClaseInterface;
	}
	
	
}
