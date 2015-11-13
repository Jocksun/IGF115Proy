package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsParametroPK;
//import sv.edu.ues.igf115.model.AsMetodoPK;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsParametroPKDao {
	private HibernateUtils hibernateUtil;
	
	@Autowired
	public AsParametroPKDao(HibernateUtils hibernateUtil) {
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
		throw new HibernateException("Ocurri� un error en la capa asParametroPKDao", he);
	}
	
	
	public void guardar(AsParametroPK asParametroPK) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asParametroPK);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(AsParametroPK asParametroPK) {
		try {
			iniciaOperacion();
			sesion.delete(asParametroPK);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public AsParametroPK daParametroPKById(short id){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 AsParametroPK asParametroPK = (AsParametroPK) sesion.get(AsParametroPK.class, new Short(id)) ;
		 sesion.close() ;
		 return asParametroPK ;
		}
	
	public List<AsParametroPK> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsParametroPK u");
		List<AsParametroPK> asParametroPK = query.list();
		sesion.close();
		return asParametroPK;
	}

	public AsParametroPK findByIdAsParametroPK(Integer nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from AsParametroPK u where u.c_parametro =:idTipo");
		query.setParameter("idTipo", nombre);
		AsParametroPK asParametroPK = (AsParametroPK) query.uniqueResult();
		sesion.close();
		return asParametroPK;
	}

	public AsParametroPK daAsParametroPK(AsParametroPK asParametroPK) {
		guardar(asParametroPK);

		return findByIdAsParametroPK(asParametroPK.getCClase());

	}

}
