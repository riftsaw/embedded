/*
 * Copyright 2010 Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.riftsaw;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;

public interface InvocationAdapter<T> {

	String getOperationName();
	
	QName getServiceName();
	
	String getPortName();
	
	/**
	 * Callback from the Service towards the adapter when
	 * turning an external message representation into a Service request.
	 * 
	 * @param mex
	 * @param odeRequest
	 */
	void initRequest(javax.wsdl.Operation op, MessageAdapter request);

  /**
   * Callback from the Engine towards the adapter when
   * turning an ODE response {@link org.apache.ode.bpel.iapi.Message} into an external format &lt;T>
   */
  void createResponse(javax.wsdl.Operation wsdl, MessageAdapter resp);

  /**
   * @param op
   * @param faultName
   * @param fault
   */
  void createFault(javax.wsdl.Operation op, QName faultName, MessageAdapter fault);
  
  /**
   * @param message
   */
  //public void setMessage(T message);
  
  /**
   * Access the invocation result (response)
   * @return T
   */
  T getInvocationResult();

}
