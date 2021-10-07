package br.com.projeto.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactorySession {
	public static Session getCurrentSessionFromConfig() {
		  Configuration config = new Configuration();
		  config.configure();
		  SessionFactory sessionFactory = config.buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  return session;
		}
}
