package org.androidpn.client.iq;

import java.util.Iterator;
import java.util.Set;

import org.jivesoftware.smack.packet.IQ;

import android.util.Log;

public class TagsIQ extends IQ {
	private String username;
	
	private Set<String> tags;
	
	@Override
	public String getChildElementXML() {
		StringBuilder buf = new StringBuilder();
        buf.append("<").append("tags").append(" xmlns=\"").append(
                "androidpn:iq:tags").append("\">");
        if (username != null) {
        	buf.append("<username>").append(username).append("</username>");
        }
        if (tags != null) {
        	String tagString="";
        	Iterator<String> iterator=tags.iterator();
        	while (iterator.hasNext()) {
			  tagString += iterator.next();
			  tagString +=",";
			}
        	tagString=tagString.substring(0, tagString.length()-1);
            buf.append("<tags>").append(tagString).append("</tags>");
        }
        buf.append("</").append("tags").append("> ");
        Log.i("tags", buf.toString());
        return buf.toString();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	
	

	

	
}
