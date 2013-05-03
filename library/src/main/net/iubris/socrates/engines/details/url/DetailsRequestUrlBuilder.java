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

import javax.inject.Inject;

import net.iubris.socrates.engines.base.url.builders.AbstractDetailsRequestUrlBuilder;
import net.iubris.socrates.engines.details.url.annotation.DetailsRequestMandatoryUrl;
import net.iubris.socrates.model.http.request.url.language.Language;
import net.iubris.socrates.model.http.request.url.parameters.optional.details.DetailsOptionalParameters;

import com.google.api.client.http.GenericUrl;

public class DetailsRequestUrlBuilder extends AbstractDetailsRequestUrlBuilder<DetailsRequestUrlBuilder> {
		
	@Inject
	public DetailsRequestUrlBuilder(@DetailsRequestMandatoryUrl GenericUrl requestUrl) {
		super(requestUrl);
	}
	
	public DetailsRequestUrlBuilder setLanguage(Language language) {
		setParameterValue(DetailsOptionalParameters.language, language.getLanguageCode());
		return this;
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
