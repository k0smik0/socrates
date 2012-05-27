/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractRequestUrlMandatoryBuilder.java is part of 'Socrates'.
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
package net.iubris.socrates.url.builders;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.AbstractPlaceUrl;
import net.iubris.socrates.url.PlaceUrlMandatoryParameter;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractRequestUrlMandatoryBuilder {

	private final GenericUrl genericUrl;
	
	public AbstractRequestUrlMandatoryBuilder(AbstractPlaceUrl placeUrl, PlaceConfig placeConfig) {
		genericUrl = placeUrl.getUrl();//.clone();
		genericUrl.appendRawPath("/"+placeConfig.getOutput().name());

		setValue(PlaceUrlMandatoryParameter.key, placeConfig.getKey());
		setValue(PlaceUrlMandatoryParameter.sensor, placeConfig.isUseSensor());	
	}
	
	private void setValue(PlaceUrlMandatoryParameter placeUrlParameter, Object value) {
		genericUrl.put(placeUrlParameter.name(), value);
	}
	
	public GenericUrl getUrl() {
		return genericUrl;
	}
	
}
