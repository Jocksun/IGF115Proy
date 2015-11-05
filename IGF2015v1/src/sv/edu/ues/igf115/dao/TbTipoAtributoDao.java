package sv.edu.ues.igf115.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.TbTipoAtributo;
import sv.edu.ues.igf115.utilidades.HibernateUtils;


public class TbTipoAtributoDao {
	
	private HibernateUtils hibernateUtil = new HibernateUtils() ;
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
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	} 
	
	public void guardar(TbTipoAtributo tbTipoAtributo) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tbTipoAtributo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}


		
	public void eliminar(TbTipoAtributo tbTipoAtributo) {
		try {
			iniciaOperacion();
			sesion.delete(tbTipoAtributo);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	public TbTipoAtributo daDepartamentoById(short idDep){
		 sesion = sessionFactory.openSession() ;
		 // Retorna la instancia persistente de la clase por medio del	atributo identidad
		 TbTipoAtributo id = (TbTipoAtributo) sesion.get(TbTipoAtributo.class, new Short(idDep)) ;
		 sesion.close() ;
		 return id ;
		}
	
	public List<TbTipoAtributo> findByAll() {
		sesion = sessionFactory.openSession();
		//Query query = sesion.getNamedQuery("Departamentos.findAll");
		Query query = sesion.createQuery("Select u From TbTipoAtributo u");
		List<TbTipoAtributo> tbTipoAtributo = query.list();
		sesion.close();
		return tbTipoAtributo;
	}

	public TbTipoAtributo findByIdTbTipoAtributo(String nombre) {
		sesion = sessionFactory.openSession();
//		Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//		query.setParameter("nombreDep", nombre);
		Query query = sesion.createQuery("Select u from TbTipoAtributo u where u.cTipoAtributo =:idTipo");
		query.setParameter("idTipo", nombre);
		TbTipoAtributo tbTipoAtributo = (TbTipoAtributo) query.uniqueResult();
		sesion.close();
		return tbTipoAtributo;
	}
}

