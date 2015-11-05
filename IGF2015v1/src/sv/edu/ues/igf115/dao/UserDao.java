//package sv.edu.ues.igf115.dao;
//
//
//import java.util.*;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import sv.edu.ues.igf115.model.Users;
//import sv.edu.ues.igf115.utilidades.HibernateUtils;
//
// 
//
//public class UserDao {
//
//	private HibernateUtils hu = new HibernateUtils();
//	private SessionFactory sf;
//	private Session s;
//	private Transaction tx;
//	
// 
////    public void checkUser(Users user) {
////        try {
////            PreparedStatement ps = connection.prepareStatement("select uname from users where uname = ?");
////            ps.setString(1, user.getUname());
////            ResultSet rs = ps.executeQuery();
////            if (rs.next()) // found
////            {
////                updateUser(user);
////            } else {
////                addUser(user);
////            }
////        } catch (Exception ex) {
////            System.out.println("Error in check() -->" + ex.getMessage());
////        } 
////        
////    }
////    
//    
//    public boolean addUser(Users user) {
//        try {
//			iniciarTransaccion();
//			s.saveOrUpdate(user);
//			finTransaccion();
//			return true;
//		} catch (Exception e) {
//			System.err.println(this + "Ocurrio un error al guardar TbTipoAtributo " + e.getMessage());
//			return false;
//		}    
//        
//        
//    }
// 
//    public boolean deleteUser(String userId) {
//    	try {
//			iniciarTransaccion();
//			s.delete(getUserById(userId));
//			finTransaccion();
//			return true;
//		} catch (Exception e) {
//			System.err.println(this + "Ocurrio un error al borrar deleteUser " + e.getMessage());
//			return false;
//		}
//    }
// 
//    public boolean updateUser(Users user) {
//    	try {
//			iniciarTransaccion();
//			s.saveOrUpdate(user);
//			finTransaccion();
//			return true;
//		} catch (Exception e) {
//			System.err.println(this + "Ocurrio un error al Actualizar updateUser" + e.getMessage());
//			return false;
//		}
//    }
// 
//    /**
//     * 
//     * @return
//     */
//    public List<Users> getAllUsers() {
//		
//    	try {
//    		iniciarSesion();
//    		//Query query = s.getNamedQuery("Users.findAll");
//    		Query query = s.createQuery("Select u from Users u");
//    		List<Users> lst =query.list();
//    		finSesion();
//    		return lst;
//		} catch (Exception e) {
//			System.out.println("Error  "+e);
//		}
//		return null;
//    	
//	}
//    
//     
//    public Users getUserById(String idTipo) {
//		Query query = s.getNamedQuery("Users.findById");
//		query.setParameter("uname", idTipo);
//		Users users = (Users) query.uniqueResult();
//		return users;
//	}
//    
//    
//   
//	
//}
