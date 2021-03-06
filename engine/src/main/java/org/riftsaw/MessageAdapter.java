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

public interface MessageAdapter {

	public org.w3c.dom.Element getMessage();
	
	public void setPart(String name, org.w3c.dom.Element elem);
	
	public org.w3c.dom.Element getPart(String name);
	
	public void setHeaderPart(String name, org.w3c.dom.Element elem);
	
	public java.util.Map<String, org.w3c.dom.Node> getHeaderParts();
	
}
