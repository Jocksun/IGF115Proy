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
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsClaseDao {
	
	
	@Autowired
	private HibernateUtils hibernateUtil ;
	@Autowired
	
	public AsClaseDao(HibernateUtils hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}


	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession() ;
		tx = sesion.beginTransaction() ;
		}
	
	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa AsClaseDao", he);
	} 
	
	

	public void guardar(AsClase asClase) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asClase);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(AsClase asClase) {
		try {
			iniciaOperacion();
			sesion.delete(asClase);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public AsClase daDepartamentoById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 AsClase id = (AsClase) sesion.get(AsClase.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	
	public List<AsClase> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsClase u");
		List<AsClase> asClase = query.list();
		sesion.close();
		return asClase;
	}

	public AsClase findByIdAsClase(Integer nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from AsClase u where u.cClase =:idTipo");
		query.setParameter("idTipo", nombre);
		AsClase asClase = (AsClase) query.uniqueResult();
		sesion.close();
		return asClase;
	}}
