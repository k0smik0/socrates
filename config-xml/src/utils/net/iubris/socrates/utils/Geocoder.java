/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Geocoder.java is part of socrates_config-xml.
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
package net.iubris.socrates.utils;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import android.location.Location;

public class Geocoder {

	public static String getPostalCode(Location location) {
		XPath xpath = XPathFactory.newInstance().newXPath();
		String expression = "//GeocodeResponse/result/address_component[type=\"postal_code\"]/long_name/text()";
		InputSource inputSource = new InputSource("https://maps.googleapis.com/maps/api/geocode/xml?latlng="+location.getLatitude()+","+location.getLongitude()+"&sensor=true");
		String zipcode = "";
		try {
			zipcode = (String) xpath.evaluate(expression, inputSource, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}		
		return zipcode;
	}
	
}
