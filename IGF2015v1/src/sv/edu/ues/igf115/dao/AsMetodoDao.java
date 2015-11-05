package sv.edu.ues.igf115.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.model.AsMetodo;
import sv.edu.ues.igf115.utilidades.HibernateUtils;

public class AsMetodoDao {
	
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
		throw new HibernateException("Ocurri� un error en la capa AsMetodoDao", he);
	}
	

		public void guardar(AsMetodo asMetodo) {
			try {
				iniciaOperacion();
				sesion.saveOrUpdate(asMetodo);
				tx.commit();
				sesion.flush();
			} catch (HibernateException he) {
				manejaExcepcion(he);
				throw he;
			} finally {
				sesion.close();
			}
		}


			
		public void eliminar(AsMetodo asMetodo) {
			try {
				iniciaOperacion();
				sesion.delete(asMetodo);
				tx.commit();
				sesion.flush();
			} catch (HibernateException he) {
				manejaExcepcion(he);
				throw he;
			} finally {
				sesion.close();
			}
		}
		
		public AsMetodo daDepartamentoById(short idDep){
			 sesion = sessionFactory.openSession() ;
			 // Retorna la instancia persistente de la clase por medio del	atributo identidad
			 AsMetodo id = (AsMetodo) sesion.get(AsMetodo.class, new Short(idDep)) ;
			 sesion.close() ;
			 return id ;
			}
		
		public List<AsMetodo> findByAll() {
			sesion = sessionFactory.openSession();
			//Query query = sesion.getNamedQuery("Departamentos.findAll");
			Query query = sesion.createQuery("Select u From AsMetodo u");
			List<AsMetodo> asMetodo = query.list();
			sesion.close();
			return asMetodo;
		}

		public AsMetodo findByIdAsMetodo(String nombre) {
			sesion = sessionFactory.openSession();
//			Query query = sesion.getNamedQuery("Departamentos.findByNombreDep");
//			query.setParameter("nombreDep", nombre);
			Query query = sesion.createQuery("Select u from AsMetodo u where u.cTipoAtributo =:idTipo");
			query.setParameter("idTipo", nombre);
			AsMetodo asMetodo = (AsMetodo) query.uniqueResult();
			sesion.close();
			return asMetodo;
		}
		
}
