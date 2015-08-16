/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * ConfigMandatoryImpl.java is part of 'Socrates'.
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
package socrates.test.config;

import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.model.http.request.url.output.HttpParserOutputType;

/*
@Provides
Class<PlacesList> providePlaceListClass() {
	return PlacesList.class;
}*/
public final class ConfigMandatoryImpl implements ConfigMandatory{
	@Override
	public boolean isUseSensor() {
		return true;
	}

	@Override
	public HttpParserOutputType getOutput() {				
		return HttpParserOutputType.json;
	}
	@Override
	public String getKey() {				
//		return "AIzaSyAfOlNmRr5G-4BPDd1faYsn9kvkV5ebBRk"; // ks 
//		return "AIzaSyCNC3beu2WTmnkQTApJaJDi9VHSRnA44ic"; // mx android not working
		return "AIzaSyDH2AVfxJJm3V3EVzX991Za2oyICCLcgpM"; // mx browser working
		/*
		 * 10:32:7F:72:53:D0:62:2D:FB:CA:66:B9:3D:C3:98:27:64:30:15:54;net.iubris.ratafia
FF:3B:4F:62:43:EF:7F:05:6A:EC:65:D9:27:74:F4:45:91:2A:13:2C;net.iubris.ratafia
		 */
		
	}

	@Override
	public String getApplicationName() {				
		return "SocratesDemo";
	}
}
