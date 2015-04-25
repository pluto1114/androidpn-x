package org.androidpn.client.iq;

import org.jivesoftware.smack.packet.IQ;

import android.util.Log;

public class ConfirmIQ extends IQ {
	private String uuid;
	
	@Override
	public String getChildElementXML() {
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("confirm").append(" xmlns=\"").append(
                "androidpn:iq:confirm").append("\">");
        if (uuid != null) {
            buf.append("<uuid>").append(uuid).append("</uuid>");
        }
        buf.append("</").append("confirm").append("> ");
        Log.i("confirm", buf.toString());
        return buf.toString();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
}
