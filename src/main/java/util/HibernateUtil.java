package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static SessionFactory buildSessionFactory() {
        Configuration cfg = new Configuration().addResource(HIBERNATE_CFG).configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
