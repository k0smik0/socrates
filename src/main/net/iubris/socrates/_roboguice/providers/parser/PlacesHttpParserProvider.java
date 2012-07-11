/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesHttpParserProvider.java is part of 'Socrates'
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
package net.iubris.socrates._roboguice.providers.parser;

import net.iubris.socrates.config.PlaceConfig;

import com.google.api.client.http.HttpParser;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class PlacesHttpParserProvider implements Provider<HttpParser> {

	private PlaceConfig placeConfig;

	@Inject
	public PlacesHttpParserProvider(PlaceConfig placeConfig) {
		this.placeConfig = placeConfig;
	}

	@Override @Singleton
	public HttpParser get() {		
		return placeConfig.getOutput().getHttpParser();
	}
}
