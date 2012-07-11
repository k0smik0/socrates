/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceDetailsRequestUrlBuilder.java is part of 'Socrates'
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
package net.iubris.socrates.engines.details.url;

import net.iubris.socrates.engines.base.url.builders.AbstractDetailsRequestUrlBuilder;
import net.iubris.socrates.engines.details.url.annotation.DetailsRequestMandatoryUrl;
import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class DetailsRequestUrlBuilder extends AbstractDetailsRequestUrlBuilder<DetailsRequestUrlBuilder> {
	
	//@Inject
	/*
	public PlaceDetailsRequestUrlBuilder(PlaceDetailsRequestMandatoryUrlBuilder requestUrlMandatoryBuilder,
			PlaceConfig placesConfig) {
		super(requestUrlMandatoryBuilder);
	}*/
	
	
	//injection way
	@Inject
	public DetailsRequestUrlBuilder(@DetailsRequestMandatoryUrl GenericUrl requestUrl) {
		super(requestUrl);
	}
	
	/*
	public DetailsRequestUrlBuilder buildUrl(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(DetailsConfigParameter.reference, reference);
		return this;
	}*/

	/*
	@Override
	public DetailsRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}*/

}