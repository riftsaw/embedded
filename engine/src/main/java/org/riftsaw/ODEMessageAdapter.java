/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.riftsaw;

import org.apache.ode.bpel.iapi.Message;

public class ODEMessageAdapter implements MessageAdapter {

	private Message m_message=null;
	
	public ODEMessageAdapter(Message mesg) {
		m_message = mesg;
	}
	
	public org.w3c.dom.Element getMessage() {
		return(m_message.getMessage());
	}

	public void setPart(String name, org.w3c.dom.Element elem) {
		if (name == null) {
			m_message.setMessage(elem);
		} else {
			m_message.setPart(name, elem);
		}
	}
	
	public org.w3c.dom.Element getPart(String name) {
		return(m_message.getPart(name));
	}

	public void setHeaderPart(String name, org.w3c.dom.Element elem) {
		m_message.setHeaderPart(name, elem);
	}
	
	public java.util.Map<String, org.w3c.dom.Node> getHeaderParts() {
		return(m_message.getHeaderParts());
	}
}
