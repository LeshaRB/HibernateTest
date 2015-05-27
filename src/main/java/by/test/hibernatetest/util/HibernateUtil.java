package by.test.hibernatetest.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Configuration configuration;

	static {
		try {
			configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = new Configuration().configure()
					.buildSessionFactory(serviceRegistry);
		} catch (HibernateException hEx) {
			System.out.println(hEx.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
