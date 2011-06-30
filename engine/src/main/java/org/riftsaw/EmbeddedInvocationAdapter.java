/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.riftsaw;

import org.w3c.dom.Element;

import javax.xml.namespace.QName;

/**
 * @author Heiko Braun <hbraun@redhat.com>
 */
public class EmbeddedInvocationAdapter implements InvocationAdapter<Element>
{
  private String operationName;
  private QName serviceName;
  private String portName;
  private QName faultName;
  private Element requestXML;
  private java.util.Map<String,Element> requestHeaderParts;
  private Element responseXML;

  public EmbeddedInvocationAdapter(String operationName, QName serviceName, String portName)
  {
    this.operationName = operationName;
    this.serviceName = serviceName;
    this.portName = portName;
  }

  public String getOperationName()
  {
    return operationName;
  }
  
  public QName getFaultName()
  {
	  return faultName;
  }
  
  public void setFaultName(QName fname) {
	  this.faultName = fname;
  }

  public QName getServiceName()
  {
    return serviceName;
  }
  
  public String getPortName() {
	  return(portName);
  }

  public void setRequestXML(Element requestXML)
  {
    this.requestXML = requestXML;
  }

  public void setRequestHeaderParts(java.util.Map<String,Element> headerParts) {
	  this.requestHeaderParts = headerParts;
  }
  
  public void initRequest(javax.wsdl.Operation op, MessageAdapter request)
  {
    if(null==this.requestXML)
      throw new IllegalArgumentException("request XML not set");
    request.setPart(null, this.requestXML);
    
    if (requestHeaderParts != null) {
	    for (String part : requestHeaderParts.keySet()) {
	    	Element elem=requestHeaderParts.get(part);
	    	
	    	request.setHeaderPart(part, elem);
	    }
    }
  }

  public void createResponse(javax.wsdl.Operation op, MessageAdapter resp)
  {
    this.responseXML = resp.getMessage();
  }

  public void createFault(javax.wsdl.Operation op, QName faultName, MessageAdapter fault)
  {
    this.responseXML = fault.getMessage();
    this.faultName = faultName;
  }

  public Element getInvocationResult()
  {   
    return this.responseXML;
  }

  // test methods
  public Element getRequestXML()
  {
    return requestXML;
  }

  public void setResponseXML(Element responseXML)
  {
    this.responseXML = responseXML;
  }
}

