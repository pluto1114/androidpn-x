package org.androidpn.server.service.impl;

import java.util.List;

import org.androidpn.server.dao.NotificationDao;
import org.androidpn.server.model.Notification;
import org.androidpn.server.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {
	private NotificationDao notificationDao;
	
	
	
	public NotificationDao getNotificationDao() {
		return notificationDao;
	}

	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	public void save(Notification notification) {
		// TODO Auto-generated method stub
		notificationDao.save(notification);
	}

	public Notification getNotification(String uuid) {
		// TODO Auto-generated method stub
		return notificationDao.getNotification(uuid);
	}

	public List<Notification> find(String username) {
		// TODO Auto-generated method stub
		return notificationDao.find(username);
	}

	public void delete(String uuid) {
		// TODO Auto-generated method stub
		notificationDao.delete(uuid);
	}

	public void delete(Notification notification) {
		// TODO Auto-generated method stub
		notificationDao.delete(notification);
	}

}
