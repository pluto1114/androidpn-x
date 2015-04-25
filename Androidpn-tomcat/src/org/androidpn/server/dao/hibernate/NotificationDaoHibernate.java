package org.androidpn.server.dao.hibernate;

import java.util.List;

import org.androidpn.server.dao.NotificationDao;
import org.androidpn.server.model.Notification;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NotificationDaoHibernate extends HibernateDaoSupport implements NotificationDao{

	public void save(Notification notification) {
		getHibernateTemplate().saveOrUpdate(notification);
	}

	public Notification getNotification(String uuid) {
		// TODO Auto-generated method stub
		List<Notification> notifications=getHibernateTemplate().find("from Notification where uuid=?", uuid);
		if (notifications!=null && notifications.size()>0) {
			return notifications.get(0);
		}
		return null;
	}

	public List<Notification> find(String username) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Notification where username=?", username);
	}

	public void delete(String uuid) {
		// TODO Auto-generated method stub
		Notification notification=getNotification(uuid);
		if (notification!=null) {
			getHibernateTemplate().delete(notification);
		}
		
	}

	public void delete(Notification notification) {
		getHibernateTemplate().delete(notification);
	}
	
}
