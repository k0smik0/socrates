/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceDetailsRequestUrlBuilder.java is part of socrates.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.detailer;

import com.google.inject.Inject;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.detailer.url.DetailsRequestUrlMandatoryBuilder;
import net.iubris.socrates.url.PlaceUrlConfigParameter;
import net.iubris.socrates.url.builders.AbstractPlacesRequestUrlBuilder;

public class PlaceDetailsRequestUrlBuilder extends AbstractPlacesRequestUrlBuilder<PlaceDetailsRequestUrlBuilder> {
	
	@Inject
	public PlaceDetailsRequestUrlBuilder(DetailsRequestUrlMandatoryBuilder requestUrlMandatory,
			PlaceConfig placesConfig) {
		super(requestUrlMandatory, placesConfig);
	}
	
	public PlaceDetailsRequestUrlBuilder buildUrl(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(PlaceUrlConfigParameter.reference, reference);
		return this;
	}

	@Override
	public PlaceDetailsRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}

}
