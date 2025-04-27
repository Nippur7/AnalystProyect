package CRUD;


import CRUD.NewHibernateUtil;
import com.aics.User;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tonym
 */
public class Conectar 
{
    
    SessionFactory factory;
    private Session session;
    Transaction trx;
    	public void startOp() 
        {
            factory = NewHibernateUtil.getSessionFactory();
            session = factory.openSession();
            trx = session.getTransaction();
            trx.begin();              
	}
        
        public void stopOp()
        {
            session.getTransaction().commit();
            session.close();
        }
    // Métodos para USER : --------------------------------------------------
        
        public User logIn(String user, String pass)
        {
        startOp();
        SQLQuery query =  session.createSQLQuery("SELECT * FROM user WHERE username = :user and password = :pass");
        query.setParameter("user", user);
        query.setParameter("pass",pass);
        try
            {
            User usuario = (User) query.addEntity(User.class).uniqueResult();
            System.out.println(usuario.getIduser());            
            stopOp();
            return usuario;
            }
                catch (NullPointerException e)
                {
                System.out.println("No user found");
                stopOp();
                return null;
                }           
        }
}
       

