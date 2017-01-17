package org.newsletters.daos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleDAO<T> implements IBaseDAO<T>{
    
    private final SessionFactory sessionFactory = buildSessionFactory();
    private final String CONFIGURATION_FILE_PATH = "hibernate/hibernate.cfg.xml";
    private final Class<T> classOfT;
    
    public OracleDAO(Class<T> classOfT){
        this.classOfT = classOfT;
    }

    private SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure(CONFIGURATION_FILE_PATH).buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    @Override
    public void insert(T entity){
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        sessionFactory.close();
    }
    
    @Override
    public List<T> get(){
        Session session =  sessionFactory.openSession();
        List<T> resultList = session.createCriteria(classOfT).list();
        sessionFactory.close();
        return resultList;
    }
}
