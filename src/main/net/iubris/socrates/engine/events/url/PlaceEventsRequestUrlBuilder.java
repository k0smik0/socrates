/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceEventsRequestUrlBuilder.java is part of 'Socrates'
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
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.engine.events.url;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.PlaceUrlConfigParameter;
import net.iubris.socrates.url.builders.AbstractPlacesRequestUrlBuilder;

import com.google.inject.Inject;

public class PlaceEventsRequestUrlBuilder extends AbstractPlacesRequestUrlBuilder<PlaceEventsRequestUrlBuilder> {

	@Inject
	public PlaceEventsRequestUrlBuilder(EventsRequestUrlMandatoryBuilder requestUrlMandatory,
			PlaceConfig placesConfig) {
		super(requestUrlMandatory, placesConfig);
	}
	
	public PlaceEventsRequestUrlBuilder buildUrl(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(PlaceUrlConfigParameter.reference, reference);
		return this;
	}

	@Override
	public PlaceEventsRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}
	
}
