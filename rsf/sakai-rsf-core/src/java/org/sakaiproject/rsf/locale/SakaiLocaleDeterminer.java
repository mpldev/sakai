/**
 * Copyright © 2005, CARET, University of Cambridge
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
/*
 * Created on May 29, 2006
 */
package org.sakaiproject.rsf.locale;

import java.util.Locale;

import org.sakaiproject.tool.api.SessionManager;
import org.springframework.beans.factory.FactoryBean;
import org.sakaiproject.util.ResourceLoader;

/**
 * Determins the correct locale for the current request by calling the Sakai
 * ResourceLoader
 * 
 * @author Antranig Basman (amb26@ponder.org.uk)
 * @author Matthew Jones (matthew@longsight.com)
 * 
 */
// See http://dev.ulan.jp/sakai/wiki/ResourceLoader
public class SakaiLocaleDeterminer implements FactoryBean {

	private SessionManager sessionmanager;

	public void setSessionManager(SessionManager sessionmanager) {
		this.sessionmanager = sessionmanager;
	}

	public Object getObject() {
		String userid = sessionmanager.getCurrentSessionUserId();
		Locale loc = Locale.getDefault();
		if (userid != null) {
			ResourceLoader rl = new ResourceLoader();
			loc = rl.getLocale();
		}
		return loc;
	}

	public Class getObjectType() {
		return Locale.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
