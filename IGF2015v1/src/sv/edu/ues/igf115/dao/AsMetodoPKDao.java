package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsMetodoPK;
import sv.edu.ues.igf115.model.AsMetodoPK;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsMetodoPKDao {
	private HibernateUtils hibernateUtil;
	
	@Autowired
	public AsMetodoPKDao(HibernateUtils hibernateUtil) {
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
		throw new HibernateException("Ocurrió un error en la capa asMetodoPKDao", he);
	}
	
	
	public void guardar(AsMetodoPK asMetodoPK) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asMetodoPK);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(AsMetodoPK asMetodoPK) {
		try {
			iniciaOperacion();
			sesion.delete(asMetodoPK);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public AsMetodoPK daDepartamentoById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 AsMetodoPK id = (AsMetodoPK) sesion.get(AsMetodoPK.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	
	public List<AsMetodoPK> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsMetodoPK u");
		List<AsMetodoPK> asMetodoPK = query.list();
		sesion.close();
		return asMetodoPK;
	}

	public AsMetodoPK findByIdAsMetodoPK(Integer nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from AsMetodoPK u where u.c_clase =:idTipo");
		query.setParameter("idTipo", nombre);
		AsMetodoPK asMetodoPK = (AsMetodoPK) query.uniqueResult();
		sesion.close();
		return asMetodoPK;
	}

	public AsMetodoPK daAsMetodoPK(AsMetodoPK asMetodoPK) {
		guardar(asMetodoPK);

		return findByIdAsMetodoPK(asMetodoPK.getCClase());

	}

}
