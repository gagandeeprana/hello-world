/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu;

 
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Durga
 */
public class HibernateUtil {
    
private static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;
private static final ThreadLocal<Session> threadLocal;

static {
    try {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        threadLocal = new ThreadLocal<Session>();

    } catch(Throwable t){
        t.printStackTrace();
        throw new ExceptionInInitializerError(t);
    }
}
public static Session getSession() {
    System.out.println("Session Created.");
    Session session = threadLocal.get();
     
    if(session == null){
        session = sessionFactory.openSession();
        threadLocal.set(session);
    }
    return session;
}

public static void closeSession() {
    System.out.println("Session Closed.");
    Session session = threadLocal.get();
    if(session != null){
        session.close();
        threadLocal.set(null);
    }
}

public static void closeSessionFactory() {
    System.out.println("SessionFactory Closed.");
    sessionFactory.close();
    StandardServiceRegistryBuilder.destroy(serviceRegistry);
  }
}
       

 
