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

import sv.edu.ues.igf115.model.AsParametro;
import sv.edu.ues.igf115.utilidades.HibernateUtils;
//ASObservacion
@Repository
public class AsParametroDao {

	@Autowired
	private HibernateUtils hibernateUtil ;
	
	@Autowired
	public AsParametroDao(HibernateUtils hibernateUtil) {
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
	
	
	public void guardar(AsParametro asParametro) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(asParametro);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(AsParametro asParametro) {
		try {
			iniciaOperacion();
			sesion.delete(asParametro);
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
	public List<AsParametro> findByAll() {
		sesion = sessionFactory.openSession();
		
		//Criteria criteria = sesion.createCriteria(AsParametro.class);//.addOrder(Property.forName("CParametro").asc());	
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From AsParametro u");
		List<AsParametro> asParametro = query.list();
		sesion.close();
		return asParametro;
	}

	public AsParametro findByIdAsParametro(int id) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		//Query query = sesion.createQuery("Select u from TbTipoAtributo u where u.cTipoAtributo =:idTipo");
		//query.setParameter("idTipo", nombre);
		Criteria criteria = sesion.createCriteria(AsParametro.class).add(Restrictions.eq("asParametroPK.cParametro",id));
		AsParametro asParametro = (AsParametro) criteria.uniqueResult();
		sesion.close();
		return asParametro;
	}
}

