package sv.edu.ues.igf115.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsAtributo;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

@Repository
public class AsAtributoDao {
	private HibernateUtils hibernateUtil;
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	@Autowired
	public AsAtributoDao(HibernateUtils hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession() ;
		tx = sesion.beginTransaction() ;
		}
	
	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la AsAtributoDao ", he);
	} 
	
	public void guardar(AsAtributo asAtributo) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asAtributo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public void borrar(AsAtributo asAtributo) {
		try {
			iniciaOperacion();
			sesion.delete(asAtributo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


	public AsAtributo daAsAtributoById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 AsAtributo id = (AsAtributo) sesion.get(AsAtributo.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	
	public List<AsAtributo> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsAtributo u");
		List<AsAtributo> asAtributo = query.list();
		sesion.close();
		return asAtributo;
	}

	public AsAtributo findByIdAsAtributo(Integer nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from AsAtributo u where u.cClase =:idTipo");
		query.setParameter("idTipo", nombre);
		AsAtributo asAtributo = (AsAtributo) query.uniqueResult();
		sesion.close();
		return asAtributo;
	}

}
