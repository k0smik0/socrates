/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceConfigXmlParser.java is part of socrates_config-xml.
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
package net.iubris.socrates.config.xml;



public class PlaceConfigXmlParser {
	
	private XmlAssetReader<PlaceConfigXml> xmlAssetReader;

	@Inject
	public PlaceConfigXmlParser(XmlAssetReader<PlaceConfigXml> xmlAssetReader) {
		this.xmlAssetReader = xmlAssetReader;
	}
	
	public PlaceConfigXml getPlaceConfig() {
		try {
			return xmlAssetReader.parse("places_config.xml", PlaceConfigXml.class);
		} catch (XmlAssetReaderFileNotFoundException e) {
			e.printStackTrace();
		} catch (XmlReaderParsingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
