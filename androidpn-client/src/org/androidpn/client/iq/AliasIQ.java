package org.androidpn.client.iq;

import org.jivesoftware.smack.packet.IQ;

import android.util.Log;

public class AliasIQ extends IQ {
	private String username;
	
	private String alias;
	
	@Override
	public String getChildElementXML() {
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("alias").append(" xmlns=\"").append(
                "androidpn:iq:alias").append("\">");
        if (username != null) {
        	buf.append("<username>").append(username).append("</username>");
        }
        if (alias != null) {
            buf.append("<alias>").append(alias).append("</alias>");
        }
        buf.append("</").append("alias").append("> ");
        Log.i("alias", buf.toString());
        return buf.toString();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	

	
}
