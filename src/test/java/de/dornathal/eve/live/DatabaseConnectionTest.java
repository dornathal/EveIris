package de.dornathal.eve.live;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DatabaseConnectionTest {

	protected static SessionFactory sessionFactory;
	protected Session session;

	@BeforeMethod
	public void createDatabaseConnection() {
		initSessionFactory();

		session = sessionFactory.openSession();
		System.out.println("Session opened");
	}

	private void initSessionFactory() {
		Configuration configuration = new Configuration().configure();
		if( sessionFactory == null ){
			StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
			registry.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = registry.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		session.close();
	}

}
