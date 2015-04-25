package org.androidpn.server.service;

import java.util.List;

import org.androidpn.server.model.Notification;

public interface NotificationService {
	void save(Notification notification);
	
	Notification getNotification(String uuid);
	
	List<Notification> find(String username);
	
	void delete(String uuid);
	
	void delete(Notification notification);
}
