package sumo.daos;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.toedter.calendar.JCalendar;

import sumo.Constants.Constants;
import sumo.logic.HibernateUtil;
import sumo.model.*;

public class MitarbeiterDao extends DaoBase {
	SessionFactory sf=HibernateUtil.getSessionFactory();
//	public MitarbeiterDao() {
//		super();
//		getSession().beginTransaction();
//	}
	
	public Session getSession(){
			Session s;
			if ((s=sf.getCurrentSession())==null){
				s=sf.openSession();
			}else{
				s=sf.getCurrentSession();
			}
			return s;
	}
	public List<Mitarbeiter> getMitarbeiter() {
		Constants.session.beginTransaction();
		List<Mitarbeiter> lst=(List<Mitarbeiter>)Constants.session.createQuery("from Mitarbeiter").list();
		Constants.session.getTransaction().commit();
		return lst;
	}
	
	public Mitarbeiter getMitarbeiterByUsername(String username){
		Constants.session.beginTransaction();
		Mitarbeiter mb=(Mitarbeiter)Constants.session.createQuery("from Mitarbeiter where username LIKE '"+username+"'").uniqueResult();
		Constants.session.getTransaction().commit();
		return mb;
		
	}
	
	public Mitarbeiter getMitarbeiterByName(String name){
		
		Constants.session.beginTransaction();
		Mitarbeiter mb=(Mitarbeiter) Constants.session.createQuery("from Mitarbeiter where name LIKE :name ").setParameter("name", name).uniqueResult();
		Constants.session.getTransaction().commit();
		return mb;
	}

	public List<Mitarbeiter> getMitarbeiterBySearch(String criteria){
		Constants.session.beginTransaction();
		List<Mitarbeiter> ret=(List<Mitarbeiter>)Constants.session.createQuery("from Mitarbeiter where name LIKE :name").setParameter("name", "%"+criteria+"%").list();
		Constants.session.getTransaction().commit();
		return ret;
	}
	public void saveOrUpdate(Mitarbeiter ma) {
		Constants.session.beginTransaction();
		Constants.session.saveOrUpdate(ma);
		Constants.session.getTransaction().commit();
	}

	public Mitarbeiter getMitarbeiterById(Long id) {
		Constants.session.beginTransaction();
		Mitarbeiter mb= (Mitarbeiter) Constants.session.load(Mitarbeiter.class, id);

		return mb;
	}
}
