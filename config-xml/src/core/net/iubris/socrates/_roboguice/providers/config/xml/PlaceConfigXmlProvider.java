/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceConfigXmlProvider.java is part of socrates_config-xml.
 * 
 * socrates_config-xml is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates_config-xml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates_config-xml ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates._roboguice.providers.config.xml;

import net.iubris.socrates.config.xml.PlaceConfigXml;
import net.iubris.socrates.config.xml.PlaceConfigXmlParser;

public class PlaceConfigXmlProvider implements Provider<PlaceConfigXml> {

	private PlaceConfigXmlParser placeConfigXmlParser;
			
	@Inject
	public PlaceConfigXmlProvider(	PlaceConfigXmlParser placeConfigXmlParser) {
		this.placeConfigXmlParser = placeConfigXmlParser;
	}

	@Override
	public PlaceConfigXml get() {
		return placeConfigXmlParser.getPlaceConfig();
	}
}
