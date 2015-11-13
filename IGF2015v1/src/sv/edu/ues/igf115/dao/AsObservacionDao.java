package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.model.AsObservacion;
import sv.edu.ues.igf115.utilidades.HibernateUtils;
//ASObservacion
@Repository
public class AsObservacionDao {

	@Autowired
	private HibernateUtils hibernateUtil ;
	
	@Autowired
	public AsObservacionDao(HibernateUtils hibernateUtil) {
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
		throw new HibernateException("Ocurri� un error en la capa DAO", he);
	} 
	
	
	public void guardar(AsObservacion asObservacion) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asObservacion);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(AsObservacion asObservacion) {
		try {
			iniciaOperacion();
			sesion.delete(asObservacion);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	/*
	public TbTipoAtributo daDepartamentoById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 TbTipoAtributo id = (TbTipoAtributo) sesion.get(TbTipoAtributo.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	*/
	public List<AsObservacion> findByAll() {
		sesion = sessionFactory.openSession();
		
		Criteria criteria = sesion.createCriteria(AsObservacion.class).addOrder(Property.forName("cObservacion").asc());	
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		//Query query = sesion.createQuery("Select u From AsObservacion u");
		List<AsObservacion> asObservacion = criteria.list();
		sesion.close();
		return asObservacion;
	}

	public AsObservacion findByIdAsObservacion(int id) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		//Query query = sesion.createQuery("Select u from TbTipoAtributo u where u.cTipoAtributo =:idTipo");
		//query.setParameter("idTipo", nombre);
		Criteria criteria = sesion.createCriteria(AsObservacion.class).add(Restrictions.eq("cObservacion",id));
		AsObservacion asObservacion = (AsObservacion) criteria.uniqueResult();
		sesion.close();
		return asObservacion;
	}
	public AsObservacion findByDObservacionAsObservacion(String dObservacion) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		//Query query = sesion.createQuery("Select u from TbTipoAtributo u where u.cTipoAtributo =:idTipo");
		//query.setParameter("idTipo", nombre);
		Criteria criteria = sesion.createCriteria(AsObservacion.class).add(Restrictions.eq("dObservacion",dObservacion));
		AsObservacion asObservacion = (AsObservacion) criteria.uniqueResult();
		sesion.close();
		return asObservacion;
	}
}

