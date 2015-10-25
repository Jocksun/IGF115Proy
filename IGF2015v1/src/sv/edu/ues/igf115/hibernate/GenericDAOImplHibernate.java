package sv.edu.ues.igf115.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sv.edu.ues.igf115.utilidades.HibernateUtil;





public class GenericDAOImplHibernate<T, ID extends Serializable> implements
		GenericDao<T, ID> {
	
	private HibernateUtil hibernateUtil = new HibernateUtil() ;	
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory() ;
	private Session session; 
	
	protected final Log log = LogFactory.getLog(getClass());

	public GenericDAOImplHibernate() {
		sessionFactory = HibernateUtil.getSessionFactory();

	}

	@Override
	public T create()  {
		try {
			return getEntityClass().newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
	}

	@Override
	public T get(ID id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(), id);
			session.getTransaction().commit();

			return entity;
		
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
		return null;
		
	}

	@Override
	public void delete(ID id)  {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(), id);
			
			if (entity == null) {
				
				
				System.out.println("Los datos a borrar ya no existen");
			}
			session.delete(entity);
			session.getTransaction().commit();
		
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
				
	}

	@Override
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT e FROM "
					+ getEntityClass().getName() + " e");
			List<T> entities = query.list();

			return entities;
		
		} catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
		
		} catch (RuntimeException ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
			throw ex;
		} catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} catch (Exception exc) {
				log.error("Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}
		return null;
	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
}