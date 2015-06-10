/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * EventDetailsRequestMandatoryUrlProvider.java is part of 'Socrates'.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates'; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates._di.providers.url.services.events;

import javax.inject.Inject;

import net.iubris.socrates._di.providers.url.services.AbstractPlaceRequestMandatoryUrlProvider;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.engines.events.details.url.annotation.ServiceTypeEvent;
import net.iubris.socrates.model.http.request.url.service.ServiceType;
import net.iubris.socrates.model.http.request.url.service.events.method.EventMethod;

import com.google.api.client.http.GenericUrl;

public class EventDetailsRequestMandatoryUrlProvider extends AbstractPlaceRequestMandatoryUrlProvider {
		
	@Inject
	public EventDetailsRequestMandatoryUrlProvider(@ServiceTypeEvent ServiceType serviceType) {
		super(serviceType);
	}
	
	public EventDetailsRequestMandatoryUrlProvider(ServiceType serviceType,
			GenericUrl genericUrl, ConfigMandatory config) {
		super(serviceType, genericUrl, config);
	}

	@Override
	protected void addMethod() {
		getMandatoryUrl().appendRawPath( "/"+EventMethod.details.name() );		
	}
}
