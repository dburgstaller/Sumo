/**
 * danielburgstaller
 */
package sumo.daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sumo.Constants.Constants;
import sumo.logic.HibernateUtil;
import sumo.model.Mitarbeiter;
import sumo.model.Mitarbeiterstunde;

/*
 * Filename:MitarbeiterstundenDao.java
 * Ersteller: danielburgstaller
 */
/**
 * @author danielburgstaller
 *
 */
public class MitarbeiterstundenDao extends DaoBase {
	SessionFactory sf=HibernateUtil.getSessionFactory();
		public List<Mitarbeiterstunde> getMitarbeiterStunden(){
			Constants.session.beginTransaction();
			List<Mitarbeiterstunde> lst=(List<Mitarbeiterstunde>)Constants.session.createQuery("from Mitarbeiterstunde").list();
			Constants.session.getTransaction().commit();
			return lst;
		}
		
		public Session getSession(){
			Session s;
			if ((s=sf.getCurrentSession())==null){
				s=sf.openSession();
			}
			return s;
	}
		public void saveOrUpdate(Mitarbeiterstunde ms){
			
				
				Constants.session.beginTransaction();
				Constants.session.saveOrUpdate(ms);
				Constants.session.getTransaction().commit();
		}
		
		public Mitarbeiterstunde getMitarbeiterstundeByMitarbeiterAndDay(Mitarbeiter mb, Timestamp ts){
			return null;
		}
		
		@SuppressWarnings("unchecked")
		public List<Mitarbeiterstunde> getMitarbeiterstundenByMitarbeiter(Mitarbeiter mb){
			Constants.session.beginTransaction();
			System.out.println(mb.getId());
			String longstring=mb.getId().toString();
			long longlong=Long.valueOf(longstring);
			
			
			List<Mitarbeiterstunde> lst=(List<Mitarbeiterstunde>)Constants.session.createQuery("from Mitarbeiterstunde where MITARBEITER='"+longstring+"'").list();
			
			return lst;
		}
}
