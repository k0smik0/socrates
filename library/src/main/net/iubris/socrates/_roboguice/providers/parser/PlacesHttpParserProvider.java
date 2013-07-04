/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesHttpParserProvider.java is part of 'Socrates'.
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
package net.iubris.socrates._roboguice.providers.parser;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import net.iubris.socrates.config.ConfigMandatory;

import com.google.api.client.http.HttpParser;


public class PlacesHttpParserProvider implements Provider<HttpParser> {

	private ConfigMandatory config;
//	private final String output;

	@Inject
	public PlacesHttpParserProvider(ConfigMandatory configMandatory) {
		this.config = configMandatory;
	}
	/*
	@Inject
	public PlacesHttpParserProvider(@RequestUrlOutput  HttpParserOutputType output) {
		this.output = output;
	}*/
	

	@Override @Singleton
	public HttpParser get() {		
		return config.getOutput().getHttpParser();
	}
}
