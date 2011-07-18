package sumo.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sumo.Constants.Constants;
import sumo.logic.ApplicationContextUtils;
import sumo.logic.HibernateUtil;

public class DaoBase {
	public Session getSession() {
		SessionFactory sessionfactory=HibernateUtil.buildSessionFactory();
		if (!sessionfactory.isClosed()){ return sessionfactory.getCurrentSession();
		}else{
			return sessionfactory.openSession();
		}
	}
}
