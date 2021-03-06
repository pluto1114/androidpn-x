package org.androidpn.server.xmpp.handler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.androidpn.server.service.NotificationService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.xmpp.UnauthorizedException;
import org.androidpn.server.xmpp.session.ClientSession;
import org.androidpn.server.xmpp.session.Session;
import org.dom4j.Element;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;

public class IQTagsHandler extends IQHandler {
	private static final String NAMESPACE = "androidpn:iq:tags";
	
	
	public IQTagsHandler(){
		
	}
	@Override
	public IQ handleIQ(IQ packet) throws UnauthorizedException {
		IQ reply = null;
		System.out.println("setTags handleIQ");
        ClientSession session = sessionManager.getSession(packet.getFrom());
        if (session == null) {
            log.error("Session not found for key " + packet.getFrom());
            reply = IQ.createResultIQ(packet);
            reply.setChildElement(packet.getChildElement().createCopy());
            reply.setError(PacketError.Condition.internal_server_error);
            return reply;
        }

        if (session.getStatus()==Session.STATUS_AUTHENTICATED) {
			if (IQ.Type.set.equals(packet.getType())) {
				System.out.println("setTags start");
				Element element=packet.getChildElement();
				String username=element.elementText("username");
				String tags=element.elementText("tags");
				String[] tagArr=tags.split(",");
				for (int i = 0; i < tagArr.length; i++) {
					if (!username.isEmpty()&&!tagArr[i].isEmpty()) {
						sessionManager.setTag(tagArr[i], username);
						System.out.println(tagArr[i]+"--setTag success");
					}
				}
				System.out.println("username:"+username);
				System.out.println("tags:"+tags);
				
				
			}
		}
		return null;
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return NAMESPACE;
	}

}
