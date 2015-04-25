package org.androidpn.server.xmpp.handler;

import org.androidpn.server.service.NotificationService;
import org.androidpn.server.service.ServiceLocator;
import org.androidpn.server.xmpp.UnauthorizedException;
import org.androidpn.server.xmpp.session.ClientSession;
import org.androidpn.server.xmpp.session.Session;
import org.dom4j.Element;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;

public class IQAliasHandler extends IQHandler {
	private static final String NAMESPACE = "androidpn:iq:alias";
	
	
	public IQAliasHandler(){
		
	}
	@Override
	public IQ handleIQ(IQ packet) throws UnauthorizedException {
		IQ reply = null;
		System.out.println("setAlias handleIQ");
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
				System.out.println("setAlias start");
				Element element=packet.getChildElement();
				String username=element.elementText("username");
				String alias=element.elementText("alias");
				System.out.println("username:"+username);
				System.out.println("alias:"+alias);
				if (!username.isEmpty()&&!alias.isEmpty()) {
					sessionManager.setAlias(alias, username);
					System.out.println("setAlias success");
				}
				
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
