package org.androidpn.server.dao;

import java.util.List;

import org.androidpn.server.model.Notification;

public interface NotificationDao {
	void save(Notification notification);
	
	Notification getNotification(String uuid);
	
	List<Notification> find(String username);
	
	void delete(String uuid);
	
	void delete(Notification notification);
}
